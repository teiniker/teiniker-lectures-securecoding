How to test the ASM Framework
---------------------------------------------------------------------

Run the "ASMDumpTest" to generate a Hello.class file in the build
directory.

On the command line, switch to the project directory and type:

├── target/classes
│   ├── asm
│   │   └── org
│   │       └── se
│   │           └── lab
│   │               └── HelloDump.class


$ java -cp target/classes org.se.lab.Hello Homer
Pleased To Meet You, Homer!
 
Note that there is no Java source code for the Hello class. The class
file will be generated from the HelloDump class.



How to generate a DumpHello class?
---------------------------------------------------------------------

$ mkdir gen/asm/org/se/lab/
$ java -cp lib/asm-all-4.2.jar:../Java-HelloWorld/target/classes org.objectweb.asm.util.ASMifier org.se.lab.Hello > gen/asm/org/se/lab/HelloDump.java

=> organize imports!!!




		