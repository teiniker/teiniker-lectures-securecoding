package org.se.lab;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;


public class Log4jTest
{
	/*
	 * The default configuration file is called log4j.properties
	 * and can be found on the CLASSPATH
	 */
	@Test
	public void testLoggerWithDefaultConfiguratonFile()
	{
		Logger logger = Logger.getLogger(Log4jTest.class);
		callLoggerMethods(logger);
	}

	
	/*
	 * Load configurations from a properties file stored in  
	 * the file system.
	 */
	@Test
	public void testLoggerWithPropertyConfigurator()
	{
		Logger logger = Logger.getLogger(Log4jTest.class);
		PropertyConfigurator.configure("log4j-example.properties");
		callLoggerMethods(logger);
	}


	// Log levels: trace > debug > info > warning > error > fatal
	protected void callLoggerMethods(Logger logger)
	{
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");		
		logger.debug("debug with exception", new IllegalArgumentException());				
	}
}
