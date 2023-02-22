# Socket Programming 

Sockets allow the programmer to **treat a network connection as just another stream** onto which bytes can be 
written and from which bytes can be read. 
Sockets shield the programmer from low-level details of the network, such as error detection, package sizes, 
packet retransmission, network addresses, and more.

Stream sockets use a standard communication protocol called **Transmission Control Protocol (TCP)**. 
TCP was specifically designed to provide a **reliable end-to-end byte stream** over an unreliable network.

## Sockets for Servers
On the **server-side**, the program follows the following **life cycle**:

1. A new **ServerSocket** is created on a particular port using a `ServerSocket()` constructor.

2. The `ServerSocket` listens for incoming connection attempts on that port using its **accept()** method. 
    `accept()` blocks until a client attempts to make a connection, at which point `accept()` returns a Socket 
    object connecting the client and the server.

3. Depending on the type of server, either the Socket's `getInputStream()` method, `getOutputStream()` method, 
    or both are called to get **input and output streams** that communicate with the client.

4. The **server and the client interact** according to an agreed-upon protocol until it is time to close the connection.

5. The server, the client, or both **close the connection**.

6. The server **returns to step 2** and waits for the next connection.


## Sockets for Clients 
On the **client-side**, the program follows the following **life cycle**:

1. The program creates a new **Socket** with a constructor.

2. The `Socket` attempts to **connect to the remote host**.

3. The client gets an **input and output streams** from the `Socket` and use those streams to receive and send data 
    from and to the server. This connection is **full-duplex**, both hosts can send and receive data simultaneously.

4. When the transmission of data is complete, one or both sides **close the connection**.


# Java Secure Sockets Extension
To make Internet connections more fundamentally secure, **sockets can be encrypted**. 

The **Java Secure Sockets Extension (JSSE)** can secure network communication using the **Secure Sockets Layer (SSL)** 
Version 3 and **Transport Layer Security (TLS)**:

* **JSSE shields us from the low-level details** of how algorithms are negotiated, keys are exchanged, 
    correspondents are authenticated, and data is encrypted.
    
* **JSSE allows us to create sockets and server sockets** that transparently handle the negotiations and encryption 
    necessary for secure communication.

## Secure Server Sockets
Using an encrypted socket for the server-side is straightforward:

1. Instances of the **SSLServerSocket** are created by an abstract factory class called `SSLServerSocketFactory`. 

2. An instance of `SSLServerSocketFactory` is returned by a static `getDefault()` method.

_Example_: Create a secure server socket
```Java
    try(SSLServerSocket server = 
        (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(9013))
    {
        while(true)
        {
            try(SSLSocket connection = (SSLSocket) server.accept())
            {
                SSLSession sslSession = connection.getSession();
                connection.setEnabledProtocols(new String[] {"TLSv1.3"});
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                Date now = new Date();
                out.write(now.toString() + "\r\n");
                out.flush();
            }
            catch (IOException e)
            {
                throw new IllegalStateException("Can't establish a secure socket connection!", e);
            } 
        }
    } 
    catch (IOException e)
    {
        throw new IllegalStateException("Can't create a secure socket!", e);
    }
```

## Secure Client Sockets
In order to use a secure client socket:

1. We get a Socket from a `SSLSocketFactory` using its `createSocket()` method.

2. `SSLSocketFactory` follows the abstract factory design pattern, so we get an instance of it by invoking the 
    static `getDefault()` method.
    
3. Once the secure socket has been created, we can **use it like any other socket**, through its `getInputStream()`, 
    `getOutputStream()`, and other methods.

_Example_: Create a secure client socket
```Java
    public static void main(String... args)
    {
        try(SSLSocket socket = 
            (SSLSocket) SSLSocketFactory.getDefault().createSocket("localhost", 9013))
        {
            InputStream in = socket.getInputStream();
            StringBuilder buffer = new StringBuilder();
            int c;
            while((c=in.read()) != -1)
            {
                buffer.append((char)c);
            }
            System.out.println("It is : " + buffer);
        }
        catch(IOException e)
        {
            throw new IllegalStateException("Can't establish a secure socket connection!", e);
        }
    }
```

## Cipher Suites
**TLS uses different algorithms** at various stages of creating and managing a secure
socket. **These combinations of algorithms are referred to as cipher suites**.
   
If the two endpoints of a network connection do not share a common suite, the
connection will fail before any application data is transmitted.
   
_Example_: `TLS_RSA_WITH_AES_256_CBC_SHA256`
```   
   TLS                 Identifies the suites as TLS (opposed to SSL)
   RSA                 The key exchange and authentication algorithm.
   WITH_AES_256_CBC    The specification of the bulk encryption cipher, its key size and mode.
   SHA256              The message authentication algorithm
```   

Note that this pattern can vary but general rules are:
* Don't use suites that list ANON for authentication (they don't provide authentication)
* Don't use suites that contain NULL.
* Avoid use of suites that contain EXPORT.
* Use bulk ciphers with key size of 128 bits or larger
* Try to avoid suites using RC4, DES and 3DES
Prefer ECDHE and DHE for key agreement. While they are slower, they provide stronger
protection even if the private keys are later compromised (forward security)
   
In **TLS 1.3** there are now just five **recommended cipher suites**:
``` 
   TLS_AES_256_GCM_SHA384
   TLS_CHACHA20_POLY1305_SHA256
   TLS_AES_128_GCM_SHA256
   TLS_AES_128_CCM_8_SHA256
   TLS_AES_128_CCM_SHA256
``` 
   
**TLS 1.3 has eliminated support for algorithms and ciphers** that are both
theoretically and practically vulnerable. This includes:
``` 
   RC4 Stream Cipher
   RSA Key Exchange
   SHA-1 Hash Function
   CBC (Block) Mode Ciphers
   MD5 Algorithm
   Various non-ephemeral Diffie-Hellman groups
   EXPORT-strength ciphers
   DES
   3DES
``` 

## References
* Jim Manico, August Detlefsen.
  **Iron-Clad Java: Building Secure Web Applications**.
  Chapter 6: Protecting Sensitive Data.
  Oracle Press, 2014

* [The Java Tutorials: Lesson: All About Sockets](https://docs.oracle.com/javase/tutorial/networking/sockets/index.html)

* [TLS 1.3: Everything you need to know](https://securityboulevard.com/2019/07/tls-1-3-everything-you-need-to-know/)

* [Galois/Counter Mode (GCM)](https://en.wikipedia.org/wiki/Galois/Counter_Mode)


*Egon Teiniker, 2019-2021, GPL v3.0*