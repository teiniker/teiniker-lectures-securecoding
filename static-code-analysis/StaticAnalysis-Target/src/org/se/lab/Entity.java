package org.se.lab;

public abstract class Entity
{
	/*
	 * Property: id
	 */
	private long id;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		if(id < 0)
			throw new IllegalArgumentException();
		this.id = id;
	}
	
	
	/*
	 * Object methods
	 */
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
		Entity other = (Entity) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
