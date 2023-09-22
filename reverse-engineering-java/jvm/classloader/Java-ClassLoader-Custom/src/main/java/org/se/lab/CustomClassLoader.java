package org.se.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class CustomClassLoader
	extends ClassLoader
{
	public CustomClassLoader()
	{
		super(CustomClassLoader.class.getClassLoader()); // set the parent class loader
	}

	@Override
	public Class<?> loadClass(String name)
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
		try
		{
			System.out.println("  load bytes from: " + className + ".hex");			
			String content = readString(className + ".hex");
	        byte[] classBytes = Hex.decodeHex(content.toCharArray());

			return classBytes;
		}
		catch(IOException | DecoderException e)
		{
			throw new IllegalStateException("Can't read byte array for class " + className, e);
		}
	}
	
	
    private String readString(String filename) throws IOException
    {
        BufferedReader reader = new BufferedReader( new FileReader (new File(".", filename)));
        String content = reader.readLine();
        reader.close();
        return content;
    }
}
