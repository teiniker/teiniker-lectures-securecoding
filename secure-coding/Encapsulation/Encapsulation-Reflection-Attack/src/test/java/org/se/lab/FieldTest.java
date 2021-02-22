package org.se.lab;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

public class FieldTest
{	
	@Test
	public void testPrivateFieldAttack() 
		throws SecurityException, NoSuchFieldException, IllegalAccessException
	{
		User user = new User(7, "teini", "*****");
		Field id = user.getClass().getDeclaredField("id");
		id.setAccessible(true);
		id.setInt(user, 17);
		
		Assert.assertEquals(17, user.getId());
	}
}
