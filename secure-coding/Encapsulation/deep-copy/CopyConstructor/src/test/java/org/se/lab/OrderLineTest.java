package org.se.lab;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class OrderLineTest
{
	@Test
	public void testCopyConstructor()
	{
		Article book = new Article(7, "The Java Programming Language", new BigDecimal("39.95"));
		OrderLine line = new OrderLine(book, 100);
		
		OrderLine copy = new OrderLine(line);
		line.setQuantity(1);
		line.getArticle().setArticleNumber(8);
		line.getArticle().setDescription("The C Programming Language");
		line.getArticle().setPrice(new BigDecimal("29.95"));
		
		Assert.assertEquals(100, copy.getQuantity());
		Assert.assertEquals(7, copy.getArticle().getArticleNumber());
		Assert.assertEquals("The Java Programming Language", copy.getArticle().getDescription());
		Assert.assertEquals("39.95", copy.getArticle().getPrice().toString());
	}
}
