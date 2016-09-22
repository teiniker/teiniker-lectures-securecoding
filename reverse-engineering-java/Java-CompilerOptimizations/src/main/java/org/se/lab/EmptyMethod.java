package org.se.lab;

public class EmptyMethod
{
	public void emptyMethod() {}
	
	
	public static void main(String... args)
	{
		EmptyMethod obj = new EmptyMethod();
		
		int i=0;
		while(i < 100000)
		{
			obj.emptyMethod();
			i++;
		}
		
	}
}
