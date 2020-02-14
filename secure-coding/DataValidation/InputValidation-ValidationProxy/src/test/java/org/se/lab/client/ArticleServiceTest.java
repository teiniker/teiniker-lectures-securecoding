package org.se.lab.client;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.*;

public class ArticleServiceTest
{
	private ArticleService cart;
	
	@Before
	public void setup()
	{
		cart = Factory.createArticleService();
	}
	
	@Test
	public void testAddArticle() throws ServiceException
	{
		Article article = new Article(7, "The Java Programming Language", 
				"Addison-Wesley Longman, Amsterdam, Auflage: 4th ed. (17. August 2005)", 
				"24.92");
		cart.addArticle(article);
	}

	// TODO: Implement a test for calculateTotalSum()!!!!

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_Null() throws ServiceException
	{
		cart.addArticle(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveArticle_IdNegative() throws ServiceException
	{
		cart.removeArticle(-1);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testGetArticleList_ReadOnly()
	{
		cart.getArticleList().clear();
	}
}
