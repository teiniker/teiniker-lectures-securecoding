Cipher Streams
-------------------------------------------------------------------------------

We are able to associate a cipher object with an input or output stream.
When data is written to such an output stream, it is automatically
encrypted, and when data is read from such an input stream, it is
automatically decrypted.
This allows a developer to use Java's normal semantics of nested filter
streams to send and receive encrypted data.

* CipherOutputStream
  Like all classes that extend the FilterOutputStream class, constructing
  a cipher output stream requires that an existing output stream has already
  been created. This allows us to use the existing output stream from a
  socket or a file as the destination stream for the encrypted data:

  public CipherOutputStream(OutputStream outputStream, Cipher cipher)
  	Create a cipher output stream, associating the given cipher object with
  	the existing output stream. The given cipher must already have been
  	initialized, or an IllegalStateException will be thrown.

* CipherInputStream
  Create a filter stream capable of decrypting data as it is read from the
  underlying input stream.
  A cipher input stream is constructed with this method:

  public CipherInputStream(InputStream is, Cipher c)
  	Create a cipher input stream that associates the existing input stream
  	with the given cipher. The cipher must previously have been initialized.

See: Java Security, Chapter 13: Encryption,  O'Reilly, 1998
    http://docstore.mik.ua/orelly/java-ent/security/ch13_01.htm
