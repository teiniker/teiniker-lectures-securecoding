package org.se.lab;

public class OrderLine
{
	/*
	 * Constructor
	 */
	public OrderLine(Article article, long quantity)
	{
		setArticle(article);
		setQuantity(quantity);
	}
	
	public OrderLine(OrderLine line)
	{
		setArticle(new Article(line.article));
		setQuantity(line.quantity);
	}

	
	/*
	 * Property: article:Article
	 */
	private Article article;
	public final Article getArticle()
	{
		return article;
	}
	public final void setArticle(Article article)
	{
		this.article = article;
	}
	
	
	/*
	 * Property: quantity:long
	 */
	private long quantity;
	public final long getQuantity()
	{
		return quantity;
	}
	public final void setQuantity(long quantity)
	{
		this.quantity = quantity;
	}
}
