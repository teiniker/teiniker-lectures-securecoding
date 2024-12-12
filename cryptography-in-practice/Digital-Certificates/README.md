# Digital Certificates

A digital certificate is an electronic document used to **prove the ownership 
of a public key**. It is a critical component of **Public Key Infrastructure (PKI)** 
and plays a vital role in establishing trust in online communications.

## Features of a Digital Certificate

* **Authentication**: Confirms the identity of the certificate holder 
    (individual, organization, or website).

* **Public Key Association**: Links the public key to the identity of 
    the certificate holder.

* **Trust**: Issued by a trusted third party, known as a **Certificate 
    Authority (CA)**, ensuring the certificate’s validity.
 
* **Encryption**: Facilitates secure communication by enabling the use 
    of public-key cryptography. 

## Components of a Digital Certificate

A digital certificate is a document that uniquely identifies information about a party.
It contains a party's **public key plus other information** that is digitally signed and issued by a trusted third party, also reffered to as a **Certificate Authority (CA)**.

A digital certificate is also known as an **X.509 certificate** and is commonly used to solve problems associated with key management.

![Digital Certificate](Certificate.png)

A digital certificate contains a **public key**, **identification information** and the **name of the CA**. The CA uses its private key to signe the certificate. The **CA signature** is also added to the certificate.


## Applications of Digital Certificates

* **Secure Web Browsing**: Ensures that websites are authentic and safe 
    to interact with.

* **Encrypted Email**: Protects email contents from unauthorized access.

* **Software Integrity**: Verifies that downloaded software is genuine 
    and untampered.

* **User Authentication**: Allows secure access to systems and services.


## References

* David Hook. **Beginning Cryptography with Java**. Wrox, 2005
    Chapter 6: Distinguished Names and Certificates
    
*Egon Teiniker, 2016-2024, GPL v3.0* 