package org.se.lab.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerServer
{
	private final static File LOG_FILE = new File("./log/server.log");
	private final static Format FORMATTER = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	
	public static void main(String... ags)
	{
		System.out.println("Starting server..");
		writeToFile("[" + FORMATTER.format(new Date()) + "]" + " Logging server started...");

		try(ServerSocket server = new ServerSocket(8080))
		{
			while (true)
			{
				Socket connection = server.accept(); // wait for a connection
				try
				{
					InputStream in = connection.getInputStream();
					StringBuilder buffer = new StringBuilder();
					buffer.append("[").append(FORMATTER.format(new Date())).append("]");
					buffer.append(" from ").append(connection.getInetAddress()).append(":");
					buffer.append(connection.getPort()).append(" | ");
					
					int c;
					while((c=in.read()) != -1)
					{
						buffer.append((char)c);
					}
					in.close();
					
					System.out.println(buffer.toString());
					writeToFile(buffer.toString());
				} 
				catch (IOException e)
				{
					throw new IllegalStateException("Can't establish a socket connection!", e);
				} 
				finally
				{
					if(connection != null)
						connection.close();
				}
			}
		} 
		catch (IOException e)
		{
			throw new IllegalStateException("Can't create a socket!", e);
		}
	}

	
	public static void writeToFile(String msg)
	{
		try
		{
			Writer w = new FileWriter(LOG_FILE, true);
			w.write(msg.toString() + "\n");
			w.close();
		} 
		catch (IOException e)
		{
			throw new IllegalStateException("Can't write message to the log file", e);
		}
	}
}
