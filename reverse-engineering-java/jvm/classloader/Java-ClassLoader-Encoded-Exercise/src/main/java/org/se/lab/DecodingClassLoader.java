package org.se.lab;

public class DecodingClassLoader 
	extends ClassLoader
{
	public DecodingClassLoader()
	{
		super(DecodingClassLoader.class.getClassLoader()); // set the parent class loader
	}
	
	
	@Override
	public Class<?> loadClass(String name)
		throws ClassNotFoundException
	{
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


	private byte[] findClassBytes(String className)
	{		
		// TODO
		return null;
	}	
}
