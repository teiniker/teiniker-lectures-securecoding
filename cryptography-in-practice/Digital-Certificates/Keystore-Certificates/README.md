# Creating a Keystore and Generating a Certificate

A **keystore** is a repository of security certificates, including public 
key certificates, and is used for encryption, authentication, and serving 
as a truststore. It is a critical component in securing communication 
channels and ensuring the integrity of data.

The Java **keytool** is a command-line utility provided with the Java Development 
Kit (JDK) that allows users to manage keystores, generate keys, and create or 
manage digital certificates. 

## Steps to Create a Digital Certificate Using keytool

* **Generate a Key Pair**:
    A key pair (private key and public key) is needed to create a digital 
    certificate.

    Run the following command to generate a key pair and 
    a **self-signed certificate**:

    ```bash
    $ keytool -storetype PKCS12 -genkeypair -alias testcert -keyalg RSA -keysize 4096 -validity 365 -storepass student -keypass student -keystore keystore.pfx
    ```

    * `-genkeypair`: Indicates the command to generate a key pair.
    * `-alias testcert`: Specifies the alias name for the key pair.
    * `-keyalg RSA`: Specifies the encryption algorithm (e.g., RSA).
    * `-keysize 4096`: Sets the key size (e.g., 4096 bits for RSA).
    * `-validity 365`: Specifies the certificate's validity in days (e.g., 1 year).
    * `-keystore keystore.pfx`: The name of the keystore file where the key pair 
        and certificate will be stored.    

    You will be prompted to provide information for the certificate, including:
    * Your name.
    * Organization Unit (OU).
    * Organization (O).
    * City/Locality (L).
    * State/Province (ST).
    * Country Code (C).

    Additionally, you will be asked to set a password for the keystore.


* **View the Certificate**:
    You can view the details of the certificate using the following command:

    ```bash
    $ keytool -list -v -alias testcert -storepass student -keystore keystore.pfx
    ```

    * `-list`: Lists entries in the keystore.
    * `-v`: Enables verbose output to display detailed certificate information.

* **Export the Public Key as a Certificate**:
    After creating the key pair, you can export the self-signed certificate 
    to **share the public key**.
    ```bash
    $ keytool -exportcert -alias testcert -file mycert.cert -storepass student -keystore keystore.pfx
    ```

    * `-exportcert`: Indicates the command to export the certificate.
    * `-file mycert.cert`: The output file for the exported certificate.

    This creates a file (`mycert.cert`) containing the **certificate in binary format**.



* **Convert the Certificate to PEM Format**:
    If you need the certificate in PEM format (used by many applications), 
    you can use the following command:    

    ```bash
    $ keytool -exportcert -alias testcert -file mycert.pem -rfc -storepass student -keystore keystore.pfx
    ```
    * `-rfc`: Converts the certificate to PEM (Base64) format.


The above commands creates a **self-signed certificate**, which is suitable 
for **development or testing** but **not for production**. 

In **production**, certificates should be signed by a trusted **Certificate 
Authority (CA)**.    


## References

* David Hook. **Beginning Cryptography with Java**. Wrox, 2005
    Chapter 6: Distinguished Names and Certificates
    
*Egon Teiniker, 2016-2024, GPL v3.0* 