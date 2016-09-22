package org.se.lab;

public class Main 
{

	public static void main(String[] args) 
	{
	
		Entity.setNextId(1);
		
		Category book = new Category("Books");		
		Category english = new Category("English Books");
		Category german = new Category("German Books");
		Category programming = new Category("Programming Books");
		
		book.addChild(english);
		english.setParent(book);
		
		book.addChild(german);
		german.setParent(book);
		
		english.addChild(programming);
		programming.setParent(english);

			
		Product p1 = new Product("Programming C", 1790);
		Product p2 = new Product("Java Programming", 3450);

		programming.addProduct(p1);
		p1.setCategory(programming);

		programming.addProduct(p2);
		p2.setCategory(programming);

		
		System.out.println(book.toXml());
	}

}
