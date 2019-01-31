package org.se.lab;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class SSLDaytimeServer
{
	public static void main(String[] arstring)
	{
		SSLServerSocket server = null;
		try
		{
			server = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(9013);
			System.out.println("Starting server.." + server);

			SSLSocket connection = null;
			while(true)
			{
				try
				{
					connection = (SSLSocket) server.accept();
					SSLSession sslSession = connection.getSession();
					String cipherSuite = sslSession.getCipherSuite();
					System.out.println(cipherSuite);

					Writer out = new OutputStreamWriter(connection.getOutputStream());
					Date now = new Date();
					out.write(now.toString() + "\r\n");
					out.flush();
					connection.close();
				}
				catch (IOException e)
				{
					throw new IllegalStateException("Can't establish a secure socket connection!", e);
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
			throw new IllegalStateException("Can't create a secure socket!", e);
		}
		finally
		{
			if(server != null)
			{
				try
				{
					server.close();
				} catch (IOException e)
				{
					throw new IllegalStateException("Can't close the secure socket!", e);
				}
			}
		}
	}
}
