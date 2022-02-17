package org.se.lab;


public class UserDAOStub
	implements UserDAO
{
	/*
	 * Manage internal states
	 */

	protected int id;
	
	protected User user;
	
	
	/*
	 * UserDAO methods
	 */
	public void delete(int id)
	{
		this.id = id;
	}

	public User findById(int id)
	{	
		return user;
	}

	public void insert(User user)
	{
		this.user = user;
	}

	public void update(User user)
	{
		this.user = user;
	}
}
