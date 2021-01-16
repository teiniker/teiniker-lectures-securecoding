package org.se.lab;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class ArticleServiceImpl  // package private
	implements ArticleService
{
	/*
	 * Property: articleList : Article[*]
	 */
	private final List<Article> articleList = new ArrayList<Article>();
	
	
	public void addArticle(long id, String name, String description, String price)
	{
		Article article = new Article(id, name, description, new BigDecimal(price));
		articleList.add(article);		
	}

	
	public void removeArticle(long id)
	{
		for(int i=0; i<articleList.size();i++)
		{
			Article article = articleList.get(i);
			if(article.getId() == id)
			{
				articleList.remove(i);
				return;
			}
		}
		throw new ServiceException("article with given id not found!");
	}

	
	public List<Article> getArticleList()
	{		 
		return articleList;
	}

	public BigDecimal calculateTotalSum()
	{
		BigDecimal sum = new BigDecimal(0);
		for(int i=0; i<articleList.size();i++)
		{
			Article article = articleList.get(i);
			sum.add(article.getPrice());
		}		
		return sum;
	}
}
