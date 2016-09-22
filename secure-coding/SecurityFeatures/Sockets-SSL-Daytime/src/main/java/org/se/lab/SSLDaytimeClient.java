package org.se.lab;

import java.io.InputStream;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLDaytimeClient
{
	public static void main(String... args)
	{
		try
		{
			SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket("localhost", 9013);
			
			InputStream in = socket.getInputStream();
			StringBuilder buffer = new StringBuilder();
			int c;
			while((c=in.read()) != -1)
				buffer.append((char)c);
			
			System.out.println("It is : " + buffer);
			socket.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
