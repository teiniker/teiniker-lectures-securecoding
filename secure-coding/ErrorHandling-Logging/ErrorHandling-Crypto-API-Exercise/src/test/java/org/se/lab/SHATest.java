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
}
