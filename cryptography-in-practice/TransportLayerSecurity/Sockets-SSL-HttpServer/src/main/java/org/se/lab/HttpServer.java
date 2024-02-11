package org.se.lab;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class HttpServer
{
	private final static String WEB_DIR = "./src/main/webapp";
	private final static int SERVER_PORT = 8443;

	public static void main(String... ags)
	{
		try(SSLServerSocket server = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(SERVER_PORT))
		{
			Logger.log("Server started...");

			while (true)
			{
				try(SSLSocket connection = (SSLSocket) server.accept())
				{
					Logger.log(connection.toString());
					SSLSession sslSession = connection.getSession();
					connection.setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.3"});
					System.out.println(sslSession.getCipherSuite());

					HttpRequestHandler handler = new HttpRequestHandler(WEB_DIR);
					handler.handleRequest(connection.getInputStream(), connection.getOutputStream());

				}
				catch (IOException e)
				{
					throw new IllegalStateException("Can't establish a secure socket connection!", e);
				}
			}
		} 
		catch(IOException e)
		{
			throw new IllegalStateException("Can't handle connection!", e);
		}
    }
}