package org.se.lab;

import java.math.BigDecimal;

import org.junit.Test;


public class PreciseComputationTest
{
	/*
	 * Avoid using the primitive floating point types when precise 
	 * computation is necessary, especially when performing currency 
	 * calculations.
	 * 
	 * Because these types use a binary mantissa, they cannot precisely 
	 * represent many finite decimal numbers, such as 1/10, because these 
	 * numbers have repeating binary representations.
	 * 
	 */
	@Test
	public void testPreciseComputationUsingDouble()
	{
		double tenCent = 0.1;
		double sum = 0.0;
		for(int i = 0; i< 100; i++)
		{
			sum += tenCent;
		}
		System.out.printf("%.50f\n",sum);
	}

	
	/*
	 * This compliant solution uses an integer type (such as long). 
	 */
	@Test
	public void testPreciseComputationUsingLong()
	{
		long tenCent = 10;
		long sum = 0;
		for(int i = 0; i< 100; i++)
		{
			sum += tenCent;
		}
		System.out.printf("%.50f\n",sum/100.0);
	}


	/*
	 * An alternative approach is to use the BigDecimal type, 
	 * but it is less efficient.
	 */
	@Test
	public void testPreciseComputationUsingBigDecimal()
	{
		BigDecimal tenCent = new BigDecimal("0.1");
		BigDecimal sum = new BigDecimal("0.0"); 
		for(int i = 0; i< 100; i++)
		{
			sum = sum.add(tenCent);
		}
		System.out.printf("%.50f\n",sum);
	}
	
	
	/*
	 * Avoid using floating point literals with the BigDecimal constructor.
	 * 
	 * The primitive type double cannot precisely represent all decimal 
	 * fractions because its underlying representation is binary. 
	 * Consequently, the input to the BigDecimal(double val) constructor 
	 * can lose precision before the constructor is ever invoked.
	 */
	@Test
	public void testBigDecimalConstructor()
	{
		// This noncompliant code example passes a double value to the 
		// BigDecimal constructor. Because of this, precision of the 
		// literal is affected.
		BigDecimal big1 = new BigDecimal(0.1);
		System.out.printf("%.50f\n",big1);

		// This compliant solution passes the decimal literal as a String 
		// so that the BigDecimal(String val) constructor is invoked. 
		BigDecimal big2 = new BigDecimal("0.1");
		System.out.printf("%.50f\n",big2);		
	}
}