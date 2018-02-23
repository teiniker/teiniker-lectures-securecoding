package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/*
 * A beneficial consequence of structuring computations as functional transformations
 * is that you can easily switch between sequential and parallel execution with minimal
 * changes to the code.
 * The sequential expression of a stream computation and the parallel expression of the
 * same computation are almost identical.
 */
public class ParallelStreamTest
{
	private List<String> list;

	@Before
	public void setUp()
	{
		list = Arrays.asList("eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun");
	}

	@Test
	public void testMapParallel()
	{
        List<String> l = list
						.parallelStream()
						.map((s) -> s.toUpperCase())
						.collect(Collectors.toList());

		Assert.assertEquals("[EINS, ZWEI, DREI, VIER, FÜNF, SECHS, SIEBEN, ACHT, NEUN]", l.toString());
	}

	@Test
	public void testFilterParallel()
	{
		long count = list.parallelStream().filter((s) -> s.length() > 4).count();

		Assert.assertEquals(2, count);
	}

}
