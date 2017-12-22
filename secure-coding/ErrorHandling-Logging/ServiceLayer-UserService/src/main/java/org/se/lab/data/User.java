package org.se.lab.data;

public class User
{
	/*
	 * Constructor
	 */

	protected User() {}
	
	
	/*
	 * Property: id:int
	 */
	private int id;
	public final int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		if(id < 0)
			throw new IllegalArgumentException("Invalid id (" + id + ")!");
		this.id = id;
	}


	/*
	 * Property: firstname:String
	 */
	private String firstname;
	public final String getFirstname()
	{
		return firstname;
	}
	public final void setFirstname(final String firstname)
	{
		if(firstname == null)
			throw new IllegalArgumentException("Invalid firstname (null)!");
		this.firstname = firstname;
	}

	
	/*
	 * Property: lastname:String
	 */
	private String lastname;
	public final String getLastname()
	{
		return lastname;
	}
	public final void setLastname(final String lastname)
	{
		if(lastname == null)
			throw new IllegalArgumentException("Invalid lastname (null)!");
		this.lastname = lastname;
	}

	
	/*
	 * Property: username:String
	 */
	private String username;
	public final String getUsername()
	{
		return username;
	}
	public final void setUsername(final String username)
	{
		if(username == null)
			throw new IllegalArgumentException("Invalid username (null)!");
		this.username = username;
	}

	
	/*
	 * Property: password:String
	 */
	private String password;
	public final String getPassword()
	{
		return password;
	}
	public final void setPassword(final String password)
	{
		if(password == null)
			throw new IllegalArgumentException("Invalid password (null)");
		this.password = password;
	}

	
	/*
	 * Object methods
	 */
	
	@Override
	public String toString()
	{
		return getId() + "," + getFirstname() + "," + getLastname() + "," + getUsername();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
