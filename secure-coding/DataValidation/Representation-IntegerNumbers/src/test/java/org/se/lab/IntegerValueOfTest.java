package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntegerValueOfTest
{

	@Test
	public void testValidIntegerValue()
	{
		String input = "-31415";		
		int value = Integer.valueOf(input);
		
		assertEquals(-31415, value);
	}
	
	
	@Test(expected=NumberFormatException.class)
	public void testInvalidIntegerValue()
	{
		String input = "3.14";		
		Integer.valueOf(input);
	}

}
