package org.se.lab;

import java.util.Arrays;
import java.util.List;

public class TreeVisitor
{
	private static List<String> keywords = Arrays.asList(
			"void", "char", "short", "int", "long", "float", "double");
	
	
	public void visit(MOperation op)
	{
		// action
		System.out.println(op.getName());
		if(keywords.contains(op.getName()))
			throw new IllegalStateException("invalid operation name"); 
		
		// navigate
		visit(op.getType());
		for(MParameter param : op.getParameters())
		{
			visit(param);
		}
	}

	public void visit(MParameter param)
	{
		// action
		System.out.println(param.getName());
		if(keywords.contains(param.getName()))
			throw new IllegalStateException("invalid parameter name"); 
		
		// navigate
		visit(param.getType());
	}

	public void visit(MType type)
	{
		// action		
		System.out.println(type.getName());
	}
}
