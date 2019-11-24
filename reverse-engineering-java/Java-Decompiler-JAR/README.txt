How to run this example?
---------------------------------------------------------------------

$ java -cp dist/Java-Decompiler-SecureWriter.jar org.se.lab.SecureWriter secret-message
8c8b49378652f8af3b3997235cae003a


How to attack a Java JAR file using a Decompiler
---------------------------------------------------------------------
1) Extract Java-Decompiler-SecureWriter.jar

2) Use jd-gui to decompile SecurityWriter.class

3) Create SecurityWriter.java and modify the code

4) Compile SecurityWriter.java
    $ javac SecureWriter.java
    $ mv SecureWriter.class org/se/lab/

5) Test your changes
    $ java org.se.lab.SecureWriter hello

6) Re-create Java-Decompiler-SecureWriter.jar

    $ jar -cvf Java-Decompiler-SecureWriter.jar ./

7) Test the modified Java-Decompiler-JAR.jar file
    $ java -cp dist/Java-Decompiler-SecureWriter.jar org.se.lab.SecureWriter secret-message
    secret-message

Note that in the case of using additional libraries, we have to specify the CLASSPATH
using the -cp flag of the Java compiler.


How to extract a JAR file?
---------------------------------------------------------------------

$ mkdir tmp
$ cd tmp

# List the JAR file's content

$ jar -tf ../dist/Java-Decompiler-SecureWriter.jar

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

$ jar -xvf Java-Decompiler-SecureWriter.jar
$ tree
.
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


How to create a JAR file?
---------------------------------------------------------------------

$ jar -cvf Java-Decompiler-SecureWriter.jar


