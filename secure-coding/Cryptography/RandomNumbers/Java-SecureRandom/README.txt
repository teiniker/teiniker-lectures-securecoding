Pseudo-Random Number Generator (PRNG)
---------------------------------------------------------------------

A Pseudo-Random Number Generator (PRNG) is an algorithm used to generate 
numbers that approximate true randomness. PRGN approximate randomness 
by using a seed from which subsequent values are generated.


When using the SecureRandom class you must also ensure that the algorithm 
used by the underlying provider is a cryptographically strong algorithm 
like SHA1PRNG.

On Windows with the Oracle JRE and the default configuration the SHA1PRNG 
generator is used.

On Linux with the Oracle JRE and default configuration the NativePRNG 
algorithm is used. This algorithm provides the output of the /dev/urandom
PRNG that is provided by the OS.


How to Change the used Algorithm?
---------------------------------------------------------------------
On Linux, the default configuration can be changed by modifying the 
java.security file:
	securerandom.source=file:/dev/urandom 

If we need to ensure that the same PRNG is used no matter where the code
is running, then we have to explicitly specify the algorithm using the
getInstance() method.
 
 
How to Create a Given Number of Random Bytes?
--------------------------------------------------------------------- 
To actually retrieve random data from SecureRandom, the nextBytes(byte[])
method can be used to fill the input byte array with the specified number 
of random bytes.

