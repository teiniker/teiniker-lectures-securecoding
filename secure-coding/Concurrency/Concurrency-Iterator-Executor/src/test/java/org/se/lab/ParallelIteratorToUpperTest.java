package org.se.lab;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ParallelIteratorToUpperTest
{
	private final List<String> data = Arrays.asList("eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben");
	private final String EXPECTED = "[EINS, ZWEI, DREI, VIER, FÜNF, SECHS, SIEBEN]";

	
	@Test
	public void testWithExecutor()
	{
		ParallelIteratorWithExecutor.execute(data, AlgorithmToUpper.class, 3);

		Assert.assertEquals(EXPECTED, data.toString());
	}
}
