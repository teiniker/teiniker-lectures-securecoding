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
    $ java -cp ./ org.se.lab.SecureWriter hello

6) Re-create Java-Decompiler-SecureWriter.jar

    $ jar -cvf Java-Decompiler-SecureWriter.jar ./

7) Test the modified Java-Decompiler-JAR.jar file
    $ java -cp dist/Java-Decompiler-SecureWriter.jar org.se.lab.SecureWriter secret-message
    secret-message

Note that in the case of using additional libraries, we have to specify the CLASSPATH
using the -cp flag of the Java compiler.

