package org.se.lab;

import java.util.Arrays;
import java.util.List;

public class Validator
{
	final List<String> keywords = Arrays.asList("void", "char", "int", "double", "struct");
	
	
	public void validate(MStruct struct)
	{
		// actions
		if(struct.getName() == null)
			throw new ValidatorException("struct name is null");
		if(keywords.contains(struct.getName()))
			throw new ValidatorException("struct name is a keyword");		

		if(struct.getFields() == null)
			throw new ValidatorException("fields list is null");
		if(struct.getFields().size() < 1)
			throw new ValidatorException("no fileds in the structur");
		
		// walk children
		for(MField field : struct.getFields())
		{
			validate(field);
		}		
	}
	
	
	public void validate(MField field)
	{
		// actions
		if(field.getName() == null)
			throw new ValidatorException("field name is null");
		if(keywords.contains(field.getName()))
			throw new ValidatorException("field name is a keyword");
		
		if(field.getType() == null)
			throw new ValidatorException("type reference is null");
		
		// walk children
		validate(field.getType());
	}
	
	
	public void validate(MType type)
	{
		// action
		if(type.getName() == null)
			throw new ValidatorException("type name is null");
		
		// walk children
	}
}
