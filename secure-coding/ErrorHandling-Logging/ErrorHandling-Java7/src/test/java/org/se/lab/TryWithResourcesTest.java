package org.se.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/*
 * The try-with-resources statement is a try statement that declares one or 
 * more resources. A resource is an object that must be closed after the 
 * program is finished with it. 
 * 
 * The try-with-resources statement ensures that each resource is closed at 
 * the end of the statement. 
 * 
 * Any object that implements java.lang.AutoCloseable, which includes all 
 * objects which implement java.io.Closeable, can be used as a resource.
 */

public class TryWithResourcesTest
{
	private String readFirstLine(String path) 
		throws IOException
	{
		// The class BufferedReader, in Java SE 7 and later, implements 
		// the interface java.lang.AutoCloseable. 
		// Because the BufferedReader instance is declared in a 
		// try-with-resource statement, it will be closed regardless of 
		// whether the try statement completes normally or abruptly.
		
		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			return br.readLine();
		}
	}
	
	
	@Test
	public void testReadFirstLineFinally() throws IOException
	{

		String line = readFirstLine("README.txt");

		Assert.assertEquals("The try-with-resources Statement", line);
	}
}
