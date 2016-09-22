package org.se.lab;

public class StringOperations
{
	private long id;
	private String username;
		
	
	public String toString1()
	{
		return "{" + id + "," + username + "}";
	}

	public String toString2()
	{
		StringBuilder b = new StringBuilder();
		b.append("{");
		b.append(id);
		b.append(",");
		b.append(username);
		b.append("}");		
		return  b.toString();
	}

	public String toString3()
	{
		String s = "";		
		for(int i = 0; i<10; i++)
		{
			s = s + "i = " + i + "\n"; 
		}
		return s;
	}
	
	public String toString4()
	{
		StringBuilder b = new StringBuilder();		
		for(int i = 0; i<10; i++)
		{
			b.append("i = ");
			b.append(i);
			b.append("\n"); 
		}
		return b.toString();
	}
}
