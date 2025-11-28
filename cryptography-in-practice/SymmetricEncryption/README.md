# Symmetric Encryption

A **symmetric cipher** is an algorithm that transforms **plaintext** into **ciphertext** through use of a **secret key**.
Plaintext is a message in its native form - we can simply read it. 
Ciphertext is the result of the encryption operation and appears as a sequence of bytes.
**The secret key is the critical piece in the system**. If the secret key is compromised, then so is the message hidden 
in the ciphertext.

The secret key used to generate the ciphertext is the same secret key used to decipher and return the original plaintext.
The **sender and receiver both use the same secret key**.

Symmetric ciphers are **fast** and capable of performing encryption operations even when the input data is very large.
Some symmetric cipher algorithms lend themselves to parallel encryption operations that can take full advantage 
of multiple CPUs.

![Symmetric Cipher](SymmetricCipher.png)

Symmetric-key encryption can use either stream ciphers or block ciphers:
* **Block ciphers** take a number of bits and encrypt them as a single unit, padding the plaintext so that it is a multiple 
  of the block size. The [Advanced Encryption Standard (AES)](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard) 
  algorithm uses 128-bit blocks.
* **Stream ciphers** encrypt the digits (typically bytes) of a message one at a time. An example is ChaCha20.


## Cipher API
A symmetric key encryption operation is a matter of providing a key
to use, and a suitable object for doing the processing on the input
data (plaintext to be encrypted or ciphertext to be decrypted). 

The `SecretKeySpec` class provides a simple mechanism for converting
byte data into a secret key suitable for passing to a Cipher object's
`init() `method.

Note that `SecretKeySpec` can not stop you from passing a week key to
a Cipher object.

The creation and use of a `Cipher` object follows a simple pattern:
 - create a Cipher using `Cipher.getInstance()` 
 - initialize it with the mode we want to use using `Cipher.init()`
 - feed the input data in while collecting output at the same time
 	using `Cipher.update()`
 - finish the process with `Cipher.doFinal()`
 
 
A Cipher object is created using the static factory method `getInstance()`
by passing the name of the Cipher which is composed of three parts:
	
	`AlgorithmName/Mode/TypeOfPadding`

_Example:_ Cipher.getInstance("AES/CTR/NoPadding")
* Advanced Encryption Standard (AES) algorithm
* Counter mode (CTR) 
* No padding needed (streaming mode)
		 	
Note that we can also just give the algorithm's name so that the provider
can select which mode and padding will be used in the created Cipher object.



### Cipher.init()
We have to initialize the Cipher object with the type of operation 
we want to use (`Cipher.ENCRYPT_MODE`, `Cipher.DECRYPT_MODE`) and also 
with the key that should be used.


### Cipher.update()
Cipher objects usually acquire a chunk of data, process it by copying 
the result into the output array, and then copy the next chunk and
continue, filling the output array as they go.

We cannot be sure how much data will be written each time we do an 
update. The starting offset that the processed blocks are written to
is the last argument to the method.


### Cipher.doFinal()
`doFinal()` is very similar to `update()`, it also has a return value to
tell us how many bytes it actually wrote to the output array.
Note that the second argument is the offset at which writing of the
output will start.


## Symmetric Block Cipher Padding
Most of the popular block ciphers have a block size that is more than 1 byte long: 
* **DES** and Blowfish have a block size of **8 bytes**
* **AES** has a block size of **16 bytes**

The effect of this is that the input data to a cipher that is being 
used in a blocking mode must be aligned to the block size of that 
cipher. The easiest way to deal with this issue is to use padding
mechanisms.

