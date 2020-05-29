Sockets: HTTP Server + Client
---------------------------------------------------------------------

This example implements a simplified HTTP server (single-threaded) to
show how the HTTP protocol works.


How to Start the HTTP Server?
---------------------------------------------------------------------

$ java -cp target/classes/ org.se.lab.HttpServer


How to Access the HTTP Server from a Browser?
---------------------------------------------------------------------

URL: http://localhost:8080/index.html


How to Access the HTTP Server from a JUnit Test?
---------------------------------------------------------------------

Run the HTTPClientTest.


How to Access the HTTP Server from a Bash?
---------------------------------------------------------------------

$ curl -i -X GET http://localhost:8080/index.html    
    
-i	Include the HTTP-header in the  output.     

-X	Specifies a custom request method to use when communicating with 
	the HTTP server.  The specified request  will  be  used instead  
	of  the  method otherwise used (which defaults to GET).
    
    
    