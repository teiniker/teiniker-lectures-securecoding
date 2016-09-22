package org.se.lab;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class ArticleServiceValidator
	implements ArticleService
{
	private ArticleService impl;
	
	public ArticleServiceValidator(ArticleService impl)
	{
		if(impl == null)
			throw new IllegalArgumentException();
		
		this.impl = impl;
	}
	
	
	@Override
	public void addArticle(Article a) throws ServiceException
	{
		// validate parameter
		// article != null
		if(a == null)
			throw new IllegalArgumentException();
		
		// Article validation is performed in the Article class.
		// If we can not change the Article class we move all
		// the validation code into that proxy.
		impl.addArticle(a);
	}

	
	@Override
	public void removeArticle(long id) throws ServiceException
	{
		// validate parameter
		// id >= 0
		if(id < 0)
			throw new IllegalArgumentException();
		
		impl.removeArticle(id);		
	}

	@Override
	public List<Article> getArticleList()
	{
		List<Article> result = impl.getArticleList();
		
		// validate result
		// result list should be read-only
		return Collections.unmodifiableList(result);
	}

	@Override
	public BigDecimal calculateTotalSum()
	{		
		return impl.calculateTotalSum();
	}
}
