How to Generate a Certificate?
-------------------------------------------------------------------------------

$ keytool -genkey  -keyalg RSA -alias SSLCertificateWithRSA -storepass student -keystore SSLKeyStore


How to Start the Server?
-------------------------------------------------------------------------------

$ java -cp ./target/classes -Djavax.net.ssl.keyStore=./SSLKeyStore  -Djavax.net.ssl.keyStorePassword=student org.se.lab.SSLDaytimeServer


How to Start the Client?
-------------------------------------------------------------------------------

$ java -cp ./target/classes -Djavax.net.ssl.trustStore=./SSLKeyStore -Djavax.net.ssl.trustStorePassword=student org.se.lab.SSLDaytimeClient

To get more information about the network communication we can add the following flag: -Djavax.net.debug=all
