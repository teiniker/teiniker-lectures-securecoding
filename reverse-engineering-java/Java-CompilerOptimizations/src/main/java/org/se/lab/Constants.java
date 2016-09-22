package org.se.lab;

public class Constants
{
	public int doConstantFolding()
	{
		final int VERSION = 10 + 25 + 15;		
		return VERSION;
	}

	public int doConstantPropagation()
	{
		final int A = 111;
		final int B = 222;

		int c = A+B;
		return c + A; 
	}

	public int doSomething(int a, int b)
	{
		int c = a+b;
		return c + a; 
	}

}
