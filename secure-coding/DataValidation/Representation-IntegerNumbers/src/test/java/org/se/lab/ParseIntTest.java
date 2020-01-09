package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParseIntTest
{
	@Test
	public void testParseInt()
	{
		String input = "-31415";		
		int value = Integer.parseInt(input);
		
		assertEquals(-31415, value);
	}

	@Test
	public void testValueOf()
	{
		String input = "-31415";
		Integer value = Integer.valueOf(input);

		assertEquals(-31415, value.intValue());
	}


	@Test(expected=NumberFormatException.class)
	public void testInvalidIntegerValue()
	{
		String input = "3.14";		
		Integer.parseInt(input);
	}
}
