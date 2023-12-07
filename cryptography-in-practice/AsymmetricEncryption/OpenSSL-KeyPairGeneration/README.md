# Generating Private and Public Keys Using OpenSSL

To generate an RSA **private key** type the following command:
```
$ openssl genpkey -algorithm RSA -pkeyopt rsa_keygen_bits:4096 -out private-key.pem
$ cat private-key.pem
-----BEGIN PRIVATE KEY-----
MIIJQQIBADANBgkqhkiG9w0BAQEFAASCCSswggknAgEAAoICAQC18RulJsPhX8TM
H25/0yzcSB5zOXT6NiVxMloysok9c2va5HlauydRYCxnGLISAcaeKPg3JFmQ78Bb
ffkmWB8Aexw0fHdP38A0AE3tfrLUC9AAIRZ3SsgyaUQ04aTmDHVfCYBHa81ezjVa
...
0WzCDbcVjDorfaWLomo932bimsi2gMMLH/c93k9VXShKkQhKLPKbiocGlWqVcb5u
xGp7shRR6ykLLPKx75gj3KPjt0hqBP+4WXJRZdAt8k44YAt2FN11C/8M2bazYNdp
zK0Ot5tcBeH7KuM1BEzd78cIJBUW
-----END PRIVATE KEY-----
```
Parameters: 
* **genpkey**: Generate a private key.
* **-algorithm alg**: Public key algorithm to use such as **RSA**, DSA or DH.
* **-pkeyopt opt:value**: Set the public key algorithm option `opt` to `value`.
* **-out filename**: Output the key to the specified file. If this argument is not specified then standard output is used.
 
Having previously generated your private key, you may generate the corresponding **public key** using the following command:
```
$ openssl pkey -in private-key.pem -out public-key.pem -pubout
$ cat public-key.pem 
-----BEGIN PUBLIC KEY-----
MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAtfEbpSbD4V/EzB9uf9Ms
3Egeczl0+jYlcTJaMrKJPXNr2uR5WrsnUWAsZxiyEgHGnij4NyRZkO/AW335Jlgf
AHscNHx3T9/ANABN7X6y1AvQACEWd0rIMmlENOGk5gx1XwmAR2vNXs41WjrdSPh1
aN2ipN/OFZt0MDGVxliXhUDZ6pvfrYbXwRYxDd1bNK8dHYaw73ybWK9gI6SCCsbB
...
LEgYQN1N5RURmiBI8WWOdv6JUH3Ddd3zOj+wTCv6qIUX4gLQ4pgHHc8MRmAmsoUQ
kWK+pn2FV8/KjGaYXhR+TeDg/TXj6db43GPXCPFjYtu/a6kWvT7xEK1tE+4r/P8X
h//Br01zuuLfBgtd633gT1UCAwEAAQ==
-----END PUBLIC KEY-----
```
Parameters:
* **pkey**: Public or private key processing tool.
* **-in filename**: This specifies the **input filename** to read a key from or standard input 
   if this option is not specified. 
   If the key is encrypted a pass phrase will be prompted for.
* **-out filename**: This specifies the **output filename** to write a key to or standard output 
   if this option is not specified. 
   If any encryption options are set then a pass phrase will be prompted for. 
   The output filename should **not be the same** as the input filename.
* **-pubout**: By default a private key is output: with this option a **public key** will be 
   output instead. This option is automatically set if the input is a public key.


## Converting a PEM File to Java KeyStore Format

We will start by generating two files, `key.pem` and `cert.pem`:

```
$ openssl req -newkey rsa:2048 -x509 -keyout key.pem -out cert.pem -days 365
```

Now, we can convert PEM into a PKCS12 format:
```
$ openssl pkcs12 -export -in cert.pem -inkey key.pem -out certificate.pfx -name "certificate"
```

To list the content of the KeyStore file, type:
```
$ keytool -list -v -keystore  certificate.pfx

Enter keystore password: student
Keystore type: PKCS12
Keystore provider: SUN

Your keystore contains 1 entry

Alias name: certificate
Creation date: Dec 7, 2023
Entry type: PrivateKeyEntry
Certificate chain length: 1
Certificate[1]:
Owner: EMAILADDRESS=teini@hsb.de, CN=teini, OU=mks, O=hsb, L=bre, ST=bre, C=de
Issuer: EMAILADDRESS=teini@hsb.de, CN=teini, OU=mks, O=hsb, L=bre, ST=bre, C=de
Serial number: 7ab834bd16a76cb9ca73f4812e2d3df2d7c6fd17
...
```



## References
* [openssl](https://www.openssl.org/docs/man1.1.1/man1/openssl.html)
* [Converting a PEM File to Java KeyStore Format](https://www.baeldung.com/convert-pem-to-jks)
