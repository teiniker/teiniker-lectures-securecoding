package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListStringTest
{
	private LinkedList<String> list;
	
	@Before
	public void setup()
	{
		list = new LinkedListImpl<String>();

		list.append("one");
		list.append("two");
		list.append("three");
		list.prepend("four");
	}
	
	@Test
	public void testLength()
	{
		int length = list.length();
		
		Assert.assertEquals(4, length);		
	}
	
	
	@Test
	public void testGet()
	{
		Assert.assertEquals("four", list.get(0));
		Assert.assertEquals("one", list.get(1));
		Assert.assertEquals("two", list.get(2));
		Assert.assertEquals("three", list.get(3));
	}

	@Test
	public void testRemove()
	{
		list.removeAll();
		
		Assert.assertNull(list.get(0));
	}
}
