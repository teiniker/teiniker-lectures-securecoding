How to build a JAR file?
---------------------------------------------------------------------

When distributing applications, code is usually grouped into a jar 
file to ease the process.
A jar file is an archiving mechanism to compress multiple files into
a single file known as jar - Java Archive File.
 
We use the build tool Maven to compile the Java source files into class
files and to zip them into a jar file.

$ mvn package 


To review the content of a jar file type:

$ jar -tf target/SecurityFeatures-Jar-Signing-0.0.1-SNAPSHOT.jar



How to create a keystore?
---------------------------------------------------------------------
The first step that is neccessary for signing a jar file is to create 
a private key that can be used to sign a jar file, as well as a public
key that can be used to verify the authenticity of the signed jar file.

We will use the "keytool" to create a keystore:

$ keytool -genkey -keystore keys.ks -alias fhj -storepass student -keypass student
What is your first and last name?
  [Unknown]:  egon teiniker    
What is the name of your organizational unit?
  [Unknown]:  ase
What is the name of your organization?
  [Unknown]:  fhj
What is the name of your City or Locality?
  [Unknown]:  kberg
What is the name of your State or Province?
  [Unknown]:  styria
What is the two-letter country code for this unit?
  [Unknown]:  at
Is CN=egon teiniker, OU=ase, O=fhj, L=kberg, ST=styria, C=at correct?
  [no]:  yes

Options:
	-genkey 	generate a private/public key pair
	-keystore 	the name of the key store file
	-alias 		provides a name associated with the key in the store
	-storepass	provides a password for accessing the keystore file
	-keypass	provides a password for the private key
	
	  
To list the content of the keystore file type:

$ keytool -list -keystore keys.ks -storepass student



How to sign a JAR file?
---------------------------------------------------------------------
Signing jar files ensures that code was not modified.

Java comes with a tool called "jarsigner", which can be used to sign
files and verify the signatures and integrity of signed jar files.

$ jarsigner -keystore keys.ks -storepass student -keypass student target/SecurityFeatures-Jar-Signing-0.0.1-SNAPSHOT.jar fhj

When we execute the command we see a warning statement that 
"The signer certificate will expire within six months."
This is because the self-signed certificate we generated with the keytool
is valid for less than six months.

Let's review the jar file's content:

$ jar -tf target/SecurityFeatures-Jar-Signing-0.0.1-SNAPSHOT.jar
META-INF/MANIFEST.MF				<--
META-INF/FHJ.SF						<--
META-INF/FHJ.DSA					<--
META-INF/
org/
org/se/
org/se/lab/
org/se/lab/DAOException.class
org/se/lab/ServiceException.class
org/se/lab/User.class
org/se/lab/UserDAO.class
org/se/lab/UserService.class


$ mkdir tmp
$ cd tmp/
$ jar xvf ../target/SecurityFeatures-Jar-Signing-0.0.1-SNAPSHOT.jar 

	target/
	├── classes
	│   └── META-INF
	│       ├── MANIFEST.MF
	│       └── maven
	│           └── org.se.lab
	│               └── SecurityFeatures-Jar-Signing
	│                   ├── pom.properties
	│                   └── pom.xml
	├── maven-archiver
	│   └── pom.properties
	├── SecurityFeatures-Jar-Signing-0.0.1-SNAPSHOT.jar
	└── test-classes



The MANIFEST.MF file contains the following:
 
Manifest-Version: 1.0
Ant-Version: Apache Ant 1.9.2
Created-By: 1.7.0_25-b15 (Oracle Corporation)

Name: org/se/lab/DAOException.class
SHA-256-Digest: aejfjtduHW/zPkcshmbfZBKVLMD5OONEWfbaU8d+XSs=

Name: org/se/lab/ServiceException.class
SHA-256-Digest: ZEB7QwFVxeslM2meQkKwR0cYiOyol+YC+QhJcUIEzKI=

Name: org/se/lab/UserDAO.class
SHA-256-Digest: g5q1Kali1vXklY8df3Xj9BUPnXUs0Y1TpWe2vm+/gRg=

Name: org/se/lab/User.class
SHA-256-Digest: hiTV219DqEWKyyCfGZ3KPm+08KyA/KF92ojaGslvFTc=

Name: org/se/lab/UserService.class
SHA-256-Digest: LbRUfxQp6yh8OepReP6p6VmRNttvMZJIxI+fyhO2xwU=
 
Each class file contained in the jar is given an associated digest entry.
In this case SHA-256 hash is created for each corresponding class file.
A hash value is like a fingerprint for a given file.
This hash value will only change if the file itself changes.


The signature file named FHJ.SF contains the following:

