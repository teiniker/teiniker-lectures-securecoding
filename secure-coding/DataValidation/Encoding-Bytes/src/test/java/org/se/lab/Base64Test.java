package org.se.lab;

import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;

/*
 * The Base64 class provides Base64 encoding and decoding 
 * as defined by RFC 2045.
 */

public class Base64Test
{
	@Test
	public void testBinaryDataToBase64String()
	{
		byte[] binaryData = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15	};
	
		String base64String = Base64.encodeBase64String(binaryData);
		Assert.assertEquals("AAECAwQFBgcICQoLDA0ODw==", base64String);
	}

	@Test
	public void testBase64ToBinaryData()
	{
		String base64String = "AAECAwQFBgcICQoLDA0ODw==";
			
		byte [] binaryData = Base64.decodeBase64(base64String);
		
		final byte[] EXPECTED = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15	};
		Assert.assertArrayEquals(EXPECTED, binaryData);
	}
}
