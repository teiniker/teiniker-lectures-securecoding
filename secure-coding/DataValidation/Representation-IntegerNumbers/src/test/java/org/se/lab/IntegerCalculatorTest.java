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
	public void testAdd()
	{
		int a = Integer.MAX_VALUE;
		int b = 1;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		int result = calc.add(a, b);
		System.out.println("result = " + result);
//		assertTrue(result > 0);	
		Assert.assertEquals(Integer.MIN_VALUE, result);
	}

	
	@Test(expected=ArithmeticException.class)
	public void testAddInteger()
	{
		int a = Integer.MAX_VALUE;
		int b = 1;
		
		calc.addInteger(a, b);		
	}
	
	
	@Test(expected=ArithmeticException.class)
	public void testAddLong()
	{
		long a = Long.MAX_VALUE;
		long b = 1L;
		
		calc.addLong(a, b);	
	}
}
