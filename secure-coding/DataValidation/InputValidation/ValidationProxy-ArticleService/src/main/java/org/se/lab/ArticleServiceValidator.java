package org.se.lab;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ArticleServiceValidator // package private
	implements ArticleService
{
	private final ArticleService impl;
	private final Pattern namePattern = Pattern.compile("^[a-zA-Z0-9 ]{4,64}$");
	private final Pattern descriptionPattern = Pattern.compile("^[a-zA-Z0-9,:.\\-)( ]{0,256}$");

	public ArticleServiceValidator(ArticleService impl)
	{
		if(impl == null)
			throw new IllegalArgumentException();
		
		this.impl = impl;
	}
	
	// Interface Methods

	@Override
	public void addArticle(long id, String name, String description, String price)
	{
		// validate parameter
		// id >= 0
		// name:
		//		not null
		//		a-z A-Z 0-9 and space
	 	// 		length = [4,64]
		// description:
		//		not null
		//		a-z A-Z 0-9 , : . \ - ) ( and space
		//		length = [0,256]
		// price:
		// 		not null
		// 		>= 0.0

		if(id < 0)
			throw new IllegalArgumentException("Invalid id!");

		if(name == null)
			throw new IllegalArgumentException("Invalid name (null)!");
		Matcher m1 = namePattern.matcher(Normalizer.normalize(name, Normalizer.Form.NFKC));
		if(!m1.matches())
			throw new IllegalArgumentException("Invalid name!");

		if(description == null)
			throw new IllegalArgumentException("Invalid description (null)!");
		Matcher m2 = descriptionPattern.matcher(Normalizer.normalize(description, Normalizer.Form.NFKC));
		if(!m2.matches())
			throw new IllegalArgumentException("Invalid description!");

		if(price == null || new BigDecimal(price).doubleValue() < 0.0)
			throw new IllegalArgumentException("Invalid price!");

		// delegate to the implementation
		impl.addArticle(id, name, description, price);
	}

	
	@Override
	public void removeArticle(long id)
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
