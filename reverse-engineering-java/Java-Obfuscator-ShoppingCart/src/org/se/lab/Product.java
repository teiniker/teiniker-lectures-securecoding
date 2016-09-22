package org.se.lab;

public class Product
	extends Entity
{
	/*
	 * Constructors
	 */
	public Product(int id, String title, long price)
	{
		setId(id);
		setTitle(title);
		setPrice(price);
	}

	public Product(String title, long price)
	{
		setId(getNextId());
		setTitle(title);
		setPrice(price);
	}

	// Default Constructor
	protected Product()
	{
		this("unknown",0);
	}


	// Copy Constructor
	public Product(Product p)
	{
		this(p.getId(), p.getTitle(), p.getPrice());
	}


	/*
	 * Property: id:int
	 */
	private int id;
	public int getId()
	{
		return id;
	}
	public Product setId(int id)
	{
		this.id = id;
		return this;
	}


	/*
	 * Property: title:String
	 */
	private String title;
	public String getTitle()
	{
		return title;
	}
	public Product setTitle(String title)
	{
		if(title == null)
			throw new NullPointerException("title");

		this.title = title;
		return this;
	}


	/*
	 * Property: price:long
	 */
	private long price;
	public long getPrice()
	{
		return price;
	}
	public Product setPrice(long price)
	{
		if(price < 0)
			throw new IllegalArgumentException("price < 0");
		this.price = price;
		return this;
	}


	/*
	 * Association: ---[1]-> category:Category
	 */
	private Category category;
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		if(category == null)
			throw new NullPointerException("category");
		this.category = category;
	}



	/*
	 * Operations
	 */


	public String toXml()
	{
		return "<product id=\"" + getId() 
			+ "\" title=\"" + getTitle() + "\" price=\""
			+ getPrice()/100.0 + "\"/>";
	}

	/*
	 * Object method
	 */
	public String toString()
	{
		return getId() + "," + getTitle() + "," + getPrice()/100.0;
	}
}
