package org.se.lab;

public class Factory
{
	/*
	 * Create a ArticleService object and a validaton proxy. 
	 */
	public static ArticleService createArticleService()
	{
		return new ArticleServiceImpl();
	}
}
