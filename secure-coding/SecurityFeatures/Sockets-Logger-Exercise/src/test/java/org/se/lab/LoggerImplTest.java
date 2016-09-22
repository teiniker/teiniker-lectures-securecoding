package org.se.lab;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoggerImplTest
{
	protected Logger logger;
	protected String LOG_FILE;

	@Before
	public void setup()
	{
		LOG_FILE = "./log/client.log";
		logger = new LoggerImpl();
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		File f = new File(LOG_FILE);
		if(f.exists())
			f.delete();
	}
	

	@Test
	public void testLogger()
	{
		logger.log(Level.DEBUG, "This is a debug message.");
		logger.log(Level.INFO, "This is an info message.");
		logger.log(Level.WARNING, "This is a warning message.");
		logger.log(Level.ERROR, "This is error message.");
		
		TextFileUtil txt = new TextFileUtil(LOG_FILE);
		Assert.assertEquals(4, txt.numberOfLines());
		
		Assert.assertTrue(txt.getLine(0).endsWith("] DEBUG - This is a debug message."));
		Assert.assertTrue(txt.getLine(1).endsWith("] INFO - This is an info message."));
		Assert.assertTrue(txt.getLine(2).endsWith("] WARNING - This is a warning message."));
		Assert.assertTrue(txt.getLine(3).endsWith("] ERROR - This is error message."));
	}
}
