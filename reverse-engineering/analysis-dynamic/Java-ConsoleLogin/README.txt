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


2. Start VisualVM
------------------
While the target application is running, start:

$ visualvm --fontsize 20

Double click on the right PID
Tab Monitor -> Heap Dump
Tab Classes -> look for a class named org.se.lab.ConsoleLogin 
Double click on it -> Review the stored data

Object Query Language (OQL):
> select u.password from org.se.lab.ConsoleLogin u


