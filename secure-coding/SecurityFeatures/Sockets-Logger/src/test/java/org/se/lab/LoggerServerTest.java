package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoggerServerTest
{
	protected Logger logger;
	protected String LOG_FILE;

	@Before
	public void setup()
	{
		LOG_FILE = "./log/server.log";
		logger = new LoggerProxy();
	}
	
	@Test
	public void testLogger() throws InterruptedException
	{
		TextFileUtil txtBefore = new TextFileUtil(LOG_FILE);
		int sizeBefore = txtBefore.numberOfLines();
		System.out.println(sizeBefore);
		logger.log(Level.DEBUG, "This is a debug message.");
		logger.log(Level.INFO, "This is an info message.");
		logger.log(Level.WARNING, "This is a warning message.");
		logger.log(Level.ERROR, "This is error message.");
		
		Thread.sleep(500); // let the server work
		TextFileUtil txtAfter = new TextFileUtil(LOG_FILE);
		int sizeAfter = txtAfter.numberOfLines();
		System.out.println(sizeAfter);
		Assert.assertEquals(4, sizeAfter - sizeBefore);
	}
}
