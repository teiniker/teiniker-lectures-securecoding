package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest
{
	private LinkedList list;
	
	@Before
	public void setup()
	{
		list = new LinkedListImpl();

		list.append(1);
		list.append(2);
		list.append(3);
		list.prepend(4);
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
		Assert.assertEquals(Integer.valueOf(4), list.get(0));
		Assert.assertEquals(Integer.valueOf(1), list.get(1));
		Assert.assertEquals(Integer.valueOf(2), list.get(2));
		Assert.assertEquals(Integer.valueOf(3), list.get(3));
	}

	@Test
	public void testRemove()
	{
		list.removeAll();
		
		Assert.assertNull(list.get(0));
	}

}
