# Output Encoding

Applications employ several different **encoding schemes for their data**.

In particular this is true for web applications. Both the **HTTP protocol** and the **HTML language** are historically 
text-based, and different encoding schemes have been devised to ensure that unusual characters and binary data can be 
safely handled by these mechanisms.

* **Encoding Characters**
  * Exercise:[HTML Encoding](Encoding-HTML-Exercise/) ([Model Solution](Encoding-HTML-Exercise/)
  * Demo: [OWASP Encoder](OWASP-Encoder/)
  * Demo: [URL Encoder](Encoding-URL/)
  
* **Encoding Bytes**
  * [Commons Codec](commons-codec/)
  * Demo: [Hex and Base64 Encoding](Encoding-Bytes/)
  * Exercise:[Base16](Base16-Encoding-Exercise/) ([Model Solution](Base16-Encoding/))
  * Exercise:[Base64](Base64-Encoding-Exercise/) ([Model Solution](Base64-Encoding/))
  * Demo: [Base64 + Padding](Base64-Padding/)  


## References
* [RFC4648: The Base16, Base32, and Base64 Data Encodings](https://datatracker.ietf.org/doc/html/rfc4648)

*Egon Teiniker, 2016-2024, GPL v3.0*