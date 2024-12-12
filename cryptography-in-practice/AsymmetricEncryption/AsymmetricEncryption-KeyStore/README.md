# KeyStore

KeyStores are a **storage mechanism** where we can have **a number of keys stored in a single file**. 
This file is encrypted itself and has both per-store and per-key passwords.

Three are three kinds of entries can be stored in a keystore depending on the types of keystores:

* **PrivateKey**: This is a type of keys which are used in asymmetric cryptography. It is usually protected with 
    password because of its sensitivity. It can also be used to sign a digital signature.

* **Certificate**: A certificate contains a public key which can identify the subject claimed in the certificate. 
    It is usually used to verify the identity of a server. Sometimes it is also used to identify a
    client when requested.

* **SecretKey**: A key entry which is sued in symmetric cryptography.


Depending on what entries the keystore can store and how the keystore can store the entries, there are a few different 
types of keystores in Java:

* **Java Key Store (JKS)**: We can find this file at `sun.security.provider.JavaKeyStore`.
    This keystore is **Java specific**, it usually has an extension of **.jks**.
    This type of keystore can contain **private keys and certificates**, but it cannot be used to store secret keys. 
    Since it's a Java specific keystore, so it cannot be used in other programming languages.
    The private keys stored in JKS cannot be extracted in Java.

* **Java Cryptography Extension KeyStore (JCEKS)**: It is a super set of JKS with more algorithms supported.
    This keystore has an extension of **.jceks**. The entries which can be put in the JCEKS keystore are **private keys**, 
    **secret keys** and **certificates**.
    This keystore provides much stronger protection for stored private keys by using Triple DES encryption.
    The provider of JCEKS is SunJCE, it was introduced in Java 1.4.

* **PKCS12**: This is a **standard keystore type** which can be used in Java and **other languages**. It usually has 
    an extension of **.p12** or **.pfx**. We can store **private keys**, **secret keys** and **certificates** on this type.
    Unlike JKS, the private keys on PKCS12 keystore can be extracted in Java.
    This type is portable and can be operated with other libraries written in other languages such as C, C++ or C#.

* **PKCS11**: This is a **hardware keystore** type. It provides an interface for the Java library to connect with 
    hardware keystore devices such as SafeNet's Luna, nCipher or Smart cards.

* **Domain KeyStore (DKS)** is a **keystore of keystore**. It abstracts a collection of
    keystores that are presented as a single logical keystore. 
    Itself is actually not a keystore. This new keystore type is introduced in Java 8.

* **BoucyCastle Keystore (BKS)**: This is a keystore format provided the popular third party Java cryptographic library 
    provider - BouncyCastle.
    It is a keystore similar to the JKS provided by Oracle JDK. But it supports storing **secret key**, **private key** 
    and **certificate**. It is frequently used in mobile application developments.


The **default keystore type** has been changed to **PKCS12 in Java 9** because its enhanced compatibility compared
to JKS.

## Generate a Keystore 

To generate a keystore we can use the **keytool**:
```
$ cd src/test/resources/
$ keytool -storetype PKCS12 -genkeypair -alias testkey -storepass student -keypass student -keyalg RSA -keysize 4096 -keystore keystore.pfx

What is your first and last name?
  [Unknown]:  Egon Teiniker
What is the name of your organizational unit?
  [Unknown]:  IMS
What is the name of your organization?
  [Unknown]:  FHJ
What is the name of your City or Locality?
  [Unknown]:  KBerg
What is the name of your State or Province?
  [Unknown]:  Styria
What is the two-letter country code for this unit?
  [Unknown]:  AT
Is CN=Egon Teiniker, OU=IMS, O=FHJ, L=KBerg, ST=Styria, C=AT correct?
  [no]:  yes
```
Parameters:
* **-genkeypair**: Generates a key pair (a public key and associated private key). 
  Wraps the public key into an X.509 v3 self-signed certificate, which is stored 
  as a single-element certificate chain. 
    
  This certificate chain and the private key are stored in a new keystore entry 
  identified by alias.
* **-storetype**: Keystore type
* **-alias**:  Alias name of the entry to process
* **-storepass**:  Keystore password
* **-keypass**: Key password
* **-keyalg**: Key algorithm name
* **-keysize**: Key bit size
* **-keystore**: Keystore name

We can **list the content of a keystore** by using the following command:
```
$ keytool -list -v -keystore keystore.pfx 
Enter keystore password: student 
```
Parameters:
* **-list**: Prints to stdout the contents of the keystore entry identified by alias. If no alias is specified, 
    then the contents of the entire keystore are printed.
* **-v**: Verbose output
* **-keystore**: Keystore name
* **-storepass**:  Keystore password 


## Export the Certificate

Because **keystore.pfx** file **contains your private keys**, we need another
keystore that contains only your public keys to share with the outside world.
```
$ keytool -export -v -keystore keystore.pfx -alias testkey -file testkey.cert -storepass student -keypass student
```


## Import the Certificate into a Keystore
```
$ keytool -import -v -keystore certificates.pfx -alias testkey-cert -file testkey.cert -storepass student -keypass student
```


## Converting a Java Keystore Into PEM Format

In this section, we will convert a Java KeyStore into **PEM (Privacy-Enhanced Mail)** format using a combination
of `keytool` and `openssl`.

PEM files are certificate containers — they encode binary data using Base64, which allows the content to be
transmitted more easily through different systems. A PEM file may contain multiple instances, with each instance
adhering to two rules:
```
A one-line header of -----BEGIN <label>-----
A one-line footer of -----END <label>-----
```
`<label>` specifies the type of the encoded message, common values being `CERTIFICATE` and `PRIVATE KEY`.

We **convert a keystore into a PEM file** with the following OpenSSL command:
```
$ openssl pkcs12 -in keystore.pfx -out keystore.pem
```

OpenSSL will prompt us for the `PKCS#12` KeyStore password and a PEM passphrase for each alias.
The PEM passphrase is used to **encrypt the resulting private key**.

If we don’t want to encrypt the resulting private key, we should instead use:
```
$ openssl pkcs12 -nodes -in keystore.pfx -out keystore.pem
```
`keystore.pem` will contain all of the keys and certificates from the KeyStore.

We can export a single public key certificate out of a JKS and into PEM format using `keytool`
alone:
```
$ keytool -exportcert -alias testkey -keystore keystore.pfx -rfc -file first-key-pair-cert.pem
```

## References
* David Hook. **Beginning Cryptography with Java**. Wrox, 2005. 
      Chapter 6: Distinguished Names and Certificates

* [keytool](https://docs.oracle.com/javase/6/docs/technotes/tools/solaris/keytool.html) - Key and Certificate Management Tool  
* [Class KeyStore](https://docs.oracle.com/javase/7/docs/api/java/security/KeyStore.html)
* [RSA Signing and Encryption in Java](https://niels.nu/blog/2016/java-rsa.html)
  
* [Converting a Java Keystore Into PEM Format](https://www.baeldung.com/java-keystore-convert-to-pem-format)

*Egon Teiniker, 2020 - 2023, GPL v3.0* 

