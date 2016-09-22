package org.se.lab;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

public class EncodingTask
	implements Runnable
{
	public EncodingTask(String inputFile, String outputFile)
	{
		if(inputFile == null || outputFile == null)
			throw new IllegalArgumentException();
		
		binaryFile = new File(inputFile);
		base64File = new File(outputFile);
	}
	
	
	private File binaryFile;  
	private File base64File;
	
	@Override
	public void run()
	{
		// Read binary file
		long size = binaryFile.length();
		byte[] binaryData = new byte[(int) size];
		BufferedInputStream input = null;
		try
		{
			input = new BufferedInputStream(new FileInputStream(binaryFile));
			input.read(binaryData);
		}
		catch(IOException e)
		{
			throw new IllegalStateException(e);
		}
		finally
		{
			try
			{
				if(input != null)
					input.close();
			}
			catch (IOException e)
			{
				throw new IllegalStateException(e);
			}
		}
		
		// Encode binary data 
		String base64String = Base64.encodeBase64String(binaryData);

		// Write base64 string
		BufferedWriter writer =	null;
		try
		{
			writer = new BufferedWriter(new FileWriter(base64File));
			writer.write (base64String);
		}
		catch (IOException e)
		{
			throw new IllegalStateException(e);
		}
		finally
		{
			try
			{
				if(writer != null)
				writer.close();
			}
			catch (IOException e)
			{
				throw new IllegalStateException(e);
			}	
		}
	}
}
