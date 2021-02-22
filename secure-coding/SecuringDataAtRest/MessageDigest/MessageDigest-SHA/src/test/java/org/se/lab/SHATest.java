package org.se.lab;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;


public class SHATest
{
	@Test
	public void testSHA256() 
		throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		String message = "My important message.";
		byte[] inBytes = message.getBytes("UTF-8");

		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		algorithm.update(inBytes);
		byte[] bytes = algorithm.digest();

		String hexString = Hex.encodeHexString(bytes);
		assertEquals(64, hexString.length()); 
		assertEquals("87a35633cf9f3636ec25fe9b53e631f38c06fc38c9fee1f0a52bc852a978ff3c", hexString);

		String base64String = Base64.encodeBase64String(bytes);
		assertEquals(44, base64String.length()); 
		assertEquals("h6NWM8+fNjbsJf6bU+Yx84wG/DjJ/uHwpSvIUql4/zw=", base64String);
	}

	
	@Test
	public void testSHA512() 
		throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		String message = "mypassword";

		MessageDigest algorithm = MessageDigest.getInstance("SHA-512");		
		algorithm.update(message.getBytes("UTF-8"));
		byte[] bytes = algorithm.digest();

		String hexString = Hex.encodeHexString(bytes);
		assertEquals(128, hexString.length()); // 128 hex characters = 64 bytes
		assertEquals("a336f671080fbf4f2a230f313560ddf0d0c12dfcf1741e49e8722a234673037dc493caa8d291d8025f71089d63cea809cc8ae53e5b17054806837dbe4099c4ca", hexString);
		
		String base64String = Base64.encodeBase64String(bytes);
		assertEquals(88, base64String.length()); 
		assertEquals("ozb2cQgPv08qIw8xNWDd8NDBLfzxdB5J6HIqI0ZzA33Ek8qo0pHYAl9xCJ1jzqgJzIrlPlsXBUgGg32+QJnEyg==", base64String);
	}
}
