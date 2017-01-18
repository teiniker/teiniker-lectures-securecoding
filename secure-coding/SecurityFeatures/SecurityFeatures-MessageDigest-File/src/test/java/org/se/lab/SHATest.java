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
	public void testSHA1() 
		throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		String message = "mypassword"; 
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-1");		
		algorithm.update(message.getBytes("UTF-8"));
		byte[] bytes = algorithm.digest();

		String hexString = Hex.encodeHexString(bytes);		
		assertEquals(40, hexString.length()); 
		assertEquals("91dfd9ddb4198affc5c194cd8ce6d338fde470e2", hexString);
		
		String base64String = Base64.encodeBase64String(bytes);
		assertEquals(28, base64String.length()); 
		assertEquals("kd/Z3bQZiv/FwZTNjObTOP3kcOI=", base64String);
	}

	
	@Test
	public void testSHA256() 
		throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		String message = "mypassword"; 
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");		
		algorithm.update(message.getBytes("UTF-8"));
		byte[] bytes = algorithm.digest();

		String hexString = Hex.encodeHexString(bytes);
		assertEquals(64, hexString.length()); 
		assertEquals("89e01536ac207279409d4de1e5253e01f4a1769e696db0d6062ca9b8f56767c8", hexString);

		String base64String = Base64.encodeBase64String(bytes);
		assertEquals(44, base64String.length()); 
		assertEquals("ieAVNqwgcnlAnU3h5SU+AfShdp5pbbDWBiypuPVnZ8g=", base64String);
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
