package org.se.lab;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

//	public final class String
//    implements java.io.Serializable, Comparable<String>, CharSequence {
//    /** The value is used for character storage. */
//    private final char value[]; <-- mutable private field !!! 

public class StringAttack
{
	private String s = "Hello!";
		
	@Test
	public void testString()
	{
		Assert.assertEquals("Hello!", s);
	}
	
	@Test
	public void testAttackedString()
	{
		attackString(s);
		Assert.assertEquals("Good Bye!", s);
	}
	
	
	/*
	 * Note that we change the value of the given String object instead of 
	 * creating a new String object and assigning the new reference...
	 */
	protected void attackString(String s)
	{	
		try
		{
			Field value = s.getClass().getDeclaredField("value");
			char[] newValue = "Good Bye!".toCharArray();
			value.setAccessible(true);
			value.set(s, newValue);
		}
		catch(NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e)
		{
			throw new IllegalStateException();
		}
	}
}
