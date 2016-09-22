package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTestString
{
	private Stack<String> stack;
	
	
	@Before
	public void setup()
	{
		stack = new StackImpl<String>();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");		
	}
	
	@Test
	public void testSize()
	{
		int size = stack.size();
		
		Assert.assertEquals(4, size);
	}
	
	
	@Test
	public void testPop()
	{
		Assert.assertEquals("four", stack.pop());
		Assert.assertEquals("three", stack.pop());
		Assert.assertEquals("two", stack.pop());
		Assert.assertEquals("one", stack.pop());
		
		Assert.assertEquals(0, stack.size());
		
		Assert.assertNull(stack.pop());
	}
}
