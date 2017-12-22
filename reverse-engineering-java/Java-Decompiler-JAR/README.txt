How to run this example?
---------------------------------------------------------------------

$ java -jar dist/Java-Decompiler-JAR.jar secret-message
8c8b49378652f8af3b3997235cae003a


How to extract a JAR file?
---------------------------------------------------------------------

$ mkdir tmp
$ cd tmp

# List the JAR file's content

$ jar -xfv ../dist/Java-Decompiler-JAR.jar

META-INF/
META-INF/MANIFEST.MF
org/
org/se/
org/se/lab/
org/se/lab/Utility.class
org/se/lab/SecureWriter.class
META-INF/maven/
META-INF/maven/org.se.lab/
META-INF/maven/org.se.lab/Java-Decompiler-JAR/
META-INF/maven/org.se.lab/Java-Decompiler-JAR/pom.xml
META-INF/maven/org.se.lab/Java-Decompiler-JAR/pom.properties

# Extract JAR file

$ jar -xf Java-Decompiler-JAR.jar
$ tree
.
├── Java-Decompiler-JAR.jar
├── META-INF
│   ├── MANIFEST.MF
│   └── maven
│       └── org.se.lab
│           └── Java-Decompiler-JAR
│               ├── pom.properties
│               └── pom.xml
└── org
    └── se
        └── lab
            ├── SecureWriter.class
            └── Utility.class

$ cat META-INF/MANIFEST.MF
Manifest-Version: 1.0
Created-By: 1.8.0_144 (Oracle Corporation)
Main-Class: org.se.lab.SecureWriter


How to create a JAR file?
---------------------------------------------------------------------

$ vi MANIFEST.MF
Manifest-Version: 1.0
Main-Class: org.se.lab.SecureWriter

$ jar cfm Java-Decompiler-JAR.jar MANIFEST.MF ./


How to attack a Java JAR file using a Decompiler
---------------------------------------------------------------------
1) Extract Java-Decompiler-JAR.jar

2) Use jd-gui to decompile SecurityWriter.class

3) Create SecurityWriter.java and modify the code

4) Compile SecurityWriter.java
    $ javac SecureWriter.java
    $ mv SecureWriter.class org/se/lab/

5) Test your changes
    $ java org.se.lab.SecureWriter hello

6) Re-create  Java-Decompiler-JAR.jar

    $ vi MANIFEST.MF
    Manifest-Version: 1.0
    Main-Class: org.se.lab.SecureWriter

    $ jar cfm Java-Decompiler-JAR.jar MANIFEST.MF ./

7) Test the modified Java-Decompiler-JAR.jar file
    $ java -jar Java-Decompiler-JAR.jar secret-message
    secret-message

Note that in the case of using additional libraries, we have to specify the CLASSPATH
using the -cp flag of the Java compiler.
