package org.se.lab;

public class Main 
{

	public static void main(String... args)
	{
		LoggerService service = new LoggerService();
		
		service.info("Info text");
		service.info("Warning text");
	}
}
