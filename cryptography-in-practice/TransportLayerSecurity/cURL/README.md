# Scripting HTTP Requests 

The increasing amount of applications moving to the web has made **HTTP Scripting** more frequently 
requested and wanted. 
To be able to automatically extract information from the web, to fake users, to post or upload data 
to web servers are all important tasks today.

**curl** is a command line tool for doing all sorts of URL manipulations and transfers.

## HTTP Protocol
HTTP is the protocol used to fetch data from web servers. 
It is a very simple protocol that is **built upon TCP/IP**. 

**HTTP is plain ASCII text** lines being sent by the client to a server to request a particular action, 
and then the server replies a few text lines before the actual requested content is sent to the client.

The **HTTP client**, curl, sends a **HTTP request**. The request contains a **method** (like GET, POST, HEAD etc), 
a number of **request headers** and sometimes a **request body**. 

The **HTTP server** responds with a **status line** (indicating if things went well), **response headers** and 
most often also a **response body**. The "body" part is the plain data you requested, like the actual HTML or 
the image etc.

### Uniform Resource Locator (URL)
The Uniform Resource Locator format is how you specify the address of a particular resource on the Internet (RFC 3986). 

The **host** name is usually resolved using DNS or our `/etc/hosts` file to an IP address and that's what `curl` will 
communicate with. Alternatively we specify the IP address directly in the URL instead of a name.

Each protocol curl supports operates on a default **port number**, be it over TCP or in some cases UDP. 
We can specify the port number in the URL with a colon and a number immediately following the host name. 

_Example_: URL for a local running web application: `http://localhost:8080/Servlet-Translator/`

### GET Requests
The simplest and most common request/operation made using HTTP is to GET a URL.
The client issues a GET request to the server and receives the document it asked for.

Note that all HTTP replies contain a set of **response headers** that are normally hidden.

_Example_: HTTP GET request and response (including headers)
```
$ curl -i http://localhost:8080/Servlet-Translator/
HTTP/1.1 200 OK
Connection: keep-alive
Last-Modified: Fri, 14 May 2021 07:59:26 GMT
Content-Type: text/html
Content-Length: 944
Accept-Ranges: bytes
Date: Fri, 14 May 2021 17:15:22 GMT

<html>
...
</html>
```
By using the **--include (-i)** option, `curl` includes the HTTP response headers in the output. 
The HTTP response headers can include things like server name, cookies, date of the document, HTTP version and more...


### HEAD Request
You can ask the remote server for **ONLY the headers** by using the **--head (-I)** option which will make `curl` 
issue a HEAD request.

_Example_: HTTP HEAD request 
```
$ curl -I http://localhost:8080/Servlet-Translator/
HTTP/1.1 200 OK
Connection: keep-alive
Last-Modified: Fri, 14 May 2021 07:59:26 GMT
Content-Type: text/html
Content-Length: 944
Accept-Ranges: bytes
Date: Fri, 14 May 2021 18:13:54 GMT
```
The HEAD method is defined and made so that the server returns the headers exactly the way it would do for a GET, 
but without a body.


### POST Requests
The HTTP protocol then offers the POST method which sends the **data separated from the URL** and thus we won't 
see any of it in the URL address field.

_Example_: HTTP POST request and response (including headers)
```
$ curl -i -X POST -d 'word=cat&language=Deutsch&action=Translate' http://localhost:8080/Servlet-Translator/controller
HTTP/1.1 200 OK
Connection: keep-alive
Content-Type: text/html;charset=ISO-8859-1
Content-Length: 171
Date: Fri, 14 May 2021 18:18:40 GMT

<html> 
...
</html>
```
The **-X option** specifies which HTTP request method will be used when communicating with the remote server.

The **--data (-d)** option causes `curl` to send the data using the `application/x-www-form-urlencoded` Content-Type.
The data we send to the server MUST already be properly encoded, curl will not do that for us.
For example, if we want the data to contain a space, you need to replace that space with `%20` etc.


### HTTP Proxy
Sometimes we may use a local proxy, and then you may need to **specify that proxy's port** number separately 
for what `curl` needs to connect to locally.

