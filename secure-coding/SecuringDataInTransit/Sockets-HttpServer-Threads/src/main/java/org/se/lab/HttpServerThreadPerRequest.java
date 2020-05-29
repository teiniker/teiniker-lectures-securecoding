package org.se.lab;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServerThreadPerRequest
{
	private final static String WEB_DIR = "./src/main/webapp";
	private final static int SERVER_PORT = 8080;

	public static void main(String... ags)
	{
		try(ServerSocket server = new ServerSocket(SERVER_PORT))
		{
			Logger.log("Server started...");
			Logger.log(server.toString());

			while (true)
			{
				final Socket connection = server.accept(); // wait for a connection

				Runnable task = new Runnable()
				{
					public void run()
					{
						try
						{
							HttpRequestHandler handler = new HttpRequestHandler(WEB_DIR);
							handler.handleRequest(connection.getInputStream(), connection.getOutputStream());
							Logger.log("Thread id: " + Thread.currentThread().getId());
						}
						catch(IOException e)
						{
							throw new IllegalStateException("Can't handle request!", e);
						}
					}
				};
				Thread t = new Thread(task);
				t.start();
			}
		} 
		catch(IOException e)
		{
			throw new IllegalStateException("Can't handle connection!", e);
		}
	}
}