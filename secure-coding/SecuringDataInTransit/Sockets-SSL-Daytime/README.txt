How to Generate a Certificate?
-------------------------------------------------------------------------------

$ keytool -genkey -keystore SSLKeyStore -alias SSLCertificateWithRSA -keyalg RSA

=> password: student



How to Start the Server?
-------------------------------------------------------------------------------

$ java -cp ./target/classes -Djavax.net.ssl.keyStore=./SSLKeyStore  -Djavax.net.ssl.keyStorePassword=student org.se.lab.SSLDaytimeServer


How to Start the Client?
-------------------------------------------------------------------------------

$ java -cp ./target/classes -Djavax.net.ssl.trustStore=./SSLKeyStore -Djavax.net.ssl.trustStorePassword=student org.se.lab.SSLDaytimeClient

To get more information about the network communication we can add the following flag: -Djavax.net.debug=all 

Cipher Suites
-------------------------------------------------------------------------------
TLS uses different algorithms at various stages of creating and managing a secure
socket. These combinations of algorithms are referred to as cipher suites.

If the two endpoints of a network connection do not share a common suite, the
connection will fail before any application data is transmitted.

Example: TLS_RSA_WITH_AES_256_CBC_SHA256

TLS                 Identifies the suites as TLS (opposed to SSL)
RSA                 The key exchange and authentication algorithm.
WITH_AES_256_CBC    The specification of the bulk encryption cipher, its key size and mode.
SHA256              The message authentication algorithm

Note that this pattern can vary but general rules are:
- Don't use suites that list ANON for authentication (they don't provide authentication)
- Don't use suites that contain NULL.
- Avoid use of suites that contain EXPORT.
- Use bulk ciphers with key size of 128 bits or larger
- Try to avoid suites using RC4, DES and 3DES
Prefer ECDHE and DHE for key agreement. While they are slower, they provide stronger
protection even if the private keys are later compromised (forward security)

References:
-------------------------------------------------------------------------------
Jim Manico, August Detlefsen
Iron-Clad Java: Building Secure Web Applications
Chapter 6: Protecting Sensitive Data
Oracle Press, 2014



