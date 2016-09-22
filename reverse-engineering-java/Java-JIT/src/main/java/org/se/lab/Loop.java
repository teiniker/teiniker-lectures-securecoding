package org.se.lab;

public class Loop 
{

	public static void main(String... args)
	{
		String s = "";
		
		for(int i = 0; i < 1000000; i++)
		{
			s = add(s,i);
		}
		
		System.out.println(s);
	}
	
	
	public static String add(String s, int i)
	{
		return s + i + ' ';
	}
}
