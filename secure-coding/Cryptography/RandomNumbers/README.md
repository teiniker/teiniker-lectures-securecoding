# Random Numbers

**Randomness is found everywhere in cryptography**: in the generation of secret keys, in encryption schemes, and even in the attacks on cryptosystems. 
Without randomness, cryptography would be impossible because all operations would become predictable, 
and therefore insecure.

To generate randomness, we need two things:
* A source of uncertainty, or source of entropy, provided by **random number generators (RNGs)**. 
* A cryptographic algorithm to produce high-quality random bits from the source of entropy. 
   This is found in **pseudorandom number generators (PRNGs)**.

In cryptography, randomness usually comes from RNGs, which are software or hardware components 
that leverage entropy in the analog world to produce unpredictable bits in a digital system.


Note that PRNGs rely on RNGs but behave differently: RNGs produce true random bits relatively slowly 
from analog sources, in a nondeterministic way, and with no guarantee of high entropy. 
In contrast, PRNGs produce random-looking bits quickly from digital sources, in a deterministic way, 
and with maximum entropy. 

**PRNGs transform a few unreliable random bits into a long stream of reliable pseudorandom 
bits suitable for crypto applications**.


## Cryptographic vs. Non-Cryptographic PRNGs

Non-crypto PRNGs are designed to produce uniform distributions for applications such as scientific 
simulations or video games. However, we should **never use non-crypto PRNGs in crypto applications**, 
because they’re insecure—they’re only concerned with the quality of the bits’ probability distribution 
and not with their predictability. 

Crypto PRNGs, on the other hand, are unpredictable, because they’re also concerned with the strength of the 
underlying operations used to deliver well-distributed bits. 
Unfortunately, most PRNGs exposed by programming languages, such as libc’s `rand()`, Java's `java.util.Random`
and Python’s random module are non-cryptographic.

_Example_: C standard library function `rand()` (Non-Cryptographic PRNG) 
```C
int main(void)
{
    srand(SEED);  
    for(int i=0; i<5; i++)
    {
        int random_number = rand();
        printf(" %d ", random_number % RANGE_MAX + RANGE_MIN);
    }

    return 0;
}
```
The `srand()` function sets the starting point for producing a series of pseudo-random integers.

The `rand()` function is used in C to generate random numbers. 
It returns a pseudo-random number in the range of `0` to `RAND_MAX`.
If we generate a sequence of random number with `rand()` function, it will
**create the same sequence again and again every time program runs**.

_Example_: Java `SecureRandom` class (Cryptographic PRNG) 
```Java
public void testNextBytes()
{
   SecureRandom random = new SecureRandom();
   byte bytes[] = new byte[20];
   random.nextBytes(bytes);
   String hexString = Hex.encodeHexString(bytes);		    
   System.out.println(hexString);
}
```
To retrieve random data from `SecureRandom`, the `nextBytes()` method can be used to fill the input byte 
array with the specified number of random bytes.

On **Windows with the Oracle JDK** and the default configuration the SHA1PRNG generator is used.

On **Linux with the Oracle JDK** and default configuration the NativePRNG algorithm is used. 
This algorithm provides the output of the `/dev/urandom` PRNG that is provided by the OS. 


## Generating Random Bits in Linux-Based Systems

The device file `/dev/urandom` is the userland interface to the crypto PRNG of common Linux systems, 
and it’s what you will typically use to generate reliable random bits. 
Because it’s a device file, requesting random bits from `/dev/urandom` is done by reading it as a file.


## Generating Psuedo Random Numbers using OpenSSL
The following command line generates a number of random bytes, which can either be output raw, as `Base64` or as `HEX`:
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

This command generates random bytes using a **cryptographically secure pseudo random number generator (CSPRNG)**.

## References

* Jean-Philippe Aumasson. **Serious Cryptography**. No Starch Press, 2018
  * Chapter 2: Randomness
    

*Egon Teiniker, 2020 - 2022, GPL v3.0* 

