package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnsignedIntegerTest
{
	/*
	 * The char type is the only unsigned primitive type in Java; 
	 * its representable range of values contains only non-negative values.
	 * 
	 * Consequently, attempting to store and retrieve a value from a 
	 * variable of any of the other integral primitive types will produce 
	 * unexpected results when that value is negative.
	 */
	@Test
	public void testChar()
	{
		int i = -1;
		char c = (char)i;
		
		assertEquals(Character.MAX_VALUE, c); //!!!!
	}
}
