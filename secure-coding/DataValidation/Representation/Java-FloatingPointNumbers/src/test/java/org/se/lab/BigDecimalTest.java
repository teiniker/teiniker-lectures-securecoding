package org.se.lab;

import java.math.BigDecimal;

import org.junit.Test;


public class BigDecimalTest
{

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