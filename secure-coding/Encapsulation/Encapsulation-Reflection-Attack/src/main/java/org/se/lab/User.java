package org.se.lab;

public class User
{
	/*
	 * Constructors
	 */
	public User(int id, String username, String password)
	{
		setId(id);
		setUsername(username);
		setPassword(password);
	}
	
	protected User()
	{
		this(0, "", "");
	}
	
	
	/*
	 * Property: id
	 */
	private int id;
	public int getId()
	{
		return id;
	}
	private void setId(int id)
	{
		this.id = id;
	}
	
	
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
		if(username==null)
			throw new NullPointerException("username");
		this.username = username;
	}
	
	
	/*
	 * Property: password
	 */
	private String password;
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		if(password==null)
			throw new NullPointerException("password");
		this.password = password;
	}
	
	
	/*
	 * Object methods
	 */
	
	public String toString()
	{
		return getId() + "," + getUsername() + "," + getPassword();
	}
}
