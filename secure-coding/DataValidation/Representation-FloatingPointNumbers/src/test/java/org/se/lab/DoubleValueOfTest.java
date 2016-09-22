package org.se.lab;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoubleValueOfTest
{
	private final static double DELTA = 1E-6;
	
	@Test
	public void testValidDoubleValue()
	{
		String input = "-3.1415";		
		double value = Double.valueOf(input);
		
		assertEquals(-3.1415, value, DELTA);
	}


	@Test(expected=NumberFormatException.class)
	public void testInvalidDoubleValue()
	{
		String input = "one";		
		Double.valueOf(input);
	}

	
	@Test
	public void testNaN()
	{
		String input = "NaN";		
		double value = Double.valueOf(input);
		
		assertTrue(Double.isNaN(value));
		out.println(value);
	}
	
	@Test
	public void testInfinity()
	{
		String input = "Infinity";		
		double value = Double.valueOf(input);
		
		assertTrue(Double.isInfinite(value));
		out.println(value);
	}
	
}