The **Public-Key Cryptography Standards (PKCS#5 and PKCS#7)** were
developed by RSA Security.
If we need to pad a block of data where the last input block is 3
bytes shorter than the block size of the cipher we are using, we add
3 bytes of value 3 to the data before encrypting it.
When the data is decrypted, we check the last byte of the last decrypted 
block of data and remove that many bytes from it.

The advantage of this approach is that the mechanism is unambiguous. 


## Symmetric Block Cipher Modes

### Electronic Code Book (ECB) - Don't Use It!!
ECB mode describes the use of a symmetric cipher in its rawest form. 
The problem with ECB mode is that if there are patterns
in the data, there will be patterns in the encrypted data as well.

![ECB](figures/ECB_encryption.svg.png)

Given a particular block of bytes on input, the cipher performs a
set of deterministic calculations, looking up a virtual code book
and returns a particular block of bytes as output. So given the same
block of input bytes, you will always get the same block of output 
bytes.


### Cipher Block Chaining (CBC)
CBC mode reduces the likelihood of patterns appearing in the cipher text 
by XOR-ing the block of data to be encrypted with the last block of 
cipher text produced and then applying the raw cipher to produce the next 
block of cipher text. 

The `IvParameterSpec` object is used to carry the i**nitialization vector (IV)**
It is the IV that provides the initial block of cipher text that is 
XOR-ed with the first block of input.

![CBC](figures/CBC_encryption.svg.png)

Forgetting to set the IV (or setting it to the wrong value) is a very 
common programming error. The indicator for this error is that the first 
block of the message will decrypt to garbage, but the rest of the message 
will appear to decrypt correctly.

_Example:_ "AES/CBC/PKCS5PADDING"

We can also use a random IV created by a `SecureRandom` object's nextBytes()
method.


### Segment Integer Counter (CTR)
CTR or Counter mode is defined in **RFC3686**.
We don't have to specify any padding because the mode allows you to work
with any length of data (like streaming cipher).

_Example:_ "AES/CTR/NoPadding"

![CTR](figures/CTR_encryption_2.svg.png)

Advantages of the CTR mode:
* It is a **streaming mode**, so we don't have to worry about padding.
* It allows for **random access** to the encrypted data.

### Galois/Counter Mode (GCM) 
Using GCM blocks are numbered sequentially, and then this block number is combined with an 
initialization vector (IV) and encrypted with a block cipher.
The result of this encryption is then XORed with the plaintext to produce the ciphertext. 

_Example:_ "AES/GCM/NoPadding"

![GCM](figures/GCM-Galois_Counter_Mode_with_IV.svg.png)

Advantages of the GCM mode:
* Like all counter modes, this is essentially a **stream cipher**, and so it is essential that a different IV is used for 
each stream that is encrypted.
* GCM can take full advantage of **parallel processing** and implementing GCM can make efficient use of an instruction 
pipeline or a hardware pipeline.
* It allows for **random access** to the encrypted data.


## Cipher-Based IO

The JCA contains two classes for doing I/O involving ciphers:
* **CipherInputStream**: A CipherInputStream is composed of an InputStream and 
  a Cipher so that `read()` methods return data that are read in from the 
  underlying `InputStream` but have been additionally processed by the Cipher. 
  
 
* **CipherOutputStream**: A CipherOutputStream is composed of an OutputStream and 
    a Cipher so that `write()` methods first process the data before writing them 
    out to the underlying `OutputStream`. 

Note that the `Cipher` must be fully initialized before being used by a `CipherInputStream`
or `CipherOutputStream`.

We can use them anywhere we would use an `InputStream` or an `OutputStream`.
Instances of both are created using constructors that take an 
`InputStream` or an `OutputStream`, to wrap, and a cipher object to do
the processing.

There is really only one important point to remember with cipher streams.
If close on the stream is not called, `Cipher.doFinal()`will not be called
on the underlying cipher either. 
**Forgetting to call `close()` is a very common error.**
        
        
        
## References
* [Symmetric-Key Algorithm](https://en.wikipedia.org/wiki/Symmetric-key_algorithm)
* [Block Cipher Mode of Operation](https://en.wikipedia.org/wiki/Block_cipher_mode_of_operation)
* Jason Weiss. **Java Cryptography Extensions**. Morgan Kaufmann, 2004. 
  * Chapter 2: Working with Symmetric Ciphers.



*Egon Teiniker, 2020 - 2023, GPL v3.0* 