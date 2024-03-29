package org.se.lab;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class SSLDaytimeServer
{
	public static void main(String[] arstring)
	{
		try(SSLServerSocket server = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(9013))
		{
			System.out.println("Starting server.." + server);

			while(true)
			{
				try(SSLSocket connection = (SSLSocket) server.accept())
				{
					SSLSession sslSession = connection.getSession();
					connection.setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.3"});
					String cipherSuite = sslSession.getCipherSuite();
					System.out.println(cipherSuite);
					//System.out.println(Arrays.toString(connection.getEnabledCipherSuites()));
					//System.out.println(Arrays.toString(connection.getEnabledProtocols()));
					//System.out.println(connection.getApplicationProtocol());

					Writer out = new OutputStreamWriter(connection.getOutputStream());
					Date now = new Date();
					out.write(now.toString() + "\r\n");
					out.flush();
				}
				catch (IOException e)
				{
					throw new IllegalStateException("Can't establish a secure socket connection!", e);
				} 
			}
		} 
		catch (IOException e)
		{
			throw new IllegalStateException("Can't create a secure socket!", e);
		}
	}
}
