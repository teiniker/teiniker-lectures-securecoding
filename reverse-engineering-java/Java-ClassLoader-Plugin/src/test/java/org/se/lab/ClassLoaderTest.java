package org.se.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.se.lab.Plugin;
import org.se.lab.PluginClassLoader;

public class ClassLoaderTest
{

	/*
	 * Loading a class dynamically is easy. All you need to do is to obtain
	 * a ClassLoader  and call its loadClass() method.
	 */
	@Test
	public void testSystemClassLoader() throws ClassNotFoundException
	{
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
		assertNotNull(classLoader);

		Class<?> aClass = classLoader.loadClass("org.se.lab.Plugin");
		assertEquals("org.se.lab.Plugin", aClass.getName());
	}


	/*
	 * We get null if we try to get the class loader of a core Java runtime
	 * class (see JRE/lib/rt.jar)
	 */
	@Test
	public void testBootstrapClassLoader() 
		throws ClassNotFoundException
	{
		ClassLoader classLoader = String.class.getClassLoader();
		assertNull(classLoader);
	}


	@Test
	public void testPluginClassLoader() 
		throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		PluginClassLoader loader = new PluginClassLoader("./src/plugins");

		Class<? extends Plugin> klass = loader.loadClass("org.se.lab.InternPlugin").asSubclass(Plugin.class);
		Plugin p = klass.newInstance();
		assertTrue(p instanceof Plugin);

		// Use loaded plugin implementation
		p.start();
		p.stop();
	}
}
