Secure Copy via SSL 
-------------------------------------------------------------------------------

Client and server communication should be implemented in a secure way using SSL.

To generate a certificate use the keytool:

$ keytool -genkey -keystore SSLKeyStore -alias SSLCertificateWithRSA -keyalg RSA


1. Secure Copy Server
-------------------------------------------------------------------------------
Run the ScpServer:

$ java -cp ./target/classes -Djavax.net.ssl.keyStore=./SSLKeyStore  -Djavax.net.ssl.keyStorePassword=student org.se.lab.ScpServer 8010 mytux.jpg

The server listens on port 8010 for an input stream, stores the bytes into a binary 
file (e.g. "mytux.jpg"), and terminates.


2. Secure Copy Client
-------------------------------------------------------------------------------
Run the ScpClient:

$ java -cp ./target/classes -Djavax.net.ssl.trustStore=./SSLKeyStore -Djavax.net.ssl.trustStorePassword=student org.se.lab.ScpClient tux.jpg localhost 8010 

The client opens a binary file ("tux.jpg" in that case), connects to the given
server process (here localhost port 8010), sends the bytes from the file
to the server, and terminates. 


