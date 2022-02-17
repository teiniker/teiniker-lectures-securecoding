package org.se.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FinallyTest
{

	private String readFirstLine(String path)
	{
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(path));
			return br.readLine();
		}
		catch(IOException e)
		{
			throw new IllegalStateException("Can't read from " + path, e);
		}
		finally
		{
			// Ensure that BufferedReader will be closed (also in the
			// case of an exception).
			try
			{
				if (br != null)
					br.close();
			}
			catch(IOException e)
			{
				// Log that event;
			}
		}
	}

	@Test
	public void testReadFirstLineFinally() throws IOException
	{

		String line = readFirstLine("README.txt");

		Assert.assertEquals("The try-with-resources Statement", line);
	}
}
