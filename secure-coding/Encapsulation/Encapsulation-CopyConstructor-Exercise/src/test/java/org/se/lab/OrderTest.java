package org.se.lab;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class OrderTest
{
	@Test
	public void testCopyConstructor()
	{
		Article book = new Article(7, "The Java Programming Language", new BigDecimal("39.95"));
		OrderLine line = new OrderLine(book, 100);
		Order order = new Order(line);
		
		Order copy = new Order(order);		
		order.getLines().get(0).setQuantity(1);
		order.getLines().get(0).getArticle().setArticleNumber(8);
		
		Assert.assertEquals(100, copy.getLines().get(0).getQuantity());
		Assert.assertEquals(7, copy.getLines().get(0).getArticle().getArticleNumber());
		Assert.assertEquals("The Java Programming Language", copy.getLines().get(0).getArticle().getDescription());	
		Assert.assertEquals("39.95", copy.getLines().get(0).getArticle().getPrice().toString());
	}
}
