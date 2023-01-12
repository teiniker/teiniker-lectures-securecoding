package org.se.lab;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Test;


public class SerializationTest
{
    private final static String FILENAME = "product.bin";
    
    @Test
    public void testWriteSerialization() throws IOException, ClassNotFoundException
    {
        Product product = new Product("Applied Cryptography", 0x11223344);

        writeProduct(FILENAME, product);
    }


    @Test
    public void testReadSerialization() throws IOException, ClassNotFoundException
    {
        Product copy = readProduct(FILENAME);

        Assert.assertEquals(0x11223344, copy.getQuantity());
        Assert.assertEquals("Applied Cryptography", copy.getName());
    }


    public void writeProduct(String filename, Product product) throws IOException
    {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(product);
        oos.close();

        byte[] bytes = bout.toByteArray();
        writeBytes(filename, bytes);
    }
    
    public Product readProduct(String filename) throws IOException, ClassNotFoundException
    {
        byte[] bytes = readBytes(filename);
        ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bin);
        Product product = (Product) ois.readObject();
        ois.close();
        return product;
    }

    public byte[] readBytes(String filename) throws IOException
    {
        File file = new File(filename);
        System.out.println("  load bytes from: " + file.getAbsolutePath());
        FileInputStream in = new FileInputStream(file);
        byte[] classBytes = new byte[in.available()];
        in.read(classBytes);
        in.close();
        return classBytes;
    }

    public void writeBytes(String filename, byte[] bytes) throws IOException
    {
        File file = new File(filename);
        System.out.println("  write bytes to: " + file.getAbsolutePath());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();
    }
}
