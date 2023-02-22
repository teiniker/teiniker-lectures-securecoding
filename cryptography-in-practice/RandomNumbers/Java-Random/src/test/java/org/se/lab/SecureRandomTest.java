package org.se.lab;

import java.util.Random;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;


/*
 * Using Pseudo Random Number Generators (PRNG) from the Java standard library.
 * See: https://dzone.com/articles/java-mathrandom-examples
 */
public class SecureRandomTest
{
	@Test
	public void testUtilRandomSelfSeed()
	{
		byte[] bytes = new byte[20];

		for (int i = 0; i < 10; i++)
		{
			Random rand = new Random();
			rand.nextBytes(bytes);
			System.out.println(Hex.encodeHexString(bytes));
		}
	}

	/*
	 * Since this is a Pseudo Random Number Generator (PRNG), specifying the
	 * same seed results in the same sequence of random numbers being generated.
	 * If someone else were to obtain the same seed, the same sequence can be
	 * generated again.
	 */
	@Test
	public void testUtilRandomConstSeed()
	{
		byte[] bytes = new byte[20];

		for (int i = 0; i < 10; i++)
		{
			Random rand = new Random(0L);
			rand.nextBytes(bytes);
			System.out.println(Hex.encodeHexString(bytes));
		}
	}

	/*
	 * Math.random() returns a double value in the range [0.0,1.0)
	 * Math.random() creates an instance of Random for the actual generation.
	 */
	@Test
	public void testMathRandom()
	{
		double value;

		for(int i=0; i<10; i++)
		{
			value = Math.random();
			System.out.println(value);
		}
	}
}
