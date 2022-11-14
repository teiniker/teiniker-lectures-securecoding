package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest
{
	@Test
	public void testGetter()
	{
		Person homer = new Person("Homer Simpson", "Springfield");
		
		Assert.assertEquals("Homer Simpson",homer.name());
		Assert.assertEquals("Springfield",homer.address());
	}

	@Test
	public void testToString()
	{
		Person homer = new Person("Homer Simpson", "Springfield");

		Assert.assertEquals("Person[name=Homer Simpson, address=Springfield]", homer.toString());
	}
	
	@Test
	public void testHashCodeAndEquals()
	{
		Person homer1 = new Person("Homer Simpson", "Springfield");
		Person homer2 = new Person("Homer Simpson", "Springfield");
		
		// Note that hashCode() and equals() compares the id only!
		Assert.assertTrue(homer1.equals(homer2));
		Assert.assertTrue(homer2.equals(homer1));

		Assert.assertEquals(homer1.hashCode(), homer2.hashCode());
	}
}
