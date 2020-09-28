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
	 * constraints: 
	 * 	id >= 0
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
	 * Property: name:String
	 * constraints: 
	 * 	not null
	 * 	a-z A-Z 0-9 and space
	 * 	length = [4,64]
	 */
	private String name;
	private final Pattern namePattern = Pattern.compile("^[a-zA-Z0-9 ]{4,64}$");
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		if(name == null)
			throw new IllegalArgumentException();
		
		Matcher m = namePattern.matcher(Normalizer.normalize(name, Form.NFKC));		
		if(!m.matches())		
			throw new IllegalArgumentException();
		
		this.name = name; // TODO: Normalized Version!!!
	}


	/*
	 * Property: description:String
	 * constraints: 
	 * 	not null
	 * 	a-z A-Z 0-9 , : . \ - ) ( and space 
	 * 	length = [0,256]
	 */
	private String description;
	private final Pattern descriptionPattern = Pattern.compile("^[a-zA-Z0-9,:.\\-)( ]{0,256}$");
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		if(description == null)
			throw new IllegalArgumentException();
		
		Matcher m = descriptionPattern.matcher(Normalizer.normalize(description, Form.NFKC));		
		if(!m.matches())		
			throw new IllegalArgumentException();
		
		this.description = description;
	}


	/*
	 * Property: price:Bigecimal
	 * constraints:
	 * 	price >= 0.0
	 */
	private BigDecimal price;
	public BigDecimal getPrice()
	{
		return price;
	}
	public void setPrice(BigDecimal price)
	{
		if(price == null || price.doubleValue() < 0.0)
			throw new IllegalArgumentException();
		
		this.price = price;
	}
	public void setPrice(String s)
	{
		if(s == null)
			throw new IllegalArgumentException();
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
