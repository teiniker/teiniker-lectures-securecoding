package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegerCalculatorTest
{
	private IntegerCalculator calc;
	
	@Before
	public void setup()
	{
		calc = new IntegerCalculator();
	}
	
	
	@Test
	public void testAddSmallIntegers()
	{
		int a = 7;
		int b = 11;
		
		int result = calc.add(a, b);
		Assert.assertEquals(7+11, result);
	}

	
	@Test(expected=ArithmeticException.class)
	public void testAddLargeInteger()
	{
		int a = Integer.MAX_VALUE;
		int b = 1;
		
		calc.add(a, b);
	}
	
	
	@Test(expected=ArithmeticException.class)
	public void testAddLargeLong()
	{
		long a = Long.MAX_VALUE;
		long b = 1L;
		
		calc.add(a, b);
	}
}
