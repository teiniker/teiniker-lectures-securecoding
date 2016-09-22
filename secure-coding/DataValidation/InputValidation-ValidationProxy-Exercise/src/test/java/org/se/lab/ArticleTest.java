package org.se.lab;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.Article;

public class ArticleTest
{
	private Article article;
	
	@Before
	public void setup()
	{
		article = new Article(7, "The Java Programming Language", 
				"Addison-Wesley Longman, Amsterdam, Auflage: 4th ed. (17. August 2005)", 
				"24.92");		
	}
	
	
	@Test
	public void testConstructor()
	{
		Assert.assertEquals(7, article.getId());
		Assert.assertEquals("The Java Programming Language", article.getName());
		Assert.assertEquals("Addison-Wesley Longman, Amsterdam, Auflage: 4th ed. (17. August 2005)", article.getDescription());
		Assert.assertEquals(new BigDecimal("24.92"), article.getPrice());
	}
	
	@Test
	public void testCopyConstructor()
	{
		Article copy = new Article(article);
		Assert.assertEquals(7, copy.getId());
		Assert.assertEquals("The Java Programming Language", copy.getName());
		Assert.assertEquals("Addison-Wesley Longman, Amsterdam, Auflage: 4th ed. (17. August 2005)", copy.getDescription());
		Assert.assertEquals(new BigDecimal("24.92"), article.getPrice());
		Assert.assertFalse(copy.getPrice() == article.getPrice());	
	}
	
	@Test
	public void testSetId()
	{
		article.setId(0);
		article.setId(100000000);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testSetId_WithNegativeValue()
	{
		article.setId(-1);
	}
	
	@Test
	public void testSetName()
	{
		article.setName("1234");
		article.setName("1234567890123456789012345678901234567890123456789012345678901234");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetName_WithNullReference()
	{
		article.setName(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetName_WithTooShortValue()
	{
		article.setName("123");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetName_WithTooLongValue()
	{
		article.setName("12345678901234567890123456789012345678901234567890123456789012345");
	}
	
	
	@Test
	public void testSetDescription()
	{
		article.setDescription("");
		article.setDescription(
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"123456");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetDescription_WithNullReference()
	{
		article.setDescription(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetDescription_WithTooLongValue()
	{
		article.setDescription(
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"12345678901234567890123456789012345678901234567890" +
				"1234567");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetDescription_WithIllegalCharacter1()
	{
		article.setDescription(";");
	}
		
	@Test(expected=IllegalArgumentException.class)
	public void testSetDescription_WithIllegalCharacter2()
	{
		article.setDescription("'");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetDescription_WithIllegalCharacter3()
	{
		article.setDescription("/");
	}

	
	@Test
	public void testSetPrice()
	{
		article.setPrice("0.0");
		article.setPrice("3.14");
		article.setPrice("9999999999.99999999999999999");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetPrice_WithNegaticePrice()
	{
		article.setPrice("-1.0");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetPrice_WithStringNullReference()
	{
		article.setPrice((String)null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetPrice_WithBigDecimalNullReference()
	{
		article.setPrice((BigDecimal)null);
	}
}
