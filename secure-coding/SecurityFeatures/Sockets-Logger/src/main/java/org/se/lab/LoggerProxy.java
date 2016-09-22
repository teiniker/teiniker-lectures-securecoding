package org.se.lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;

public class LoggerProxy
	implements Logger
{
	public void log(Level level, String text)
	{
		Date now = new Date();
		LogMessage msg = new LogMessage(now.getTime(), level, text);
		try
		{
			Socket socket = new Socket("localhost", 8010);
			
			Writer out = new PrintWriter(socket.getOutputStream());	
			out.write(msg.toString());
			out.flush();
			
			socket.close();
		} 
		catch (IOException e)
		{
			throw new IllegalStateException("Cant write log message!", e);
		}
	}

}
