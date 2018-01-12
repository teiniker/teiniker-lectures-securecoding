The Java Cryptography Architecture (JCA)
---------------------------------------------------------------------

There is little reference to actual algorithm implementation in the 
classes and interfaces of the JCA.
Instead, the JCA is architected to provide an abstraction layer for
application developers, and the objects that provide the implementations 
of the algorithms you wish to use are created using factory classes.

This architecture is referred as provider-based architecture.

New implementations of algorithms can be added without increasing the 
complexity of the API.


Provider-Based Architecture
---------------------------------------------------------------------
When we instantiate a JCA object that is created using the getInstance()
factory pattern, we can either specify the provider we wish to use or
leave it up to the Java runtime to choose the provider for us.

Example: MessageDigest.getInstance("SHA-1", "BC");
	The Bouncy Castle provider is used to create the object.

Example: MessageDigest.getInstance("SHA-1");
	The Java runtime will select the first provider it can find that
	can satisfy the request, according to the list of providers in the 
	java.security file.
	Providers with a lower preference number take precedence over
	those with a higher one.

In general, if we deploy an application it is a good idea to specify 
the provider in addition to the full algorithm name for the JCA objects
we want to use.
Relying on precedence rules can result in troubles if there are 
incompatibilities that we are not aware of between providers.
 

How to add a new provider?
---------------------------------------------------------------------

1. Download provider JAR file.
	http://www.bouncycastle.org/latest_releases.html
	=> bcprov-ext-jdk15on-159.jar
  
2. Install the JAR file into the Java runtime  
  	$ su
  	root66
  	# cp bcprov-ext-jdk15on-159.jar /usr/java/jdk1.8.0_144/jre/lib/ext/
  	
  	
  	Add the BC provider to the java.security file:
  	
  	# vi /usr/java/jdk1.8.0_144/jre/lib/security/java.security

	#
	# List of providers and their preference orders (see above):
	#
	security.provider.1=sun.security.provider.Sun
	security.provider.2=sun.security.rsa.SunRsaSign
	security.provider.3=sun.security.ec.SunEC
	security.provider.4=com.sun.net.ssl.internal.ssl.Provider
	security.provider.5=com.sun.crypto.provider.SunJCE
	security.provider.6=sun.security.jgss.SunProvider
	security.provider.7=com.sun.security.sasl.Provider
	security.provider.8=org.jcp.xml.dsig.internal.dom.XMLDSigRI
	security.provider.9=sun.security.smartcardio.SunPCSC

	security.provider.10=org.bouncycastle.jce.provider.BouncyCastleProvider
  	
  	
Example: ProviderTest.testProviderInfo()
  	=> BouncyCastle Security Provider v1.59
  		
Example: ProviderTest.testSHA1WithNewProvider()
  	=> BouncyCastle Security Provider v1.50
  	

How to examine the provider capabilities?
---------------------------------------------------------------------
Providers make their capabilities available to the JCA using a property
table.

Example: ProviderTest.testProviderCapabilities()

Signature: GOST-3410
Cipher: PBEWITHMD5AND128BITAES-CBC-OPENSSL
Signature: DSAWithSHA1
Signature: MD2WITHRSA
AlgorithmParameters: 1.3.6.1.4.1.22554.1.2.1.2.1.42
KeyGenerator: CAMELLIA
Signature: SHA1WITHDETDSA
Signature: SHA224WITHRSAANDMGF1
Signature: RMD256/RSA
Signature: 1.3.36.3.3.2.2
Mac: POLY1305-SEED
Signature: 1.3.36.3.3.2.1
AlgorithmParameters: PBEWITHSHA256AND256BITAES-CBC-BC
KeyGenerator: HMAC-TIGER
KeyGenerator: HMAC/WHIRLPOOL
Cipher: 1.2.410.200004.1.4
KeyGenerator: Skein-MAC-512-384
SecretKeyFactory: PBEWITHSHA1ANDRC2
KeyGenerator: Shacal2
Mac: Skein-MAC512/224
Cipher: 2.16.840.1.101.3.4.1.24
Signature: 1.2.840.10045.4.1
Signature: SHA384WITHDETECDSA
...


References:
---------------------------------------------------------------------

David Hook
Beginning Cryptography with Java
Wrox, 2005  		