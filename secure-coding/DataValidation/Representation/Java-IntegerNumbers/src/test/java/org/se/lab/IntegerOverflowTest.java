package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegerOverflowTest
{
	@Test
	public void testIntegerOverflow()
	{
		int a = Integer.MAX_VALUE;
		int b = 1;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		int result = a + b;
		System.out.println("result = " + result);
//		assertTrue(result > 0);	
		Assert.assertEquals(Integer.MIN_VALUE, result);
	}
}
