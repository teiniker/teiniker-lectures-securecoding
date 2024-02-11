How to test the HTTPS server?
-------------------------------------------------------------------------------

Server:
$ java -cp target/classes/ -Djavax.net.ssl.keyStore=./SSLKeyStore  -Djavax.net.ssl.keyStorePassword=student org.se.lab.HttpServer


Client:
$ curl -k -i -X GET https://localhost:8443/index.html


How to Generate a Certificate?
-------------------------------------------------------------------------------

$ keytool -genkey -keystore SSLKeyStore -alias SSLCertificateWithRSA -keyalg RSA

=> password: student
