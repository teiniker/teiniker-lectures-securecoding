# PBKDF2 (Password-Based Key Derivation Function 2)

Since a password is not directly applicable as a key to any conventional
cryptosystem, however, some processing of the password is required to perform
cryptographic operations with it. Moreover, as passwords are often chosen
from a relatively small space, special care is required in that processing
to defend against search attacks.

Another approach to password-based cryptography is to construct key derivation
techniques that are relatively expensive, thereby increasing the cost of
exhaustive search. One way to do this is to include an iteration count in the
key derivation technique, indicating how many times to iterate some underlying
function by which keys are derived.

_Example:_

```Java 
String password = "student";
char[] chars = password.toCharArray();

SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
byte[] salt = new byte[16];
random.nextBytes(salt);

int iterations = 1024;
int keyLength = 64 * 8;
```

* A **password** ("student") is taken as input and converted to a character array (chars). 
  Using a char[] is preferred in security-sensitive code because strings in Java are immutable and cannot be cleared from memory.

* A **random 16-byte salt** is generated using SecureRandom with the SHA1PRNG algorithm. Salt helps prevent precomputed attacks (e.g., rainbow table attacks) by making the hash unique for each password.

* **Iterations**: The number of times the PBKDF2 algorithm is applied to slow down brute force attacks. Here, 1024 iterations are used.

* **Key Length**: Specifies the desired length of the derived key in bits. In this case, 64 * 8 results in a 512-bit hash.

```Java 
PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, keyLength);
SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
byte[] hash = factory.generateSecret(spec).getEncoded();
```

* A **PBEKeySpec** object is created using the password (chars), the generated salt (salt), the iteration count, and the key length.

* A **SecretKeyFactory** is initialized with the algorithm **PBKDF2WithHmacSHA1**.

* The derived hash is generated using the **generateSecret()** method, which produces a byte array representation of the hash.

```Java
String storedPassword = iterations + ":" + Hex.encodeHexString(salt) + ":" + Hex.encodeHexString(hash);
```

* The salt and hash are converted to a **hexadecimal string** (using Hex.encodeHexString) for safe and compact storage.

* The resulting string (storedPassword) is in the format:
```
    iterations:salt:hash
```

## Java API

* **PBEKeySpec**: A user-chosen password that can be used with password-based 
  encryption (PBE).
  The password can be viewed as some kind of raw key material, from which the
  encryption mechanism that uses it derives a cryptographic key.

* **SecretKeyFactory**: This class represents a factory for secret keys.
  Key factories are used to convert keys (opaque cryptographic keys of type 
  Key) into key specifications (transparent representations of the underlying key
  material), and vice versa. Secret key factories operate only on secret
  (symmetric) keys.

* **SecretKey**:
    A secret (symmetric) key. The purpose of this interface is to group (and provide
    type safety for) all secret key interfaces.

  * byte[] getEncoded()
    Returns the key in its primary encoding format, or null if this key does not
    support encoding.

_Example:_ WinZip
    When you use AES encryption with WinZip, the passwords that you enter are
    converted into keys of the appropriate length (128 bits or 256 bits, depending
    on the AES key length that you specify).

    This is done through the PBKDF2 algorithm defined in RFC 2898 (also available
    as Public Key Cryptography Standard #5) with an iteration count of 1000. WinZip
    uses 8-byte salt values with 128-bit AES encryption and 16-byte salt values
    with 256-bit encryption.


## References
* [RFC2898: PKCS #5: Password-Based Cryptography Specification Version 2.0](https://tools.ietf.org/html/rfc2898)

* [WinZip - About Encryption](http://kb.winzip.com/help/help_encryption.htm)

*Egon Teiniker, 2016-2024, GPL v3.0* 