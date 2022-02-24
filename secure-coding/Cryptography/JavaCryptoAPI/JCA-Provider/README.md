# Java Cryptography Architecture (JCA)

The JCA is architected to provide an abstraction layer for
application developers, and the objects that provide the implementations
of the algorithms you wish to use are created using factory classes.

This architecture is referred as **provider-based architecture** where new 
implementations of algorithms can be added without increasing the
complexity of the API.

## Provider-Based Architecture
When we instantiate a JCA object that is created using the `getInstance()`
factory pattern, we can either specify the provider we wish to use or
leave it up to the Java runtime to choose the provider for us.

_Example_: `MessageDigest.getInstance("SHA-1");`\
The Java runtime will select the first provider it can find that
can satisfy the request, according to the list of providers in the
`conf/security/java.security` file.
Providers with a lower preference number take precedence over
those with a higher one.

_Example_: `MessageDigest.getInstance("SHA-1", "BC");`\
The Bouncy Castle provider is used to create the object.

In general, if we deploy an application it is a good idea to specify
the provider in addition to the full algorithm name for the JCA objects
we want to use.
Relying on precedence rules can result in troubles if there are
incompatibilities that we are not aware of between providers.

## Using the Bouncy Castle Provider

The Bouncy Castle project is an open source provider for the 
Java Cryptography Extension (JCE) and the Java Cryptography Architecture (JCA).

Adding Bouncy Castle as a additional provider needs the following steps:

* Add a dependency to the `pom.xml` file:
```
  <dependency>
      <groupId>org.bouncycastle</groupId>
      <artifactId>bcprov-jdk16</artifactId>
      <version>1.46</version>
  </dependency>
```

* Add a new line in the `conf/security/java.security` file of the JDK.
```
$ vi /opt/java/jdk-17/conf/security/java.security
#
# List of providers and their preference orders (see above):
#
security.provider.1=SUN
security.provider.2=SunRsaSign
security.provider.3=SunEC
security.provider.4=SunJSSE
security.provider.5=SunJCE
security.provider.6=SunJGSS
security.provider.7=SunSASL
security.provider.8=XMLDSig
security.provider.9=SunPCSC
security.provider.10=JdkLDAP
security.provider.11=JdkSASL
security.provider.12=SunPKCS11
security.provider.13=org.bouncycastle.jce.provider.BouncyCastleProvider  # add this line
```
* Verify that the new provider is part of the provider list. 
  Simply run `ProviderTest.testProviderInfo()`.
```Java
    @Test
    public void testProviderInfo()
    {
        Provider[] providers = Security.getProviders();
        for(Provider p : providers)
        {
            System.out.println(p.getInfo());
        }
    }
```

The test creates the following output: 
```
SUN (DSA key/parameter generation; DSA signing; SHA-1, MD5 digests; SecureRandom; X.509 certificates; PKCS12, JKS & DKS keystores; PKIX CertPathValidator; PKIX CertPathBuilder; LDAP, Collection CertStores, JavaPolicy Policy; JavaLoginConfig Configuration)
Sun RSA signature provider
Sun Elliptic Curve provider
Sun JSSE provider(PKCS12, SunX509/PKIX key/trust factories, SSLv3/TLSv1/TLSv1.1/TLSv1.2/TLSv1.3/DTLSv1.0/DTLSv1.2)
SunJCE Provider (implements RSA, DES, Triple DES, AES, Blowfish, ARCFOUR, RC2, PBE, Diffie-Hellman, HMAC, ChaCha20)
Sun (Kerberos v5, SPNEGO)
Sun SASL provider(implements client mechanisms for: DIGEST-MD5, EXTERNAL, PLAIN, CRAM-MD5, NTLM; server mechanisms for: DIGEST-MD5, CRAM-MD5, NTLM)
XMLDSig (DOM XMLSignatureFactory; DOM KeyInfoFactory; C14N 1.0, C14N 1.1, Exclusive C14N, Base64, Enveloped, XPath, XPath2, XSLT TransformServices)
Sun PC/SC provider
JdkLDAP Provider (implements LDAP CertStore)
JDK SASL provider(implements client and server mechanisms for GSSAPI)
Unconfigured and unusable PKCS11 provider
BouncyCastle Security Provider v1.46     
```
As the last entry we can see the new BouncyCastle provider.

We can also list the implemented algorithms of the BouncyCastle provider by running the
`ProviderTest.testProviderCapabilities()` test case.

## References
* [The Legion of the Bouncy Castle](https://www.bouncycastle.org/java.html)

* David Hook. **Beginning Cryptography with Java**. Wrox, 2005
  * Chapter 1: The JCA and the JCE

*Egon Teiniker, 2016-2022, GPL v3.0*
