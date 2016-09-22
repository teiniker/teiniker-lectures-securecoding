package org.se.lab;

import java.math.BigInteger;

/*
 * Arithmetic operations in the Java platform require just as much 
 * caution as C and C++ do because integer operations can result 
 * in overflow.
 * 
 * Java does not provide any indication of overflow conditions and 
 * silently wraps. Wrapped values typically result in incorrect 
 * computations and unanticipated outcomes.
 * 
 * The integral types in Java are byte, short, int, and long, whose 
 * values are 8-bit, 16-bit, 32-bit and 64-bit signed 
 * two's-complement integers, respectively, and char, whose values 
 * are 16-bit unsigned integers representing UTF-16 code units.
 */

public class IntegerCalculator
{

	/*
	 * Noncompliant solution.
	 */
	public int add(int a, int b)
	{
		return a + b;
	}

	
	/*
	 * Operations on values of type int can be safely performed using type long.
	 * We can perform an operation using the larger type and range-check before
	 * downcasting to the original type. Note, however, that this guarantee
	 * holds only for a one arithmetic operation;
	 */
	public int addInteger(int a, int b)
	{
		long result = (long) a + (long) b;
		
		return intRangeCheck(result);
	}

	
	/*
	 * Type BigInteger is the standard arbitrary-precision integer type provided 
	 * by the Java standard libraries. The arithmetic operations implemented as 
	 * methods of this type cannot themselves overflow; instead, they produce the 
	 * numerically correct result.
	 * 
	 * As a consequence, compliant code performs only a single range check�just 
	 * before converting the final result to the original smaller type.
	 * 
	 * Note that operations on objects of type BigInteger can be significantly 
	 * less efficient than operations on the original primitive integer type.  
	 */
	public long addLong(long a, long b)
	{
		BigInteger bigA = BigInteger.valueOf(a);
		BigInteger bigB = BigInteger.valueOf(b);

		BigInteger bigResult = bigA.add(bigB);
		
		return longRangeCheck(bigResult);
	}

	
	/*
	 * Utility methods
	 */

	protected int intRangeCheck(long value) 
		throws ArithmeticException
	{
		if ((value < Integer.MIN_VALUE) || (value > Integer.MAX_VALUE))
		{
			throw new ArithmeticException("Integer overflow");
		}
		return (int) value;
	}

	
	public long longRangeCheck(BigInteger value) 
		throws ArithmeticException
	{
		// Note: These constants should be defined as static class members
		final BigInteger bigMaxLong = BigInteger.valueOf(Long.MAX_VALUE);
		final BigInteger bigMinLong = BigInteger.valueOf(Long.MIN_VALUE);

		if (value.compareTo(bigMaxLong) == 1 || value.compareTo(bigMinLong) == -1)
		{
			throw new ArithmeticException("Integer overflow");
		}
		return value.longValue();
	}
}
