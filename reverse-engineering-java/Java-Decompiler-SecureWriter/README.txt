How to install the Java Decompiler jd
---------------------------------------------------------------------

http://jd.benow.ca/


How to attack a Java class file using a Decompiler
---------------------------------------------------------------------

This little class, created in the Eclipse IDE, reads a text from
the command line, encrypts this text and prints the encrypted version
back to the console.

Example:
	$ java -cp ./target/classes org.se.lab.SecureWriter Hello
	559a15168f732657947cc6fd64cbfe98

As an attacker, we can use a Java decompiler to disable the encryption
in this class:

$ pwd
Java-Decompiler-SecureWriter

$ mkdir tmp
$ cd tmp/

$ ~/install/jd-gui/
Load the SecureWriter.class file into the decompiler and save the 
generated source code into the file tmp/SecureWriter.java

$ vi SecureWriter.java
Change the code to bypass the encryption...


$ javac -cp ../target/classes SecureWriter.java 
$ cp SecureWriter.class ../target/classes/org/se/lab/

$ cd ..
$ java -cp ./target/classes org.se.lab.SecureWriter Hello
Hello

$ rm -rf tmp/

 