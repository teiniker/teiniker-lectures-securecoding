The try-with-resources Statement
---------------------------------------------------------------------

The try-with-resources statement is a try statement that declares one 
or more resources. A resource is an object that must be closed after 
the program is finished with it. The try-with-resources statement 
ensures that each resource is closed at the end of the statement. 

Any object that implements java.lang.AutoCloseable, which includes 
all objects which implement java.io.Closeable, can be used as a 
resource.
