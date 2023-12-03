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
    144    1             java.lang.String::hashCode (67 bytes)
    158    2             sun.nio.cs.UTF_8$Encoder::encode (361 bytes)
    167    3             java.lang.String::charAt (33 bytes)
    169    4             java.lang.String::indexOf (87 bytes)
    177    5             java.lang.Object::<init> (1 bytes)
    199    6             java.lang.AbstractStringBuilder::ensureCapacityInternal (16 bytes)
    202    7     n       java.lang.System::arraycopy (0 bytes)   (static)
    203    8             java.lang.String::length (5 bytes)
    204    9             java.lang.Integer::stringSize (21 bytes)
    208   10             java.lang.Integer::getChars (131 bytes)
    221   11             java.lang.Math::min (11 bytes)
    232   12             java.lang.String::getChars (66 bytes)
    234   13             java.lang.AbstractStringBuilder::append (48 bytes)
    239   14             java.lang.StringBuilder::append (8 bytes)
    240   15             java.lang.String::<init> (72 bytes)
    245   16             java.util.Arrays::copyOfRange (63 bytes)
    247   17             java.lang.AbstractStringBuilder::<init> (12 bytes)
    248   18             java.lang.StringBuilder::toString (17 bytes)
    249   19             java.lang.StringBuilder::append (8 bytes)
    250   20             java.lang.AbstractStringBuilder::append (29 bytes)
    252   21             java.lang.String::valueOf (14 bytes)
    259   22             org.se.lab.Loop::add (24 bytes)
    260   23             java.lang.String::toString (2 bytes)
    261   24             java.lang.StringBuilder::<init> (18 bytes)
    261   25             java.lang.StringBuilder::append (8 bytes)
    269   26             java.lang.AbstractStringBuilder::append (62 bytes)
   1625    1 %           org.se.lab.Loop::main @ 8 (31 bytes)
```

The meaning of the individual columns can be seen in the following list:
* column 1:	Time (in ms) since the JVM started
* column 2: Compilation ID  
* column 3: Flags that indicate properties of the compiled method
  - n: wrapper to a native method
  - s: method is synchronized
  - b: compilation occured in blocking mode
  - !: method has an exception handler
  - %: compilation is OSR 

* column 4: Qualified name of the method (number of bytes of bytecode
contained in the method being compiled).

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

*Egon Teiniker, 2016-2023, GPL v3.0*