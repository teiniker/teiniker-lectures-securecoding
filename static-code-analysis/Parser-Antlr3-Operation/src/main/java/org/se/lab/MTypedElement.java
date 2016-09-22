package org.se.lab;

public abstract class MTypedElement
	extends MNamedElement
{
	
	/*
	 * Reference: ---[1]-> type:MType
	 */
	private MType type;
	public MType getType()
	{
		return type;
	}
	public void setType(MType type)
	{
		if(type == null)
			throw new IllegalArgumentException();
		this.type = type;
	}
	
}
