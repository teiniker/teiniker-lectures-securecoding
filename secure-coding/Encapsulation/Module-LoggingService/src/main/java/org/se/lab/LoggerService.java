package org.se.lab;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggerService
{
	private final static Logger LOG = Logger.getGlobal();
	
	public void info(String msg)
	{
		LogRecord line = new LogRecord(Level.INFO, msg);
		LOG.log(line);		
	}

	public void warning(String msg)
	{
		LogRecord line = new LogRecord(Level.WARNING, msg);
		LOG.log(line);		
	}

	// ...
}
