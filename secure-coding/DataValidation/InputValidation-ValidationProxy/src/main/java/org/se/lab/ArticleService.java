package org.se.lab;

import java.math.BigDecimal;
import java.util.List;

public interface ArticleService
{
	/*
	 * Add an article to the ShoppingCard's article list.
	 * (Articles are only stored in memory) 
	 * Throw ServiceException is the article can't be stored in the list.
	 */
	void addArticle(Article a); 
	
	/*
	 * Remove the article with the given id from the article list. 
	 * Throw an exception if the given article can't be removed from the list.
	 */
	void removeArticle(long id); 
	
	/*
	 * Returns a deep copy of the stored article list.
	 */
	List<Article> getArticleList(); 
	
	/*
	 * Calculate the total sum of prices for the stored article list.
	 */
	BigDecimal calculateTotalSum(); 
}
