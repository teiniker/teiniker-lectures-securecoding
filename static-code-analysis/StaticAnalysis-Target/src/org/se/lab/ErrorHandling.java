package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ErrorHandling
{

	public void ignoreReturnValue(String directoryName)
	{
		File dir = new File(directoryName);
		dir.mkdir();
	}

	
	public void ignoreException()
	{
		FileInputStream fis = null;

		try
		{
			fis = new FileInputStream("build.xml");
			fis.close();
		} 
		catch (IOException e)
		{
			// do nothing
		}
	}


	public void cutExceptionStackTrace()
	{
		FileInputStream fis = null;

		try
		{
			fis = new FileInputStream("build.xml");
			fis.close();
		} 
		catch (IOException e)
		{
			throw new IllegalStateException("Some bad things happened!");
		}
	}

}
