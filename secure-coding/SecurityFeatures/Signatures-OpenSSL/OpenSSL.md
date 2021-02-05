# OpenSSL

The **openssl** program is a command line tool for using the various cryptography functions of OpenSSL's crypto library from the shell.
It can be used for:
*  Public key cryptographic operations
*  Calculation of Message Digests
*  Creation and management of private keys, public keys and parameters
*  Creation of X.509 certificates, CSRs and CRLs
*  Encryption and Decryption with Ciphers
*  SSL/TLS Client and Server Tests
*  Handling of S/MIME signed or encrypted mail

To find out if your system supports openssl, type:
```
$ openssl version
OpenSSL 1.1.1g  21 Apr 2020
```

## Generating Psuedo Random Numbers
The following command line generates a number of random bytes, which can either be output raw, as Base64 or as HEX:
```
$ openssl rand -hex 16
f05a4f9bef09d057c355c6e28fec5543

$ openssl rand -base64 16
gokRIzPgvBsnQd5fshD9fg==
```
Parameters:
* **rand**: Generate pseudo-random bytes.
* **-hex**: Show the output as a hex string.
* **-base64**: Perform base64 encoding on the output.
* **-out file**: Write to file instead of standard output.
 
## Generating a File Fingerprint (Hash Value)
The digest functions output the message digest of a supplied file or files in hexadecimal. 

To see the list of supported algorithms, use the `list --digest-commands` command.
```
$ openssl list -digest-commands
blake2b512        blake2s256        gost              md4               
md5               rmd160            sha1              sha224            
sha256            sha3-224          sha3-256          sha3-384          
sha3-512          sha384            sha512            sha512-224        
sha512-256        shake128          shake256          sm3   
```

```
$ openssl dgst -sha256 wordlist.txt 
SHA256(wordlist.txt)= fd17b0ff31d7fb7b4e202b0cd99e1f11aa1f4972aab81010544a4e562f42bac7
```

## Generating Private and Public Keys

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

## References
* [openssl](https://www.openssl.org/docs/man1.1.1/man1/openssl.html)