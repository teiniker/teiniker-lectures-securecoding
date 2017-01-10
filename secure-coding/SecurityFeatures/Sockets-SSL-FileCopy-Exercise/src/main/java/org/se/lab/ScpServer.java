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
		
		// TODO
	}
}
