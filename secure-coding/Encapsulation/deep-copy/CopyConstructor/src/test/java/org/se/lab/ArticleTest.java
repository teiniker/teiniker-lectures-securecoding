package org.se.lab;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ArticleTest
{

	@Test
	public void testCopyConstructor()
	{
		Article book = new Article(7, "The Java Programming Language", new BigDecimal("39.95"));
		
		Article copy = new Article(book);
		book.setArticleNumber(8);
		book.setDescription("The C Programming Language");
		book.setPrice(new BigDecimal("29.95"));
		
		
		Assert.assertEquals(7, copy.getArticleNumber());
		Assert.assertEquals("The Java Programming Language", copy.getDescription());
		Assert.assertEquals("39.95", copy.getPrice().toString());
	}

}
