# Java Just-In-Time (JIT) Compiler

A Java Just-In-Time (JIT) compiler is a component of the Java Runtime Environment (JRE) 
that improves the performance of Java applications by compiling bytecode into native 
machine code at runtime. 

Unlike a traditional compiler that compiles code before the application runs, a JIT 
compiler does this during the execution of the program. 

This allows for more optimized code because the compiler can make **decisions based on 
real-time data and usage patterns**. The JIT-compiled code is usually faster and more 
efficient, leading to improved performance of Java applications.

_Example_: JIT monitoring for Loop.java
```
$ java -XX:+PrintCompilation -cp ./target/classes org.se.lab.Loop
     26    1       3       java.lang.Object::<init> (1 bytes)
     27    2       3       java.lang.String::coder (15 bytes)
     29    3       3       java.lang.String::isLatin1 (19 bytes)
    ...
    116  157       4       java.lang.StringConcatHelper::newString (67 bytes)
    117  125       3       java.lang.StringConcatHelper::newString (67 bytes)   made not entrant
    205  158       4       org.se.lab.Loop::add (8 bytes)
    218  126       3       org.se.lab.Loop::add (8 bytes)   made not entrant
    218  159       4       java.lang.StringConcatHelper::prepend (22 bytes)
    219  144       3       java.lang.StringConcatHelper::prepend (22 bytes)   made not entrant
```

The meaning of the individual columns can be seen in the following diagram:
```
  26    1       3       java.lang.Object::<init> (1 bytes)
  ┬─────┘    ┬      ┬        └──────────── method (class::name, signature) + code size or “(native)”
  │          │      │
  │          │      └─── Compilation level / flags column
  │          │            1..3 = C1 tiers (client compiler), 4 = C2 (server compiler)
  │          │            %     = OSR (on-stack replacement) compile; number after it is the bci
  │          │            n     = native method (no Java bytecodes)
  │          │            s     = synchronized method (flag)
  │          │            (others occur rarely: e.g., ! after a method shows a deopt/uncommon trap later)
  │          │
  │          └──────── Compilation ID (monotonic counter)
  │
  └────────── Time since JVM start in milliseconds
```


Using the `-XX:+CITime` flag outputs various statistics about compilations:
```
$ java -XX:+CITime -cp ./target/classes org.se.lab.Loop
 		
 Accumulated compiler times (for compiled methods only)
------------------------------------------------
  Total compilation time   :  0.006 s
    Standard compilation   :  0.006 s, Average : 0.000
    On stack replacement   :  0.000 s, Average : -nan
    Detailed C1 Timings
       Setup time:         0.000 s ( 0.0%)
       Build IR:           0.002 s (38.0%)
         Optimize:            0.000 s ( 4.3%)
         RCE:                 0.000 s ( 1.8%)
       Emit LIR:           0.003 s (45.6%)
         LIR Gen:           0.000 s ( 6.5%)
         Linear Scan:       0.002 s (38.0%)
       LIR Schedule:       0.000 s ( 0.0%)
       Code Emission:      0.001 s (11.6%)
       Code Installation:  0.000 s ( 4.9%)
       Instruction Nodes:   1743 nodes

  Total compiled methods   :     29 methods
    Standard compilation   :     29 methods
    On stack replacement   :      0 methods
  Total compiled bytecodes :   2805 bytes
    Standard compilation   :   2805 bytes
    On stack replacement   :      0 bytes
  Average compilation speed: 483420 bytes/s

  nmethod code size        :  10592 bytes
  nmethod total size       :  26792 bytes
```

## References
* [Baeldung: Tiered Compilation in JVM](https://www.baeldung.com/jvm-tiered-compilation)
* Charlie Hunt. **Java Performance**. Addison-Wesley Professional, 2011.

*Egon Teiniker, 2016-2025, GPL v3.0*