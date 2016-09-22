package org.se.lab;

public class Factory
{
	/*
	 * Create a ArticleService object and a validation proxy. 
	 */
	public static ArticleService createArticleService()
	{
		return new ArticleServiceValidator(new ArticleServiceImpl());
	}
}
