package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class Base64Test
{
	@Test
	public void test3Bytes()
	{
		byte[] binaryData = 
		{ 
			(byte)0x1a,(byte)0xcf,(byte)0xd2
		};
		
		String base64String = Base64.toBase64String(binaryData);
		
		Assert.assertEquals("Gs/S", base64String);
	}

	
	@Test
	public void test6Bytes()
	{
		byte[] binaryData = 
		{ 
			(byte)0x1a,(byte)0xcf,(byte)0xd2, 
			(byte)0x32, (byte)0xee, (byte)0x11
		};
		
		String base64String = Base64.toBase64String(binaryData);
		
		Assert.assertEquals("Gs/SMu4R", base64String);
	}


	@Test
	public void test9Bytes()
	{
		byte[] binaryData =
		{ 
			(byte)0x1a,(byte)0xcf,(byte)0xd2, 
			(byte)0x32, (byte)0xee, (byte)0x11,
			(byte)0x46, (byte)0xcc, (byte)0x33
		};
		
		String base64String = Base64.toBase64String(binaryData);
		
		Assert.assertEquals("Gs/SMu4RRswz", base64String);
	}
}
