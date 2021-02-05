BCrypt - A Future-Adaptable Password Scheme
-------------------------------------------------------------------------------

bcrypt is a key derivation function for passwords designed by Niels Provos and 
David Mazières, based on the Blowfish cipher.

Besides incorporating a salt to protect against rainbow table attacks, bcrypt 
is an adaptive function: over time, the iteration count can be increased to make 
it slower, so it remains resistant to brute-force search attacks even with 
increasing computation power.

The bcrypt function is the default password hash algorithm for BSD and other 
systems including some Linux distributions.

The prefix "$2a$" or "$2b$" (or "$2y$") in a hash string indicates that hash string 
is a bcrypt hash in modular crypt format.
The rest of the hash string includes the cost parameter, a 128-bit salt (base-64 
encoded as 22 characters), and 184 bits of the resulting hash value (base-64 encoded 
as 31 characters). 
The cost parameter specifies a key expansion iteration count as a power of two, which 
is an input to the crypt algorithm.

Example: $2a$10$ClRCVXO0F/7kFTvXk0467Oxdunc6NsMe6Olt9VHu0OPzWHjojnzjm

	prefix: $2a$

	cost parameter: 10  (indicating 2^10 key expansion rounds)

	salt: ClRCVXO0F/7kFTvXk0467O

	resulting hash: xdunc6NsMe6Olt9VHu0OPzWHjojnzjm


