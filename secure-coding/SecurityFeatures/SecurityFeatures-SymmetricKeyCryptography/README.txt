Symmetric Key Cryptography
---------------------------------------------------------------------

A symmetric key encryption operation is a matter of providing a key
to use, and a suitable object for doing the processing on the input
data (plaintext to be encrypted or ciphertext to be decrypted). 

The SecretKeySpec class provides a simple mechanism for converting
byte data into a secret key suitable for passing to a Cipher object's
init() method.

Note that SecretKeySpec can not stop you from passing a week key to
a Cipher object.

The creation and use of a Cipher object follows a simple pattern:
 - create a Cipher using Cipher.getInstance() 
 - initialize it with the mode we want to use using Cipher.init()
 - feed the input data in while collecting output at the same time
 	using Cipher.update()
 - finish the process with Cipher.doFinal()
 
 
Cipher.getInstance()
--------------------------------------------------------------------
A Cipher object is created using the static factory method getInstance()
by passing the name of the Cipher which is composed of three parts:
	AlgorithmName/Mode/TypeOfPadding

Example: Cipher.getInstance("AES/ECB/PKCS7Padding")
	=> Advanced Encryption Standard (AES) algorithm
	=> Electronic Code Book (ECB) mode
	=> Public-Key Cryptography Standards #7 (PKCS7) padding type
		 	
Note that you can add the provider's name as a second argument of the 
getInstance() method.
 
Note that we can also just give the algorithm's name so that the provider
can select which mode and padding will be used in the created Cipher object.
But this is a bad idea if we want to make our code portable between different 
providers.


Cipher.init()
--------------------------------------------------------------------
We have to initialize the Cipher object with the type of operation 
we want to use (Cipher.ENCRYPT_MODE, Cipher.DECRYPT_MODE) and also 
with the key that should be used.


Cipher.update()
--------------------------------------------------------------------
Cipher objects usually acquire a chunk of data, process it by copying 
the result into the output array, and then copy the next chunk and
continue, filling the output array as they go.

We cannot be sure how much data will be written each time we do an 
update. The starting offset that the processed blocks are written to
is the last argument to the method.


Cipher.doFinal()
--------------------------------------------------------------------
doFinal() is very similar to update(), it also has a return value to
tell us how many bytes it actually wrote to the output array.
Note that the second argument is the offset at which writing of the
output will start.


Symmetric Block Cipher Padding
--------------------------------------------------------------------
Most of the popular block ciphers have a block size that is more than
1 byte long: 
 - DES and Blowfish have a block size of 8 bytes
 - AES has a block size of 16 bytes

The effect of this is that the input data to a cipher that is being 
used in a blocking mode must be aligned to the block size of that 
cipher. The easiest way to deal with this issue is to use padding
mechanisms.

The Public-Key Cryptography Standards (PKCS#5 and PKCS#7) were
developed by RSA Security.
If we need to pad a block of data where the last input block is 3
bytes shorter than the block size of the cipher we are using, we add
3 bytes of value 3 to the data before encrypting it.
When the data is decrypted, we check the last byte of the last decrypted 
block of data and remove that many bytes from it.

The only shortcoming of this approach is that we must always add the 
padding, so if the block size of our cipher is 8 bytes, and the input 
data is a multiple of 8 bytes in length, we have to add a pad block 
with 8 bytes with the value 8.

The advantage of this approach is that the mechanism is unambiguous. 


Symmetric Block Cipher Modes
--------------------------------------------------------------------

Electronic Code Book (ECB)
--------------------------
ECB mode describes the use of a symmetric cipher in its rawest form. 
The problem with ECB mode is that if there are patterns
in the data, there will be patterns in the encrypted data as well.

Example: testDES_ECB()
	=> cipher: e1b246e5a7c74cbc 92c9db45300b932f e1b246e5a7c74cbc e481a8d39714d0de bytes: 32 

Given a particular block of bytes on input, the cipher performs a
set of deterministic calculations, looking up a virtual code book
and returns a particular block of bytes as output. So given the same
block of input bytes, you will always get the same block of output 
bytes.


Cipher Block Chaining (CBC)
---------------------------
CBC mode reduces the likelihood of patterns appearing in the cipher text 
by XOR-ing the block of data to be encrypted with the last block of 
cipher text produced and then applying the raw cipher to produce the next 
block of cipher text. 

The IvParameterSpec object is used to carry the initialization vector (IV)
It is the IV that provides the initial block of cipher text that is 
XOR-ed with the first block of input.

Forgetting to set the IV (or setting it to the wrong value) is a very 
common programming error. The indicator for this error is that the first 
block of the message will decrypt to garbage, but the rest of the message 
will appear to decrypt correctly.

We can also use a random IV created by a SecureRandom object's nextBytes()
method.


Cipher Text Stealing (CTS)
--------------------------
CTS is defined in RFC2040 and combines the use of CBC mode with some 
additional XOR operations on the final encrypted block of the data being 
processed to produce encrypted data that has the same length as the
input data.



Segment Integer Counter (CTR)
-----------------------------
CTR or Counter mode is defined in RFC3686.
We don't have to specify any padding because the mode allows you to work
with any length of data.

Example: "AES/CTR/NoPadding"

The advantages of the CTR mode are:
- It is a streaming mode, so we don't have to worry about padding.
- It allows for random access to the encrypted data.


Output Feedback (OFB)
---------------------
OFB mode works by using the raw block cipher to produce a stream of 
pseudorandom bits, which are then XOR-ed with the input message to 
produce the encrypted message.

With OFB mode, we load the IV into a state array, encrypt the state 
array, and save the result back to the state array, using the bits we 
generated to XOR with the next block of input and generate the cipher 
text.


Cipher Feedback (CFB)
---------------------
CFB is used in the OpenPGP message format as described in RFC2440.
Like OFB mode and CTR mode, CFB produces a stream of pseudorandom 
bits that are then used to encrypt the input.
Unlike the others, CFB uses the plaintext as part of the process
of generating the stream of bits. CFB starts with the IV, encrypts
it using the raw cipher and saves it in a state array. As we encrypt
a block of data, we XOR it with the state array to get the cipher
text and store the resulting cipher text back in our state array. 


Generating Random Keys
--------------------------------------------------------------------
Until now, we have been relying on the SecretKeySpec class as the 
object used to create keys for passing into Cipher.init().

Another way is to use the KeyGenerator class to generate keys for
use with symmetric encryption.

KeyGenerator, like Cipher, uses a factory pattern for creating 
instance objects.

Example: KeyGenerator.getInstance("AES", "BC");



Symmetric Stream Ciphers
--------------------------------------------------------------------
Stream ciphers are basically just ciphers that, by design, behave
like block ciphers using the streaming modes.
The idea is for the cipher to create a stream of bits that are then
XOR-ed with the plain text to produce the cipher text.

Stream ciphers do not have modes or require padding - they will 
always produce output of the same length as the input. The result is 
that only the name of the algorithm is required.

Note that the block size is not really relevant, consequently, the
JCA allows a stream cipher to return 0 from Cipher.getBlockSize(). 



Cipher-Based IO
--------------------------------------------------------------------

The JCA contains two classes for doing I/O involving ciphers:
	
	CipherInputStream and CipherOutputStream

We can use them anywhere we would use an InputStream or an OutputStream.
Instances of both are created using constructors that take an 
InputStream or an OutputStream, to wrap, and a cipher object to do
the processing.

There is really only one important point to remember with cipher streams.
If close on the stream is not called, Cipher.doFinal() will not be called
on the underlying cipher either. Forgetting to call close() is a very 
common error.
	