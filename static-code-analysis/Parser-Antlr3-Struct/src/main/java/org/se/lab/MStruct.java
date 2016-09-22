package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MStruct
	extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MStruct(String name)
	{
		super(name);
	}
	
	
	/*
	 * Association: ---[1..*]-> fields:MField
	 */
	private List<MField> fields = new ArrayList<MField>();
	public List<MField> getFields()
	{
		//return Collections.unmodifiableList(fields);
		return fields;
	}
	public void setFields(List<MField> fields)
	{
		this.fields = fields;
	}
}
