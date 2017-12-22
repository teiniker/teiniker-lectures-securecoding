package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class Base16Test
{
	@Test
	public void test3Bytes()
	{
		byte[] binaryData = 
		{ 
			(byte)0x1a,(byte)0xcf,(byte)0xd2
		};
		
		String base16String = Base16.toBase16String(binaryData);
		
		Assert.assertEquals("1ACFD2", base16String);
	}

	
	@Test
	public void test6Bytes()
	{
		byte[] binaryData = 
		{ 
			(byte)0x71,(byte)0xaa,(byte)0xbf, 
			(byte)0xea, (byte)0x12, (byte)0xf1
		};
		
		String base16String = Base16.toBase16String(binaryData);
		
		Assert.assertEquals("71AABFEA12F1", base16String);
	}
}
