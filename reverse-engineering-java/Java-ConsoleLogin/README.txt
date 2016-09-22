How to perform a dynamic analysis using JVisualVM?
-------------------------------------------------------------------------------

1. Start the application from the command line
----------------------------------------------

$ cd Java-ConsoleLogin

$ java -cp target/classes/ org.se.lab.Main

username > homer
password > xxxxxxxx

username >


Note that this application is running until you enter:
username > homer
password > superhomer


2. Start JVisualVM
------------------
While the target application is running, start:

$ jvisualvm

Double click on the right PID
Tab Monitor -> Heap Dump
Tab Classes -> look for a class named org.se.lab.ConsoleLogin 
Double click on it -> Review the stored data


How to use JavaSnoop?
-------------------------------------------------------------------------------
https://code.google.com/archive/p/javasnoop/downloads

a) Start JavaSnoop
$ pwd
JavaSnoop

$ ./startup.sh 
[0] Detected Linux
[1] Found JAVA_HOME environment variable. Using JDK in /usr/java/jdk1.8.0_60
[2] Turning off Java security for JavaSnoop usage
[3] Starting JavaSnoop...

b) Start ConsoleLogin
$ pwd
Java-ConsoleLogin

$ java -cp target/classes org.se.lab.Main
username >

c) JavaSnoop
[Attach&Snoop] => select PID for org.se.lab.Main => [Use this as session (and attach)]

[Add New Hook...] => Class [Browse] => org.se.lab.ConsoleLogin => select setPassword(String) => [Add New Hook]
	=> Print parameters (to console)
	=> Tamper with parameters
	
d) back to ConsoleLogin
username > homer
password > homer
=> JavaSnoop: Edit Method Parameters
=> change value from "homer" to "superhomer" [Enter]
Welcome!

Note that we can also intercept isValid() and change the value of the result.
JavaSnoop is like Burp for Java Code!!!	






