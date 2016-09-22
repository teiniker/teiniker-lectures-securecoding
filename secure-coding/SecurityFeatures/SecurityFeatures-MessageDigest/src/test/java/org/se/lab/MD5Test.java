package org.se.lab;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;


/* DON'T USE MD5 IN YOUR APPLICATIONS!!! */

public class MD5Test
{
	@Test
	public void testMd5() 
		throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		String message = "mypassword"; 
		
		MessageDigest algorithm = MessageDigest.getInstance("MD5");		
		algorithm.update(message.getBytes("UTF-8"));
		byte[] bytes = algorithm.digest();

		String hash = Hex.encodeHexString(bytes);
		assertEquals(32, hash.length());
		assertEquals("34819d7beeabb9260a5c854bc85b3e44", hash);
		
		String base64String = Base64.encodeBase64String(bytes);
		assertEquals(24, base64String.length()); 
		assertEquals("NIGde+6ruSYKXIVLyFs+RA==", base64String);
	}
}
