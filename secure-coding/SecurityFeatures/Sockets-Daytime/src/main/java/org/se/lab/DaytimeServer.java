package org.se.lab;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


/*
 * RFC 867 daytime service
 * 
 * A daytime service simply sends a the current date and time as a character 
 * string without regard to the input.
 * 
 * One daytime service is defined as a connection based application on TCP.  
 * A server listens for TCP connections on TCP port 13.  
 * Once a connection is established the current date and time is sent out the 
 * connection as a ascii character string (and any data received is thrown 
 * away).  
 * The service closes the connection after sending the quote.
 * There is no specific syntax for the daytime.
 */

public class DaytimeServer
{

	public static void main(String... args)
	{
		System.out.print("Starting server..");

		ServerSocket server = null;
		try
		{
			server = new ServerSocket(9013);
			Socket connection = null;
			System.out.println("..done");
			while (true)
			{
				try
				{
					connection = server.accept(); // wait for a connection
					System.out.println(connection);
					
					Writer out = new OutputStreamWriter(connection.getOutputStream());
					Date now = new Date();
					out.write(now.toString() + "\r\n");
					out.flush();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
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
			e.printStackTrace();
		}
		finally
		{
			if(server != null)
				try
				{
					server.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		}
	}
}
