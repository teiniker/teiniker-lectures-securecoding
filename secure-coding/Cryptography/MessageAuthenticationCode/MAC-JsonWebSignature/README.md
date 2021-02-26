# JSON Web Signature (JWS)

JSON Web Signature (JWS) represents content secured with digital
signatures or **Message Authentication Codes (MACs)** using JSON-based data structures.
The JWS cryptographic mechanisms provide **integrity protection** for an arbitrary sequence of octets.
      
## JSON Web Signature (JWS) with HMAC protection

The given example demonstrates how to create and verify a JSON Web Signature (JWS) based 
on a hash-based message authentication code (HMAC). 

This requires the producer and consumer to posses a shared secret, negotiated 
through some out-of-band mechanism before the JWS-protected object is communicated.
The payload is a simple "Hello, world!" string but can also be a JSON string or 
a BASE64 encoded byte array.

The Nimbus JOSE+JWT library supports all standard JWS algorithms for HMAC protection.

## References
* [RFC 7515 - JSON Web Signature (JWS)](https://tools.ietf.org/html/rfc7515)
* [JOSE & JSON Web Token (JWT) Examples](https://connect2id.com/products/nimbus-jose-jwt/examples)
* [JWT Debugger](https://jwt.io/)