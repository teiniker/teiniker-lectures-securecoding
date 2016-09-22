package org.se.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FinallyTest
{

	private String readFirstLine(String path) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(path));
		try
		{
			return br.readLine();
		}
		finally
		{
			// Ensure that BufferedReader will be closed (also in the
			// case of an exception).
			if (br != null)
				br.close();
		}
	}

	@Test
	public void testReadFirstLineFinally() throws IOException
	{

		String line = readFirstLine("README.txt");

		Assert.assertEquals("The try-with-resources Statement", line);
	}
}
