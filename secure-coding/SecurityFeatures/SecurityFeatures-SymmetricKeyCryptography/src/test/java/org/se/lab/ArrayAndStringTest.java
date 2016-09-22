package org.se.lab;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

public class ArrayAndStringTest
{	
	@Test
	public void testByteArrayAndString() 
		throws UnsupportedEncodingException
	{
		String input = "This is an important message!";

		byte[] inputBytes = input.getBytes("UTF-8");
		System.out.println("encoded: " + Hex.encodeHexString(inputBytes));
		
		String output = new String(inputBytes);
		
		Assert.assertEquals("This is an important message!", output);
	}

}
