package org.se.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;


public class FileIOTest
{
    @Test
    public void testReadBytesAndWriteString() throws IOException
    {
        byte[] bytes = readBytes("./src/classes", "org.se.lab.HelloWorld");        
        Assert.assertNotNull(bytes);

        byte[] xorBytes = xorBytes(bytes, 0xcc);
        System.out.println(Hex.encodeHexString(xorBytes));
        writeString("HelloWorld.txt", Hex.encodeHexString(xorBytes));
        
    }

    
    @Test
    public void testReadStringWriteBytes() throws IOException, DecoderException
    {
        String content = readString("HelloWorld.txt");
        byte[] xorBytes = Hex.decodeHex(content.toCharArray()); 
        
        byte[] bytes = xorBytes(xorBytes, 0xcc);
        System.out.println(Hex.encodeHexString(bytes));        
    }
    
    private String readString(String filename) throws IOException
    {
        BufferedReader reader = new BufferedReader( new FileReader (new File(".", filename)));
        String content = reader.readLine();
        reader.close();
        return content;
    }
    
    private void writeString(String filename, String content) throws IOException
    {
        FileWriter fw = new FileWriter(new File(".", filename));
        fw.write(content);
        fw.close();
    }
    
    private byte[] readBytes(String CLASSPATH, String className) throws IOException
    {
        File file = new File(CLASSPATH,className.replace('.', File.separatorChar) + ".class");
        System.out.println("  load bytes from: " + file.getAbsolutePath());
        FileInputStream in = new FileInputStream(file);
        byte[] classBytes = new byte[in.available()];
        in.read(classBytes);
        in.close();
        return classBytes;
    }
    
    private void writeBytes(String CLASSPATH, String className, byte[] bytes) throws IOException
    {
        File file = new File(CLASSPATH,className.replace('.', File.separatorChar) + ".class");
        System.out.println("  write bytes to: " + file.getAbsolutePath());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();        
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
