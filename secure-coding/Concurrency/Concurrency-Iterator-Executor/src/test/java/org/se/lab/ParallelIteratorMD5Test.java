package org.se.lab;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ParallelIteratorMD5Test
{
	private final List<String> data = Arrays.asList("eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben");

	final String EXPECTED = 
			"[4c0d5d15a964bc702120b031e7bb0c48, " +
			"15d55d085e6eda9586293acad7c0a4f4, " +
			"1d8d2fd0a99802b89eb356a86e029d25, " +
			"37ab88fde80a4db0c7aa7c65013a5f08, " +
			"1ecfdb80366524ebc70e31c46a875cc9, " +
			"60dbf8b16f87b0f5e76ab562417b8011, " +
			"d4e998992c5d77930be0dd0199008e4a]";
	
	@Test
	public void testMD5EncoderWithExecutor()
	{
		ParallelIteratorWithExecutor.execute(data, AlgorithmMD5Encoder.class, 3);

		Assert.assertEquals(EXPECTED, data.toString());
	}
}
