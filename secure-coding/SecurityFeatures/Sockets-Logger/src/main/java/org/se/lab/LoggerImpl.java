package org.se.lab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;


public class LoggerImpl
	implements Logger
{
	private final static File LOG_FILE = new File("./log/client.log");
	
	public void log(Level level, String text)
	{
		Date now = new Date();
		LogMessage msg = new LogMessage(now.getTime(), level, text);
		try
		{
			Writer w = new FileWriter(LOG_FILE, true);
			w.write(msg.toString() + "\n");
			w.close();
		} 
		catch (IOException e)
		{
			throw new IllegalStateException("Cant write log message!", e);
		}
	}
}