_Example_: HTTP GET request using a **local proxy**
```
$ curl -i --proxy http://localhost:8010 http://localhost:8080/Servlet-Translator/
HTTP/1.1 200 OK
Connection: close
Last-Modified: Fri, 14 May 2021 07:59:26 GMT
Content-Type: text/html
Content-Length: 944
Accept-Ranges: bytes
Date: Fri, 14 May 2021 18:30:14 GMT

<html>
...
</html>
```
The proxy details can be supplied using or **-–proxy (-x)** option.

### Transport Layer Security (TLS)
TLS is a cryptographic security layer on top of TCP that makes the data tamper proof and guarantees server 
authenticity, based on strong public key cryptography and digital signatures.

Using the **--verbose (-v)** option, we can get information about which **cipher and TLS version** are negotiated. 

`curl` is designed to use a "safe version" of SSL/TLS by default, but we can also **specify the protocol version**:
* **--tlsv1.3** TLS >= version 1.3
* **--tlsv1.2** TLS >= version 1.2  
* **--tlsv1.1** TLS >= version 1.1
* **--tlsv1.0** TLS >= version 1.0
* **--sslv3**   SSL version 3
* **--sslv2**   SSL version 2

To check that it communicates with the right TLS server, `curl` uses a **set of locally stored CA certificates** 
to verify the signature of the server's certificate. 
All servers provide a certificate to the client as **part of the TLS handshake** and all public TLS-using servers 
have acquired that certificate from an established Certificate Authority.

_Example_: **HTTPS GET request and response** without verifying the server's certificate
```
$ curl -k -v https://localhost:8443/Servlet-SSL-Translator/
*   Trying ::1...
* TCP_NODELAY set
* Expire in 149998 ms for 3 (transfer 0x556b55747f50)
* Expire in 200 ms for 4 (transfer 0x556b55747f50)
* connect to ::1 port 8443 failed: Connection refused
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Expire in 149998 ms for 3 (transfer 0x556b55747f50)
* Connected to localhost (127.0.0.1) port 8443 (#0)
* ALPN, offering h2
* ALPN, offering http/1.1
* successfully set certificate verify locations:
*   CAfile: none
  CApath: /etc/ssl/certs
* TLSv1.3 (OUT), TLS handshake, Client hello (1):
* TLSv1.3 (IN), TLS handshake, Server hello (2):
* TLSv1.2 (IN), TLS handshake, Certificate (11):
* TLSv1.2 (IN), TLS handshake, Server key exchange (12):
* TLSv1.2 (IN), TLS handshake, Server finished (14):
* TLSv1.2 (OUT), TLS handshake, Client key exchange (16):
* TLSv1.2 (OUT), TLS change cipher, Change cipher spec (1):
* TLSv1.2 (OUT), TLS handshake, Finished (20):
* TLSv1.2 (IN), TLS handshake, Finished (20):
* SSL connection using TLSv1.2 / ECDHE-RSA-AES256-GCM-SHA384
* ALPN, server accepted to use h2
* Server certificate:
*  subject: CN=localhost
*  start date: Nov  6 09:43:19 2020 GMT
*  expire date: Nov  4 09:43:19 2030 GMT
*  issuer: CN=localhost
*  SSL certificate verify result: self signed certificate (18), continuing anyway.
* Using HTTP2, server supports multi-use
* Connection state changed (HTTP/2 confirmed)
* Copying HTTP/2 data in stream buffer to connection buffer after upgrade: len=0
* Using Stream ID: 1 (easy handle 0x556b55747f50)
> GET /Servlet-SSL-Translator/ HTTP/2
> Host: localhost:8443
> User-Agent: curl/7.64.0
> Accept: */*
> 
* Connection state changed (MAX_CONCURRENT_STREAMS == 4294967295)!
< HTTP/2 200 
< last-modified: Fri, 14 May 2021 07:59:26 GMT
< content-type: text/html
< content-length: 944
< accept-ranges: bytes
< date: Fri, 14 May 2021 18:49:37 GMT
< 
<html>
...
</html>
```
In some circumstances (local tests), we may decide that we still want to communicate with a TLS server even if 
the certificate verification fails. 
The **--insecure (-k)** option option allows `curl` to proceed and operate even for server connections otherwise 
considered insecure.


## References
* [The Art Of Scripting HTTP Requests Using Curl](https://curl.se/docs/httpscripting.html)
* [Everything curl](https://everything.curl.dev/)

*Egon Teiniker, 2016-2024, GPL v3.0*