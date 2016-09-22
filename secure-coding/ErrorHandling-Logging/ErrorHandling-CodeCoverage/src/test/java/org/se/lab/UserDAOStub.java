package org.se.lab;


public class UserDAOStub
	implements UserDAO
{
	/*
	 * Manage internal states
	 */

	protected int id;
	
	protected User user;
	
	protected RuntimeException exception;
	
	
	/*
	 * UserDAO methods
	 */
	public void delete(int id)
	{
		if(exception != null)
			throw exception;
		
		this.id = id;
	}

	public User findById(int id)
	{	
		if(exception != null)
			throw exception;
		
		return user;
	}

	public void insert(User user)
	{
		if(exception != null)
			throw exception;
		
		this.user = user;
	}

	public void update(User user)
	{
		if(exception != null)
			throw exception;
		
		this.user = user;
	}
}
