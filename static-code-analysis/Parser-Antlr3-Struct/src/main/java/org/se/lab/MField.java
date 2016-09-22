package org.se.lab;

public class MField 
	extends MNamedElement
{
	/*
	 * Constructor
	 */	
	public MField(String name, MType type)
	{
		super(name);
		setType(type);
	}
	
	/*
	 * Association: ---[1]-> type:MType
	 */
	private MType type;
	public MType getType()
	{
		return type;
	}
	public void setType(MType type)
	{
		this.type = type;
	}
}
