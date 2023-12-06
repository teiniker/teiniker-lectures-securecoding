# Key Derivation Functions

Key Derivation Functions (KDFs) are cryptographic algorithms designed for securely 
**deriving one or more secret keys from a single initial key or password**. 

The primary purpose of KDFs is to take a piece of initial data (like a password) and transform 
it into a key that can be used for cryptographic operations, such as encryption or digital signatures. 

KDFs are crucial in addressing certain security concerns:
* **Strengthening Weak Keys**: Often, user-provided passwords or keys are not random and may be weak. 
  KDFs apply complex operations to these inputs to produce stronger, more unpredictable keys.

* **Key Stretching**: KDFs can increase the computational effort required to guess a key, which is 
  essential for defending against brute-force attacks. By incorporating iterations, a KDF forces an 
  attacker to spend significantly more time and resources to try each possible key.

* **Producing Multiple Keys**: Sometimes, multiple keys are needed from a single secret value. KDFs can 
  generate several different keys from one master key without compromising security.

* **Ensuring Key Uniqueness and Independence**: KDFs can create keys in such a way that each key is 
  unique and independent from others, even if the initial secret values are similar or related.

Two common types of KDFs are:

* **Password-Based KDFs (PBKDFs)**: These are specifically designed for passwords. PBKDFs, like PBKDF2, 
  add a salt (random data) to the password and then apply a hash function multiple times. 
  The iteration count is often adjustable to increase security as hardware gets faster.

* **Key-Based KDFs**: These derive keys from other cryptographic keys and are often used in conjunction 
  with encryption algorithms. They might use different mechanisms, such as hash functions or block cipher 
  algorithms, to generate the new keys.

One common approach to KDFs is to **use hash functions**, such as SHA-256 and SHA-3, to generate keys. 
KDFs that utilize hash functions are KDF1, KDF2, and **PBKDF2**.

There are several properties that a KDF should have to be secure and efficient:
* **Determinism**: when passing the same input to the function, we should always get the same output.
* **No collisions**: when passing two different input keys to the KDF, it should be almost impossible 
  to obtain the same output keys.
* **Key independence**: no matter the input and his weakness level, a KDF should behave similarly and 
  generate an output of the same size.
* **One-way process**: it should be hard or impossible to compute the input key from the output key.
* **Resistance to brute-force attacks**: it should be computationally impossible for an adversary 
  to guess the key by trying every possible combination of characters.


## References
* [Baeldung: What Are Key Derivation Functions?](https://www.baeldung.com/cs/kdf-cryptography)
* David Hook. **Beginning Cryptography with Java**. Wrox, 2005
  

*Egon Teiniker, 2016 - 2023, GPL v3.0* 