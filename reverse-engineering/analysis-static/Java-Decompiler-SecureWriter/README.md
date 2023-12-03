# Decompile Java Class Files

The given implementation reads a text from the command line, encrypts it
and prints the encrypted version of the text back to the console window.

_Example_: Encrypt the given string
```  
    $ mvn compile
	
    $ java -cp ./target/classes org.se.lab.SecureWriter Hello
	559a15168f732657947cc6fd64cbfe98
```

Attackers can use a **Java Decompiler** to analyze the compiled class file:
* Start the decompiler
```
  $ cd jd-gui/
  $ java -jar jd-gui-1.6.6.jar
```
* Load a class (or JAR) file:
```
  Java-Decompiler-SecureWriter/target/classes/org/se/lab/SecureWriter.class
```
* Analyze the decompiled source code (in the given example, compare the decompiled code
   with the original source code).

Notice how easy it is to decompile Java class files (and also JAR files).
This is due to the way Java optimizes the bytecode. 
**Most optimizations are done just-in-time at runtime** of the program and 
not at compile time.

## References
* [Java Decompiler](http://java-decompiler.github.io/)

*Egon Teiniker, 2020-2023, GPL v3.0*