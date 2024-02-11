package org.se.lab;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpClientTest
{
	@Test
	public void testGetRequest() throws UnknownHostException, IOException
	{
		Socket socket = new Socket("localhost", 8080);

		// send request
		PrintWriter out = new PrintWriter(socket.getOutputStream());		
		out.println("GET /index.html HTTP/1.1");
		out.println("Host: localhost:8080");
		out.println();
		out.flush();
		
		// read response
		InputStream in = socket.getInputStream();
		StringBuilder buffer = new StringBuilder();
		int c;
		while((c=in.read()) != -1)
		{
			buffer.append((char)c);
		}
		
		in.close();
		out.close();
		socket.close();

		System.out.println(buffer.toString());
	}
}
