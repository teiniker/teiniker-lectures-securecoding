package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category
	extends Entity
{
	/*
	 * Constructors
	 */
	public Category(String name)
	{
		setId(getNextId());
		setName(name);
	}


	/*
	 * Property: id:int
	 */
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}


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
			throw new NullPointerException("name");
		this.name = name;
	}


	/*
	 * Association: ---[*]-> products:Product
	 */
	private List<Product> products = new ArrayList<Product>();
	public void addProduct(Product p)
	{
		if(p == null)
			throw new NullPointerException("product");
		products.add(p);
	}
	public List<Product> getProducts()
	{
		return Collections.unmodifiableList(products);
	}

	
	/*
	 * Association: ---[*]-> children:Category
	 */
	private List<Category> children = new ArrayList<Category>();
	public void addChild(Category c)
	{
		if(c == null)
			throw new NullPointerException("child");
		children.add(c);
	}
	public List<Category> getChildren()
	{
		return Collections.unmodifiableList(children);
	}
	
	
	/*
	 * Association: ---[1]-> parent:Category
	 */
	private Category parent;
	public Category getParent()
	{
		return parent;
	}
	public void setParent(Category parent)
	{
		if(parent == null)
			throw new NullPointerException("parent");
		this.parent = parent;
	}
	
	
	/*
	 * Operations
	 */
	
	public String toXml()
	{
		StringBuilder xml = new StringBuilder();
		
		xml.append("<category id=\"").append(getId());
		xml.append("\" name=\"").append(getName());
		xml.append("\">\n");
		for(Product p : getProducts())
		{
			xml.append(p.toXml()).append("\n");
		}
		for(Category c : getChildren())
		{
			xml.append(c.toXml()).append("\n");
		}
		xml.append("</category>");
		return xml.toString();
	}
}
