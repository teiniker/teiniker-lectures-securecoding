package org.se.lab;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Article
{	
	/*
	 * Constructors
	 */
	public Article(long id, String name, String description, BigDecimal price)
	{
		setId(id);
		setName(name);
		setDescription(description);
		setPrice(new BigDecimal(price.toPlainString()));
	}
	
	public Article(long id, String name, String description, String price)
	{
		this(id,name,description, new BigDecimal(price));
	}
	
	public Article(Article a)
	{
		this(a.id, a.name, a.description, a.price);
	}
	
	
	/*
	 * Property: id:long
	 */
	private long id;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
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
		this.name = name;
	}


	/*
	 * Property: description:String
	 */
	private String description;
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}


	/*
	 * Property: price:Bigecimal
	 */
	private BigDecimal price;
	public BigDecimal getPrice()
	{
		return price;
	}
	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}
	public void setPrice(String s)
	{
		setPrice(new BigDecimal(s));
	}

	
	/*
	 * Object methods
	 */
	@Override
	public String toString()
	{
		return getId() + "," + getName() + "," + getDescription() + "," + getPrice();
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
		Article other = (Article) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
