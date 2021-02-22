package org.se.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class FileReaderTest
{
	@Test
	public void testReadFileLineByLine() throws IOException
	{
		final String filename = "wordlist.txt";
		
		BufferedReader in = new BufferedReader(new FileReader(filename));
		
		String line;
		while((line = in.readLine()) != null)
		{
			System.out.println(line);
		}
		in.close();
	}
}
