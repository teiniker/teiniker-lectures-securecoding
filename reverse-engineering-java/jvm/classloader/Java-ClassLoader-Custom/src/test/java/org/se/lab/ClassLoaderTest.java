package org.se.lab;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

public class ClassLoaderTest
{
	@Test
	public void testPluginClassLoader() 
		throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		CustomClassLoader loader = new CustomClassLoader();

		Class<?> klass = loader.loadClass("org.se.lab.HelloWorld");
		Assert.assertEquals("org.se.lab.HelloWorld", klass.getName());

		Method m = klass.getDeclaredMethod("sayHello");
		Object obj = klass.getDeclaredConstructor().newInstance();
		m.invoke(obj);
	}
}