Signature-Version: 1.0
SHA-256-Digest-Manifest-Main-Attributes: M4HaMKUjjUr50EJru9jJWxQz2jykb
 m3xR+l3LbYc6Ug=
SHA-256-Digest-Manifest: ETaC/1R3IBjz0IdQA3BNkBpS3GIlm1MCFrTyGqtUVYI=
Created-By: 1.7.0_25 (Oracle Corporation)

Name: org/se/lab/DAOException.class
SHA-256-Digest: npXeui5lg6YKzp3vAyfyq1cviEHq01T7KBIiWWbzpaE=

Name: org/se/lab/ServiceException.class
SHA-256-Digest: bLPzXn2ciPJZwmuMijwfXI1WZeEci1CSZCAS2xAYkUk=

Name: org/se/lab/UserDAO.class
SHA-256-Digest: O7B2+og/r9d5L3gPVqLbLha9rwfe7qEmQfr22vDOE2w=

Name: org/se/lab/User.class
SHA-256-Digest: 1imjvwlv/XaaADPJM1+KpU5640OvoKn+BkMTcVxwBT0=

Name: org/se/lab/UserService.class
SHA-256-Digest: Sl5w6mfOYtNJ47euIwjYAn1iJQuWjB2icjS49VfMxkA=
 
Here we see again a SHA-256 hash value for each file within the jar.
These hash values are generated based on the corresponding entries in 
the MANIFEST.MF file instead of creating a hash from the data in the 
class file itself. 
There is also a SHA-256-Digest-Manifest, which hashes the entire 
MANIFEST.MF file. 


The signature block file named FHJ.DSA contains the digital signature 
for the file, which was generated by the signer's private key.
This file also contains the certificate (which contains the public key) 
that can be used to verify the digital signature and conform that the 
signed jar file is authentic.
The DSA extension indicates that the file was created using the Digital 
Signature Algorithm.



How to verify a JAR file?
---------------------------------------------------------------------

A signed jar file can be verified by using jarsigner with the -verify
option. 

$ jarsigner -verify -verbose -keystore keys.ks target/SecurityFeatures-Jar-Signing-0.0.1-SNAPSHOT.jar

s k      598 Sat Apr 12 12:14:10 CEST 2014 META-INF/MANIFEST.MF
         725 Sat Apr 12 12:14:10 CEST 2014 META-INF/FHJ.SF
        1051 Sat Apr 12 12:14:10 CEST 2014 META-INF/FHJ.DSA
           0 Sat Apr 12 11:35:22 CEST 2014 META-INF/
           0 Sat Apr 12 11:35:20 CEST 2014 org/
           0 Sat Apr 12 11:35:20 CEST 2014 org/se/
           0 Sat Apr 12 11:35:20 CEST 2014 org/se/lab/
smk      288 Sat Apr 12 11:35:20 CEST 2014 org/se/lab/DAOException.class
smk      384 Sat Apr 12 11:35:20 CEST 2014 org/se/lab/ServiceException.class
smk     1056 Sat Apr 12 11:35:20 CEST 2014 org/se/lab/User.class
smk      193 Sat Apr 12 11:35:20 CEST 2014 org/se/lab/UserDAO.class
smk     1081 Sat Apr 12 11:35:20 CEST 2014 org/se/lab/UserService.class

  s = signature was verified 
  m = entry is listed in manifest
  k = at least one certificate was found in keystore
  i = at least one certificate was found in identity scope

jar verified.	<--

When jarsigner verifies a jar file, it takes the following steps:
1) Verify the digital signature.
	The digital signature stored in the signature block file (.DSA) is 
	verified with the public key. This ensures that the signature was 
	in fact generated using the corresponding private key.
	The digital signature is also checked to ensure that it matches the
	data in the signature file (.SF)

2) Verify that the hash values in the .SF file match the corresponding 
	entries in the MANIFEST.MF file.
	
3) Verify that the hash values for every file listed in the .SF file 
	match the value listed in the manifest.			



How to export the public key?
---------------------------------------------------------------------

Because keys.ks keystore contains your private keys, you need another 
keystore that contains only your public keys to share with the outside 
world.

$ keytool -export -v -keystore keys.ks -alias fhj -file fhj.cert -storepass student -keypass student



How to use the exported certificate to verify a signed jar?
---------------------------------------------------------------------

$ keytool -import -v -keystore certificates.ks -alias fhj-cert -file fhj.cert -storepass student -keypass student

$ jarsigner -verify -verbose -keystore certificates.ks target/SecurityFeatures-Jar-Signing-0.0.1-SNAPSHOT.jar
jar verified.



 