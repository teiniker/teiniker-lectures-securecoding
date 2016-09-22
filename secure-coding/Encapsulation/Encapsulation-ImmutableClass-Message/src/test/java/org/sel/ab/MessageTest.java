package org.sel.ab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MessageTest
{
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_IdIsNegativ()
	{
		new Message(-1, Arrays.asList("097SGHD787", "XXJSGGA5", "LKSHSN78"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_DataIsNull()
	{
		new Message(0, null);
	}

	@Test
	public void testGetter()
	{
		Message m = new Message(1, Arrays.asList("097SGHD787", "XXJSGGA5", "LKSHSN78"));
		
		Assert.assertEquals(1,m.getId());
		Assert.assertEquals("097SGHD787",m.getData().get(0));
		Assert.assertEquals("XXJSGGA5",m.getData().get(1));
		Assert.assertEquals("LKSHSN78",m.getData().get(2));
	}
	
	
	@Test
	public void testToString()
	{
		Message m = new Message(1, Arrays.asList("097SGHD787", "XXJSGGA5", "LKSHSN78"));
	
		final String actual = m.toString();

		final String expected = "1:[097SGHD787, XXJSGGA5, LKSHSN78]";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testHashCodeAndEquals()
	{
		Message m1 = new Message(1, Arrays.asList("097SGHD787", "XXJSGGA5", "LKSHSN78"));
		Message m2 = new Message(1, Arrays.asList("", "", ""));
		
		// Note that hashCode() and equals() compares the id only!
		Assert.assertTrue(m1.equals(m2));
		Assert.assertTrue(m2.equals(m1));
		Assert.assertEquals(m1.hashCode(), m2.hashCode());
	}
	
	
	@Test
	public void testListAttack1()
	{
		List<String> data = new ArrayList<String>();
		data.add("097SGHD787");
		data.add("XXJSGGA5");
		data.add("LKSHSN78");
		
		Message m = new Message(1, data);
		// attack: hold a reference to internal mutable object
		data.set(1, "---666---");
		
		final String actual = m.toString();

		final String expected = "1:[097SGHD787, XXJSGGA5, LKSHSN78]";
		Assert.assertEquals(expected, actual);		
	}

	
	@Test
	public void testListAttack2()
	{
		Message m = new Message(1, Arrays.asList("097SGHD787", "XXJSGGA5", "LKSHSN78"));
		// attack: get reference to internal mutable object
		List<String> data = m.getData();
		data.set(1, "---666---");
		
		final String actual = m.toString();

		final String expected = "1:[097SGHD787, XXJSGGA5, LKSHSN78]";
		Assert.assertEquals(expected, actual);		
	}
}
