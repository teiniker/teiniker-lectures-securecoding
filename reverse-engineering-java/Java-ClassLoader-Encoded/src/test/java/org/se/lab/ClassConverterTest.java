package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

public class ClassConverterTest
{
    @Test
    public void testClassToEncodedString() throws IOException
    {
        byte[] bytes = readBytes("./src/classes", "org.se.lab.HelloWorld");  
        byte[] xorBytes = xorBytes(bytes, 0xcc);
        System.out.println(Hex.encodeHexString(xorBytes));
        writeString("org.se.lab.HelloWorld.hex", Hex.encodeHexString(xorBytes));
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
    
    private byte xorByte(byte a, int key)
    {
        int ia = a;
        int r = ia ^ key;
        return (byte)r;
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

    private void writeString(String filename, String content) throws IOException
    {
        FileWriter fw = new FileWriter(new File(".", filename));
        fw.write(content);
        fw.close();
    }
}
