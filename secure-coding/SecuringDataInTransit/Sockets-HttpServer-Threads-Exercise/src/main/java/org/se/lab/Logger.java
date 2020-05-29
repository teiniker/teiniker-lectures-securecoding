package org.se.lab;

import java.util.Date;

public class Logger 
{

	private Logger() {}
	
	private static String timeStamp()
	{
		Date now = new Date();
		return now.toString();
	}

	
	public static void log(String msg)
	{		
		System.out.println("[" + timeStamp() + "] " + msg);
	}
}
