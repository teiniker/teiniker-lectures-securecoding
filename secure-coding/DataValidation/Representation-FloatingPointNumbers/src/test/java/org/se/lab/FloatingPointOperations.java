package org.se.lab;

import org.junit.Test;
import static java.lang.System.out;

public class FloatingPointOperations
{
	/*
	 * In this noncompliant code example, the division operations 
	 * take place on integers and the result gets converted to 
	 * floating-point.
	 */
	@Test
	public void testFPOperationsWithIntegers()
	{
		int i = 6789;
		double d = i / 100;
		
		out.println(d);
	}
	
	
	/*
	 * This compliant solution eliminates the decimal error in 
	 * initialization by ensuring that, at least, one of the 
	 * operands to the division operation is of the floating-point 
	 * type.
	 */
	@Test
	public void testFPOperationsWithFPLiteral()
	{
		int i = 6789;
		double d = i / 100.0;
		
		out.println(d);
	}	
	
	
	/*
	 * This compliant solution eliminates the initialization errors by 
	 * storing the integers in the floating-point variables, then 
	 * performing the arithmetic operations. 
	 * This ensures that, at least, one of the operands is a floating-
	 * point number, and, consequently, the operation is performed on 
	 * floating-point numbers.
	 */
	@Test
	public void testFPOperationsWithFPVariables()
	{
		int i = 6789;
		double di = i;
		double d = di / 100;
		
		out.println(d);
	}		
}
