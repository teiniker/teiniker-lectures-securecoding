package org.se.lab;


public class Main
{

	public static void main(String... args)
	{
		ConsoleLogin login = new ConsoleLogin();
		do
		{
			login.readFromConsole();
		}
		while(!login.isValid());
		System.out.println("Welcome!");
	}
}
