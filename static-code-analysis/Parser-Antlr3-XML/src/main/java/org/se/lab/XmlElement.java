package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlElement
{
	/*
	 * Constructor
	 */
	public XmlElement(String name)
	{
		setName(name);
	}
	
	public XmlElement(String name, String text)
	{
		setName(name);
		setText(text);
	}

	
	public void check(Map<String,String> constraints)
	{
		// validate current node
		System.out.println("check: " + getName() + "  " + getText());
		if(constraints.containsKey(getName()))
		{
			String regex = constraints.get(getName());
		
			Pattern pattern = Pattern.compile(regex);
	        Matcher m = pattern.matcher(getText());
	        if(!m.matches())
	        	throw new IllegalStateException("invalid text in element: " + getElements());
		}
		
		// validate all children
		for(XmlElement e : getElements())
		{
			e.check(constraints);
		}
	}
	
	
	/*
	 * Property: name
	 */
	private String name;
	public final String getName()
	{
		return name;
	}
	public final void setName(String name)
	{
		if(name == null)
			throw new IllegalArgumentException();
		this.name = name;
	}
	
	
	/*
	 * Property: text:String
	 */
	private String text;
	public final String getText()
	{
		return text;
	}
	public final void setText(String text)
	{
		if(text == null)
			throw new IllegalArgumentException();
		this.text = text;
	}
	
	
	/*
	 * Association: children:XmlElement[*]
	 */
	private List<XmlElement> children = new ArrayList<XmlElement>();
	public final void addElement(XmlElement element)
	{
		if(element == null)
			throw new IllegalArgumentException();
		children.add(element);
	}
	public final List<XmlElement> getElements()
	{
		return Collections.unmodifiableList(children);
	}
	public final void setElements(List<XmlElement> list)
	{
		if(list == null)
			throw new IllegalArgumentException();
		children = list;
	}
}
