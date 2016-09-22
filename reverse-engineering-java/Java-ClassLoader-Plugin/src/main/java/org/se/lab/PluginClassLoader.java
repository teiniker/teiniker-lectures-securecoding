package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PluginClassLoader 
	extends ClassLoader
{
	private final String CLASSPATH;

	public PluginClassLoader(final String classPath)
	{
		super(PluginClassLoader.class.getClassLoader()); // set the parent class loader
		if(classPath == null)
			throw new NullPointerException("classPath");
	
		this.CLASSPATH = classPath;
	}

	
	@Override
	public Class<?> loadClass(String name)
		throws ClassNotFoundException
	{
		if(name == null)
			throw new NullPointerException("name");

		System.out.println("loadClass: " + name);
		Class<?> klass;
		try
		{
			System.out.println("delegate: " + name);
			klass = super.loadClass(name);
		}
		catch(ClassNotFoundException e)
		{
			byte[] classData = findClassBytes(name);
			klass = defineClass(name, classData, 0, classData.length);
		}
		return klass;
	}


	protected byte[] findClassBytes(String className)
	{
		if(className == null)
			throw new NullPointerException(className);

		FileInputStream in = null;
		try
		{
			File file = new File(CLASSPATH,
					className.replace('.', File.separatorChar) + ".class");
			System.out.println("  load bytes from: " + file.getAbsolutePath());
			in = new FileInputStream(file);
			byte[] classBytes = new byte[in.available()];
			in.read(classBytes);
			in.close();
			return classBytes;
		}
		catch(IOException e)
		{
			return null;
		}
	}
}
