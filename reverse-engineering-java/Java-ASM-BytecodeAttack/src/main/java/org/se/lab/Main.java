package org.se.lab;

public class Main
{
	public static void main(String... args)
	{
		if(args.length != 1)
		{
			System.out.println("Usage: org.se.lab.Main <password>");
			System.exit(0);
		}
		
		Password passwd = new Password(args[0]);
		
		System.out.println(passwd);
	}
}
