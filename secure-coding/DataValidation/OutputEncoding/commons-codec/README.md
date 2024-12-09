# Apache Commons Codec Libryrary

The Apache Commons Codec library is part of the Apache Commons project, 
and it provides a set of high-level **encoding and decoding utilities** 
for common formats and algorithms. 

It is widely used in Java applications to handle tasks like **text encoding**, 
**binary-to-text conversions**, and **cryptographic hashing**.

By providing robust and straightforward implementations, Apache Commons 
Codec helps developers streamline encoding and decoding tasks in Java projects.

## Base64 Encoding/Decoding

Provides efficient encoding and decoding for Base64, which is commonly 
used for encoding binary data into a textual format for transmission 
over text-based protocols like HTTP or email.

_Example_: Encode byte array into a Base64 string.
```java
    byte[] binaryData = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15	};	

    String base64String = Base64.encodeBase64String(binaryData);
    Assert.assertEquals("AAECAwQFBgcICQoLDA0ODw==", base64String);
```

_Example:_ Decode Base64 string into a byte array.
```java
    String base64String =   "AAECAwQFBgcICQoLDA0ODw==";
    byte [] binaryData = Base64.decodeBase64(base64String);
    
    final byte[] EXPECTED = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15	};
    Assert.assertArrayEquals(EXPECTED, binaryData);
```


## Hexadecimal Encoding/Decoding

Converts binary data to a hexadecimal string or vice versa.

_Example:_ Encode byte aray into a hexadecimal string.  
```java
    byte[] binaryData = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15	};

    String hexString = Hex.encodeHexString(binaryData);
    Assert.assertEquals("000102030405060708090a0b0c0d0e0f", hexString);
```

_Example:_ Decode hexadecimal string into a byte array.
```java
    String hexString = "000102030405060708090a0b0c0d0e0f";
    byte [] binaryData = Hex.decodeHex(hexString.toCharArray());

    final byte[] EXPECTED = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15	};
    Assert.assertArrayEquals(EXPECTED, binaryData);
```


## URL Encoding/Decoding

Handles encoding and decoding of data for safe transmission in URLs.

_Example_: Encode a string for URL transmission.
```java
    String s = "app?path=\\..\\..\\home&username=homer";
    String urlString = codec.encode(s);

    Assert.assertEquals("app%3Fpath%3D%5C..%5C..%5Chome%26username%3Dhomer", urlString);
```

_Example:_ Decode a URL-encoded string.
```java
    String urlString = "app%3Fpath%3D%5C..%5C..%5Chome%26username%3Dhomer";
    String s = codec.decode(urlString);
    
    Assert.assertEquals("app?path=\\..\\..\\home&username=homer", s);
```


## Character Encodings

Tools to convert text between different character encodings, e.g., UTF-8, ISO-8859-1.


## Setup 

To include Apache Commons Codec in a **Maven** project, use the following **dependency**:
    
```xml
<dependency>
    <groupId>commons-codec</groupId>
    <artifactId>commons-codec</artifactId>
    <version>1.17.1</version> <!-- Replace with the latest version -->
</dependency>
```


## References

* [Apache Commons Codec](https://commons.apache.org/proper/commons-codec/)

*Egon Teiniker, 2016-2024, GPL v3.0*