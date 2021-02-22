SCrypt
-------------------------------------------------------------------------------
SCrypt is a password-based key derivation function created by Colin Percival.

With existing key derivation algorithms, even when the iteration count is
increased so that the time taken to verify a password remains constant, the
cost of finding a password by using a brute-force attack implemented in
hardware drops each year.

The scrypt function aims to reduce the advantage that attackers can gain by using
custom-designed parallel circuits for breaking password-based key derivation
functions.

The scrypt function takes several parameters:
    - The passphrase P is typically a human-chosen password.
      The salt is normally uniquely and randomly generated [RFC4086].
    - The parameter r ("blockSize") specifies the block size.
    - The CPU/Memory cost parameter N ("costParameter") must be larger than 1,
       a power of 2, and less than 2^(128 * r / 8).
    - The parallelization parameter p ("parallelizationParameter") is a positive
      integer less than or equal to ((2^32-1) * 32) / (128 * r).

Users of scrypt can tune the parameters N, r, and p according to the amount
of memory and computing power available, the latency-bandwidth product of the
memory subsystem, and the amount of parallelism desired.

At the current time, r=8 and p=1 appears to yield good results, but as memory
latency and CPU parallelism increase, it is likely that the optimum values for
both r and p will increase.


SCryptUtil implements a modified version of MCF, the modular crypt format, similar
to the one used for storage of Unix passwords in the bcrypt format.

public static String scrypt(String passwd, int N, int r, int p)
    Hash the supplied plaintext password and generate output in the
    modified MCF format:
        passwd    Password.
        N         CPU cost parameter.
        r         Memory cost parameter.
        p         Parallelization parameter.

public static boolean check(String passwd, String hashed)
    Compare the supplied plaintext password to a hashed password.
        passwd  Plaintext password.
        hashed  scrypt hashed password.

The output of SCryptUtil.scrypt is a string in the modified MCF format:

  $s0$params$salt$key

  s0     - version 0 of the format with 128-bit salt and 256-bit derived key
  params - 32-bit hex integer containing log2(N) (16 bits), r (8 bits), and p (8 bits)
  salt   - base64-encoded salt
  key    - base64-encoded derived key

  Example:

    $s0$e0801$epIxT/h6HbbwHaehFnh/bw==$7H0vsXlY8UxxyW/BWx/9GuY7jEvGjT71GFd6O4SZND0=

    passwd = "secret"
         N = 16384
         r = 8
         p = 1

References:
-------------------------------------------------------------------------------
> RFC 7914: The scrypt Password-Based Key Derivation Function
    https://tools.ietf.org/html/rfc7914

> SCryptUtil
    https://github.com/wg/scrypt
