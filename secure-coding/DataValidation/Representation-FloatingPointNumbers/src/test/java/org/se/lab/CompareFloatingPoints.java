package org.se.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CompareFloatingPoints
{

	@Test
	public void testAbsoluteDelta()
	{
		double expected = Math.PI; 
		double value = 3.141592; 		
		double delta = 1E-6; // 1E-7 fails
		
		System.out.printf("%.50f\n", expected);
		System.out.printf("%.50f\n", value);
		System.out.printf("%.50f\n", delta);
		System.out.printf("%.50f\n", Math.abs(expected - value));
		
		boolean result = Math.abs(expected - value) <= delta;
		assertTrue(result);
	}
	
	
	@Test
	public void testRelativeDelta1()
	{
		double expected = Math.PI; 
		double value = 3.14; 
		double delta = 1E-3; // 1E-4 would fail 

		System.out.printf("%.50f\n", expected);
		System.out.printf("%.50f\n", value);
		System.out.printf("%.50f\n", delta);
		System.out.printf("%.50f\n", Math.abs(expected - value)/expected);
			
		boolean result = Math.abs(expected-value)/expected <= delta;
		assertTrue(result);
	}
	
	@Test
	public void testRelativeDelta2()
	{
		double expected = Math.PI*1E6; 
		double value = 3.14*1E6; 
		double delta = 1E-3; // 1E-3 would fail 

		System.out.printf("%.50f\n", expected);
		System.out.printf("%.50f\n", value);
		System.out.printf("%.50f\n", delta);
		System.out.printf("%.50f\n", Math.abs(expected - value)/expected);
			
		boolean result = Math.abs(expected-value)/expected <= delta;
		assertTrue(result);
	}
	
	
	@Test
	public void testAssertEquals()
	{
		double expected = Math.PI; 
		double value = 3.141592; 		
		double delta = 1E-6; // 1E-7 fails

		// TODO: look at the implementation source code
		assertEquals(expected, value, delta);

	}
	
// org.junit.Assert:	
//		static public void assertEquals(String message, double expected,
//				double actual, double delta) {
//			if (Double.compare(expected, actual) == 0)
//				return;
//			if (!(Math.abs(expected - actual) <= delta))
//				failNotEquals(message, new Double(expected), new Double(actual));
//		}	
}
