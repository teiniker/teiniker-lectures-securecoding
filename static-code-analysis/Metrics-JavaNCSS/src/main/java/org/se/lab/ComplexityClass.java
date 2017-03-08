package org.se.lab;

/*
 * McCabe Cyclomatic Complexity
 * 
 * Counts the number of flows through a piece of code. 
 * Each time a branch occurs (if, for, while, do, case, 
 * catch and the ?: ternary operator, as well as the 
 * && and || conditional logic operators in expressions) 
 * this metric is incremented by one. 
 */

public class ComplexityClass
{
    // C = 2
	public boolean isEvenNumber(int n)
	{
		boolean isEven;
		if((n % 2) == 0)
		{
			isEven = true;
		}
		else
		{
			isEven = false;
		}
		return isEven;
	}
	
	
	// C = 3
	public int compare(int i, int j)
	{
		int result;
		if(i == j)	
		{
			result = 0;
		}
		else if(i > j) 
		{
			result = 1;
		}
		else 
		{
			result = -1;
		}
			
		return result; 
	}
	
	// C = 9
	public String convertNumberToDay(int i)
	{
		String result;
		switch(i)
		{
			case 1:  result = "Montag";      break;
			case 2:  result = "Dienstag";    break;
			case 3:  result = "Mittwoch";    break;
			case 4:  result = "Donnerstag";  break;
			case 5:  result = "Freitag";     break;
			case 6:  result = "Samstag";     break;
			case 7:  result = "Sonntag";     break;
			default: throw new IllegalArgumentException("Invalid day code!");
		}
		return result;
	}
	
	// C = 3
	public boolean isValidString(String s)
	{
		boolean result;
		
		if(s == null || s.trim().length() == 0)
		{
			result = false;
		}
		else
		{
			result = true;
		}
		return result;
	}
	
	
	// C = 2
	public int sumIntegers1(int... is)
	{
		int result = 0;
		for(int i = 0; i < is.length; i++ )
		{
			result += is[i];
		}
		return result;
	}
	
	// C = 2
	public int sumIntegers2(int... is)
	{
		int result = 0;
		int i = 0;
		while(i < is.length)
		{
			result += is[i++];
		}
		return result;
	}
	
	
	// C = 2
	public int sumIntegers3(int... is)
	{
		int result = 0;
		int i=0;
		do 
		{
			result += i;
		}
		while(i < is.length); 
		return result;
	}
	
}
