package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ByteArrayTest
{
	private static final byte[] bytes = new byte[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

	@Test
	public void testToString()
	{
		String s = Arrays.toString(bytes);
		String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]";
		Assert.assertEquals(expected, s);
	}

	@Test
	public void testEquals()
	{
		byte[] expected = new byte[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Assert.assertTrue(Arrays.equals(expected, bytes));
	}

	@Test
	public void testFill()
	{
		byte[] array = new byte[16];
		Arrays.fill(array, (byte)0xf);

		String expected = "[15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15]";
		Assert.assertEquals(expected, Arrays.toString(array));
	}

	@Test
	public void testFillRange()
	{
		byte[] array = new byte[16];
		Arrays.fill(array, 5, 12, (byte)0xf);

		String expected = "[0, 0, 0, 0, 0, 15, 15, 15, 15, 15, 15, 15, 0, 0, 0, 0]";
		Assert.assertEquals(expected, Arrays.toString(array));
	}

	@Test
	public void testCopyOf()
	{
		byte[] result = Arrays.copyOf(bytes, bytes.length+8);

		String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0]";
		Assert.assertEquals(expected, Arrays.toString(result));
	}

	@Test
	public void testCopyOfRange()
	{
		byte[] result = Arrays.copyOfRange(bytes, 10, bytes.length);

		String expected = "[10, 11, 12, 13, 14, 15]";
		Assert.assertEquals(expected, Arrays.toString(result));
	}

	@Test
	public void testArraycopy()
	{
		int len = bytes.length;
		byte[] result = new byte[len+len];

		System.arraycopy(bytes, 0, result, 0, len);
		System.arraycopy(bytes, 0, result, len, len);

		String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]";
		Assert.assertEquals(expected, Arrays.toString(result));
	}
}
