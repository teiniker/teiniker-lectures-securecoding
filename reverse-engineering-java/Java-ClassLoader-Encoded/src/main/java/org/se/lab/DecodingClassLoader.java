package org.se.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

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
		try
		{
			System.out.println("  load bytes from: " + className + ".hex");			
			String content = readString(className + ".hex");
	        byte[] xorBytes = Hex.decodeHex(content.toCharArray()); 	        
	        byte[] classBytes = xorBytes(xorBytes, 0xcc);
			
			return classBytes;
		}
		catch(IOException | DecoderException e)
		{
			return null;
		}
	}
	
	
    private String readString(String filename) throws IOException
    {
        BufferedReader reader = new BufferedReader( new FileReader (new File(".", filename)));
        String content = reader.readLine();
        reader.close();
        return content;
    }
    
    private byte[] xorBytes(byte[] bytes, int key)
    {
        byte[] result = new byte[bytes.length];
        for(int i=0; i<bytes.length; i++)
        {
            result[i] = xorByte(bytes[i], key);
        }
        return result;
    }

    private byte xorByte(byte a, int key)
    {
        int ia = a;
        int r = ia ^ key;
        return (byte)r;
    }
}
