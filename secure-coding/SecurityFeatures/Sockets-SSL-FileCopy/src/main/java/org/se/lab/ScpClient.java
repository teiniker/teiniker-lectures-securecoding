package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class ScpClient
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		if(args.length < 3)
		{
			System.out.println("usage: java -cp ./build org.se.lab.ScpClient <filename> <host> <port>");
			System.exit(0);
		}

		final String INPUT_FILE_NAME = args[0];
		final String HOST = args[1];
		final int PORT = Integer.parseInt(args[2]);
		
		SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket(HOST, PORT);
		
		InputStream in = new FileInputStream(new File(INPUT_FILE_NAME));
		OutputStream out = socket.getOutputStream();	

		int b;
		while((b=in.read()) != -1)
		{
			out.write(b);
		}
		in.close();
		out.flush();
		
		socket.close();
	}
}
