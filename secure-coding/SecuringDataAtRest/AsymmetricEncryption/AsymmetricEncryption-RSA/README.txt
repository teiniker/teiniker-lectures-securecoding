Asymmetric Key Cryptography
---------------------------------------------------------------------

The RSA algorithm was initially publicized in 1977 by Ronals Rivest,
Adi Shamir, and Leonard Adleman.
The algoritm gets its security from the difficulty of factoring large
numbers.


Creating Random RSA Keys
------------------------
We can use the KeyPairGenerator class to generate a KeyPair.
Key sizes should be between 2048 or 4096 bits.

The KeyPair class serves as a holder for a private key and its associated
public key. The getPrivate() and getPublic() methods return the private
and public key keys.




References:

- RSA Signing and Encryption in Java
  https://niels.nu/blog/2016/java-rsa.html

- David Hook, Beginning Cryptography with Java, Wrox 2005
    Chapter 4: Asymmetric Key Cryptography


