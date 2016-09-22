package org.se.lab;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

public class MethodTest
{
	@Test
	public void testPrivateMethodAttack() 
		throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException 
	{
		User user = new User(7, "teini", "*****");
	
		Method m = user.getClass().getDeclaredMethod("setId", int.class);
		// Note that we access a private method!!!
		m.setAccessible(true);
		m.invoke(user, 17);
		
		Assert.assertEquals(17, user.getId());
	}
}
