package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * Cipher Streams
 * 
 * We are able to associate a cipher object with an input or output stream. 
 * When data is written to such an output stream, it is automatically 
 * encrypted, and when data is read from such an input stream, it is 
 * automatically decrypted. 
 * This allows a developer to use Java's normal semantics of nested filter 
 * streams to send and receive encrypted data. 
 * 
 * CipherOutputStream 
 * Like all classes that extend the FilterOutputStream class, constructing 
 * a cipher output stream requires that an existing output stream has already 
 * been created. This allows us to use the existing output stream from a 
 * socket or a file as the destination stream for the encrypted data:
 * 	
 * 	public CipherOutputStream(OutputStream outputStream, Cipher cipher)
 * 	Create a cipher output stream, associating the given cipher object with 
 * 	the existing output stream. The given cipher must already have been 
 * 	initialized, or an IllegalStateException will be thrown.
 * 
 * CipherInputStream
 * Create a filter stream capable of decrypting data as it is read from the 
 * underlying input stream.
 * A cipher input stream is constructed with this method:
 * 
 * 	public CipherInputStream(InputStream is, Cipher c)
 * 	Create a cipher input stream that associates the existing input stream 
 * 	with the given cipher. The cipher must previously have been initialized.
 * 
 * 	See: Java Security, Chapter 13: Encryption,  O'Reilly, 1998
 * 		 http://docstore.mik.ua/orelly/java-ent/security/ch13_01.htm
 */

public class SymmetricCipherStreamTest
{
	private final static String FILE_NAME = "secure-data.bin";
	private final static int MAX_SIZE = 256;
	
	private Cipher cipher;
	private SecretKey key;
	
	@Before
	public void setup() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException
	{
		// Using the Advanced Encryption Standard (AES) algorithm
		key = KeyGenerator.getInstance("AES").generateKey();
		cipher = Cipher.getInstance("AES");
	}
	
	
	@Test
	public void testChipherOutputStream() throws IOException, InvalidKeyException
	{
		{	// sender
			byte[] buffer = new byte[MAX_SIZE];
			for(int i=0; i<MAX_SIZE; i++)
				buffer[i] = (byte)i;
	
			System.out.println("send:    " + Hex.encodeHexString(buffer));
			
			// After we generate the key, we must create the cipher object, 
			// initialize it with that key, and then use that cipher object 
			// to construct our output stream. 
			// Once the data is sent to the stream, we close the stream, which 
			// flushes the cipher object, performs any necessary padding, 
			// and completes the encryption. 
			cipher.init(Cipher.ENCRYPT_MODE, key);
			CipherOutputStream out = 
					new CipherOutputStream(new FileOutputStream(new File(FILE_NAME)), cipher);		
			out.write(buffer);
			// If we don't explicitly close the stream, when the program exits, 
			// data that is buffered in the cipher object itself will not get 
			// flushed to the file. The resulting encrypted file will be 
			// unreadable, as it won't have the correct amount of data in its 
			// last block.
			out.close();
		}
	
		File file = new File(FILE_NAME);
		Assert.assertTrue(file.exists());
		FileInputStream fin = new FileInputStream(new File(FILE_NAME));
		byte[] data = new byte[MAX_SIZE];
		fin.read(data);
		fin.close();
		System.out.println("store:   " + Hex.encodeHexString(data));
		
		{	// receiver	
			// Here we take the secret key and then create the cipher object 
			// initialized with that key. Then we can create our input stream 
			// and read the data from the stream, automatically decrypting it 
			// as it goes.
			cipher.init(Cipher.DECRYPT_MODE, key);
			CipherInputStream in = 
					new CipherInputStream(new FileInputStream(new File(FILE_NAME)), cipher);

			byte[] buffer = new byte[MAX_SIZE];
			in.read(buffer);
			in.close();
			
			System.out.println("receive: " + Hex.encodeHexString(buffer));
			
			for(int i=0; i<MAX_SIZE; i++)
				Assert.assertEquals((byte)i,buffer[i]);
		}		
	}
}