package org.se.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleLogin
{
	
	/*
	 * Property: username
	 */
	private String username;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	
	/*
	 * Property: password
	 */	
	private String password;
	private String getPassword()
	{
		return password;
	}
	private void setPassword(String password)
	{
		this.password = password;
	}


	/*
	 * Operations
	 */
	
	public void readFromConsole()
	{		
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

			System.out.print("username > "); 
			setUsername(br.readLine());

			System.out.print("password > "); 
			setPassword(br.readLine());
		} 
		catch (IOException e)
		{
			throw new IllegalStateException(e);
		}
	}
	
	
	public boolean isValid()
	{
		if(getUsername().equals("homer") && getPassword().equals("superhomer"))
			return true;
		else
			return false;				
	}
}
