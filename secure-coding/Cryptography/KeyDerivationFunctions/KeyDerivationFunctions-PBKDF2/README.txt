PBKDF2 (Password-Based Key Derivation Function 2)
-------------------------------------------------------------------------------

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

Java API
-------------------------------------------------------------------------------
PBEKeySpec
A user-chosen password that can be used with password-based encryption (PBE).
The password can be viewed as some kind of raw key material, from which the
encryption mechanism that uses it derives a cryptographic key.

SecretKeyFactory
This class represents a factory for secret keys.
Key factories are used to convert keys (opaque cryptographic keys of type Key)
into key specifications (transparent representations of the underlying key
material), and vice versa. Secret key factories operate only on secret
(symmetric) keys.

- SecretKey generateSecret​(KeySpec keySpec)
  Generates a SecretKey object from the provided key specification (key material).

SecretKey
A secret (symmetric) key. The purpose of this interface is to group (and provide
type safety for) all secret key interfaces.
- byte[] getEncoded()
  Returns the key in its primary encoding format, or null if this key does not
  support encoding.

Example: WinZip
-------------------------------------------------------------------------------
When you use AES encryption with WinZip, the passwords that you enter are
converted into keys of the appropriate length (128 bits or 256 bits, depending
on the AES key length that you specify).
This is done through the PBKDF2 algorithm defined in RFC 2898 (also available
as Public Key Cryptography Standard #5) with an iteration count of 1000. WinZip
uses 8-byte salt values with 128-bit AES encryption and 16-byte salt values
with 256-bit encryption.


References:
> RFC2898: PKCS #5: Password-Based Cryptography Specification Version 2.0
    https://tools.ietf.org/html/rfc2898

> WinZip - About Encryption
    http://kb.winzip.com/help/help_encryption.htm
