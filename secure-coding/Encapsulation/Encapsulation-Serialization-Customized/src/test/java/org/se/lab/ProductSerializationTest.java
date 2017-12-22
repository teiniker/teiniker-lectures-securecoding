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


public class ProductSerializationTest
{
    private final static String FILENAME = "product.bin";

    @Test
    public void testWriteSerialization() throws IOException, ClassNotFoundException
    {
        Product product = new Product("Applied Cryptography", 0x11223344);

        FileOutputStream out = new FileOutputStream(new File("product.bin"));
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(product);
        out.close();
    }


    @Test
    public void testReadSerialization() throws IOException, ClassNotFoundException
    {
        FileInputStream in = new FileInputStream(new File("product.bin"));
        ObjectInputStream ois = new ObjectInputStream(in);
        Product copy = (Product) ois.readObject();
        in.close();

        Assert.assertEquals(0x11223344, copy.getQuantity());
        Assert.assertEquals("Applied Cryptography", copy.getName());
    }
}
