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
        System.out.println(Hex.encodeHexString(bytes));
        writeString("org.se.lab.HelloWorld.hex", Hex.encodeHexString(bytes));
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

    private void writeString(String filename, String content) throws IOException
    {
        FileWriter fw = new FileWriter(new File(".", filename));
        fw.write(content);
        fw.close();
    }
}
