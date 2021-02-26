# JSON Web Token (JWT)

JWT is an open standard (RFC 7519) that defines a compact and self-contained 
way for **securely transmitting information between parties** as a JSON object. 

This information can be verified and trusted because it is digitally signed. 
JWTs can be signed using a **secret** (with the HMAC algorithm) or a public/private 
key pair using RSA.

Here are some scenarios where JSON Web Tokens are useful:

* **Authentication**: This is the most common scenario for using JWT. Once the user 
	is logged in, each subsequent request will include the JWT, allowing the user 
	to access routes, services, and resources that are permitted with that token. 
	Single Sign On is a feature that widely uses JWT nowadays, because of its small 
	overhead and its ability to be easily used across different domains.

* **Information Exchange**: JSON Web Tokens are a good way of securely transmitting 
	information between parties, because as they can be signed, for example using 
	public/private key pairs, you can be sure that the senders are who they say they 
	are. 
	Additionally, as the signature is calculated using the header and the payload, 
	you can also verify that the content hasn't been tampered with.

JSON Web Tokens consist of three parts separated by dots (.), which are:

* **Header**: The header typically consists of two parts: the type of the token, 
	which is JWT, and the hashing algorithm being used, such as HMAC SHA256 or RSA.

* **Payload**: The second part of the token is the payload, which contains the claims. 
	Claims are statements about an entity (typically, the user) and additional metadata. 
	There are three types of claims: reserved, public, and private claims.
	* **Reserved claims**: These is a set of predefined claims which are not mandatory but 
	  recommended, to provide a set of useful, interoperable claims. Some of them are: 
	  iss (issuer), exp (expiration time), sub (subject), aud (audience), and others.
	* **Public claims**: These can be defined at will by those using JWTs. But to avoid 
	  collisions they should be defined in the IANA **JSON Web Token Registry** or be defined 
	  as a URI that contains a collision resistant namespace.  
	* **Private claims**: These are the custom claims created to share information between 
	  parties that agree on using them.  
	The payload is then Base64Url encoded to form the second part of the JSON Web Token.

* **Signature**: To create the signature part you have to take the encoded header, the 
   encoded payload, a secret, the algorithm specified in the header, and sign that.
   The signature is used to verify that the sender of the JWT is who it says it is and 
   to ensure that the message wasn't changed along the way.	


Therefore, a JWT typically looks like the following: `xxxxx.yyyyy.zzzzz`

_Example_: see: https://jwt.io/
```
    eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZWluaSJ9.yB3aNe-WLS8LKlWsm7tZpf5ioIii7nb8SN3BlYOeMHQ

    {
      "alg": "HS256"
    }
    {
      "sub": "teini"
    }
    HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), your-256-bit-secret)
```

## References
* [RFC 7519 - JSON Web Token (JWT)](https://tools.ietf.org/html/rfc7519)
* [JWT Debugger](https://jwt.io/)