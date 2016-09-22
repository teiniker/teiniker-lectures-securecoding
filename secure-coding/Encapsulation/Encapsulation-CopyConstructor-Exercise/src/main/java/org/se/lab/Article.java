package org.se.lab;

import java.math.BigDecimal;

public class Article
{
	/*
	 * Constructor
	 */
	public Article(long articleNumber, String description, BigDecimal price)
	{
		setArticleNumber(articleNumber);
		setDescription(description);
		setPrice(price);
	}
	
	
	/*
	 * Property: articleNumber:long
	 */
	private long articleNumber;
	public final long getArticleNumber()
	{
		return articleNumber;
	}
	public final void setArticleNumber(long articleNumber)
	{
		this.articleNumber = articleNumber;
	}
	
	/*
	 * Property: description:String
	 */
	private String description;
	public final String getDescription()
	{
		return description;
	}
	public final void setDescription(String description)
	{
		this.description = description;
	}
	
	
	/*
	 * property: price:BigDecimal
	 */
	private BigDecimal price;
	public final BigDecimal getPrice()
	{
		return price;
	}
	public final void setPrice(BigDecimal price)
	{
		this.price = price;
	}
	
}
