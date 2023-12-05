package org.se.lab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


public class Log4jTest
{
	Logger logger;

	@Before
	public void setup()
	{
		logger = LogManager.getLogger(Log4jTest.class);
	}

	@Test
	public void testLogLevels()
	{
		// Log levels: trace > debug > info > warning > error > fatal
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
		logger.debug("debug with exception", new IllegalArgumentException());
	}

	@Test
	public void testPlaceHolders()
	{
		String user = "homer";
		int numberOfDuff = 7;
		// TODO: validate user input bevor you put it into a log message!
		// e.g. "homer says:\nyou"
		logger.info("Today, {} had {} beers!", user, numberOfDuff);
	}
}
