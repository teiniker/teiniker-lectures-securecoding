package org.se.lab;

public abstract class MNamedElement
{
	
	/*
	 * Property: name:String
	 */
	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		if(name == null)
			throw new IllegalArgumentException();
		this.name = name;
	}
}
