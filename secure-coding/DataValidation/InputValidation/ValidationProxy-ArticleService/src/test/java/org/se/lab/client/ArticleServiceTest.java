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
		cart.addArticle(7, "The Java Programming Language",
				"Addison-Wesley Longman, Amsterdam, Auflage: 4th ed. (17. August 2005)",
				"24.92");
	}

	// TODO: Implement a test for calculateTotalSum()!!!!

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_idIsNegative() throws ServiceException
	{
		cart.addArticle(-7, "The Java Programming Language",
				"Addison-Wesley Longman, Amsterdam, Auflage: 4th ed. (17. August 2005)",
				"24.92");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_NameIsNull() throws ServiceException
	{
		cart.addArticle(7, null,
				"Addison-Wesley Longman, Amsterdam, Auflage: 4th ed. (17. August 2005)",
				"24.92");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_NameIsTooShort() throws ServiceException
	{
		cart.addArticle(7, "123",
				"Addison-Wesley Longman, Amsterdam, Auflage: 4th ed. (17. August 2005)",
				"24.92");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_NameIsTooLong() throws ServiceException
	{
		cart.addArticle(7, "12345678901234567890123456789012345678901234567890123456789012345",
				"Addison-Wesley Longman, Amsterdam, Auflage: 4th ed. (17. August 2005)",
				"24.92");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_DescriptionIsNull() throws ServiceException
	{
		cart.addArticle(7, "The Java Programming Language",
				null,
				"24.92");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_DescriptionTooLong() throws ServiceException
	{
		cart.addArticle(7, "The Java Programming Language",
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"1234567",
				"24.92");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_DescriptionIllegalChar1() throws ServiceException
	{
		cart.addArticle(7, "The Java Programming Language",
				";",
				"24.92");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_DescriptionIllegalChar2() throws ServiceException
	{
		cart.addArticle(7, "The Java Programming Language",
				"'",
				"24.92");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_DescriptionIllegalChar3() throws ServiceException
	{
		cart.addArticle(7, "The Java Programming Language",
				"/",
				"24.92");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_priceIsNegative() throws ServiceException
	{
		cart.addArticle(7, "The Java Programming Language",
				"Addison-Wesley Longman, Amsterdam, Auflage: 4th ed. (17. August 2005)",
				"-24.92");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddArticle_priceIsNullString() throws ServiceException
	{
		cart.addArticle(7, "The Java Programming Language",
				"Addison-Wesley Longman, Amsterdam, Auflage: 4th ed. (17. August 2005)",
				(String)null);
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
