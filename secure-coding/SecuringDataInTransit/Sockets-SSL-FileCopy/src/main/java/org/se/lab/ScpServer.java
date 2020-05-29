package org.se.lab;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class ScpServer
{	
	public static void main(String... args)
	{
		if(args.length < 2)
		{
			System.out.println("usage: java -cp ./build org.se.lab.ScpServer <port> <filename>");
			System.exit(0);
		}
		
		final int PORT = Integer.parseInt(args[0]);
		final String OUTPUT_FILE_NAME = args[1];
		
		System.out.println("> read from port " + PORT + " and write to file " + OUTPUT_FILE_NAME);
		
		try(SSLServerSocket server = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(PORT))
		{
			try(SSLSocket connection = (SSLSocket) server.accept())
			{
				System.out.println("> " + connection);
				InputStream in = connection.getInputStream();
				OutputStream out = new FileOutputStream(new File(OUTPUT_FILE_NAME)); 
				
				int c;
				while((c=in.read()) != -1)
				{
					out.write(c);
				}

				in.close();
				out.close();					
			} 
			catch (IOException e)
			{
				throw new IllegalStateException("Can't establish a secure socket connection!", e);
			} 
		}
		catch (IOException e)
		{
			throw new IllegalStateException("Can't create a secure socket!", e);
		}
	}
}
