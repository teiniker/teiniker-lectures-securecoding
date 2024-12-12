# Signatures - OpenSSL

## Generating Self-Signed Certificates

A common server-side operation is to generate a self-signed certificate for testing or encrypting communications between internal servers.

To **generate a private key and public certificate**, run the following command and answer the questions:
```
$ openssl req -x509 -newkey rsa:4096 -nodes -keyout key.pem  -days 365 -out certificate.crt
enerating a RSA private key
................................................................................................................................................................................++++
........................++++
writing new private key to 'key.pem'
-----
You are about to be asked to enter information that will be incorporated
into your certificate request.
What you are about to enter is what is called a Distinguished Name or a DN.
There are quite a few fields but you can leave some blank
For some fields there will be a default value,
If you enter '.', the field will be left blank.
-----
Country Name (2 letter code) [AU]:at
State or Province Name (full name) [Some-State]:styria
Locality Name (eg, city) []:graz
Organization Name (eg, company) [Internet Widgits Pty Ltd]:fhj
Organizational Unit Name (eg, section) []:stm
Common Name (e.g. server FQDN or YOUR name) []:teini
Email Address []:egon.teiniker@fhj.at
```

Parameters:
* **req**: Command passed to OpenSSL intended for creating and processing certificate requests usually in the PKCS#10 format.
* **-x509**: This multipurpose command allows OpenSSL to sign the certificate somewhat like a certificate authority. 
    X.509 refers to a digitally signed document according to RFC 5280.
* **-nodes**: This command is for no DES, which means that the private key will not be password protected.
* **-days**: The number of days that the certificate will be valid.
* **-newkey**: The format of the key, in this case an RSA key with 4096 bit encryption.
* **-keyout**: The location to output the private key of the self-signed certificate.
* **-out**: The location to output the certificate file itself.

To **review the certificate** type:
```
$ openssl x509 -text -noout -in certificate.crt
Certificate:
    Data:
        Version: 3 (0x2)
        Serial Number:
            04:c0:8c:b2:f1:ba:82:a1:3f:d7:5b:2c:ea:bc:ed:20:30:97:fa:22
        Signature Algorithm: sha256WithRSAEncryption
        Issuer: C = at, ST = styria, L = graz, O = fhj, OU = stm, CN = teini, emailAddress = egon.teiniker@fhj.at
        Validity
            Not Before: Jan  5 22:28:29 2021 GMT
            Not After : Jan  5 22:28:29 2022 GMT
        Subject: C = at, ST = styria, L = graz, O = fhj, OU = stm, CN = teini, emailAddress = egon.teiniker@fhj.at
        Subject Public Key Info:
            Public Key Algorithm: rsaEncryption
                RSA Public-Key: (4096 bit)
                Modulus:
                    00:ea:30:10:bf:70:8e:e4:99:12:76:d4:3d:d3:36:
                    59:e1:fa:73:83:b6:2e:3d:3e:e7:1f:35:50:0d:66:
                    9a:9a:ce:3c:e2:ed:36:bb:99:71:04:2b:e0:f1:72:
                    ...
                    47:dd:7e:c9:07:cc:c4:88:5e:6d:61:16:5d:ee:61:
                    cc:b0:6c:b2:3e:5f:99:3c:12:c8:d4:bf:8d:19:75:
                    ba:dd:e7
                Exponent: 65537 (0x10001)
        X509v3 extensions:
            X509v3 Subject Key Identifier: 
                47:E6:69:3B:CD:DA:F8:7D:FF:4C:9B:A6:5B:F0:9F:55:8E:C2:F5:F2
            X509v3 Authority Key Identifier: 
                keyid:47:E6:69:3B:CD:DA:F8:7D:FF:4C:9B:A6:5B:F0:9F:55:8E:C2:F5:F2

            X509v3 Basic Constraints: critical
                CA:TRUE
    Signature Algorithm: sha256WithRSAEncryption
         76:c4:fd:de:d7:27:47:e9:a5:63:97:44:3f:91:1e:cb:97:fc:
         e8:ba:9d:ae:79:e1:d4:3e:59:3c:07:c3:85:63:07:d3:aa:1b:
         83:da:23:02:64:03:71:05:94:83:63:bd:70:ff:4e:4c:8a:2b:
         ...
         cf:71:b0:d4:69:00:73:84:06:96:49:48:e6:9d:b0:d1:d7:8a:
         bc:6d:94:ca:3a:25:07:55:b0:79:c1:b8:26:ca:35:af:3d:5a:
         15:2c:50:77:9b:30:46:15
```

Parameters:
* **x509**: This is a multipurpose command, and when combined with the other parameters here, it is for retrieving 
        information about the passed in the certificate.
* **-text**: Strips the text headers from the output.
* **-noout**: Needed not to output the encoded version of the certificate
* **-in**: The certificate that we are verifying.

## Generating a CA and Server Certificate

We can create an in-house CA und use its certificate (and private key) to sign server certificates. 

_Example_: Create the CA private key and its self-signed certificate
```
$ openssl genrsa -out ca.key 4096
$ openssl req -new -x509 -days 365 -key ca.key -out ca.crt

$ openssl x509 -text -noout -in ca.crt
```

_Example_: Server certificate signed by the CA
```
$ openssl genrsa -out server.key 4096
$ openssl req -new -key server.key -out server.csr
$ openssl x509 -req -days 365 -in server.csr -CA ca.crt -CAkey ca.key -set_serial 01 -out server.crt

$ openssl x509 -text -noout -in server.crt
Certificate:
    Data:
        Version: 1 (0x0)
        Serial Number: 1 (0x1)
        Signature Algorithm: sha256WithRSAEncryption
        Issuer: C = at, ST = st, L = kberg, O = fhj, OU = ims, CN = teini, emailAddress = teini@fhj.at
        Validity
            Not Before: Mar 26 15:54:56 2021 GMT
            Not After : Mar 26 15:54:56 2022 GMT
        Subject: C = at, ST = st, L = graz, O = fhj, OU = ece, CN = egon, emailAddress = egon@fhj.at
        Subject Public Key Info:
            Public Key Algorithm: rsaEncryption
                RSA Public-Key: (4096 bit)
    ...
```


## References
* [openssl](https://www.openssl.org/docs/man1.1.1/man1/openssl.html)
* [How To Use OpenSSL To Generate Certificates](https://blog.ipswitch.com/how-to-use-openssl-to-generate-certificates)