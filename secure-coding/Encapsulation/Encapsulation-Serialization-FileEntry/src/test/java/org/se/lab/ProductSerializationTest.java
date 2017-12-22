package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;


public class ProductSerializationTest
{
    private final static String FILENAME = "product.bin";

    /*
     * Note that loading a wrong file would deserialize (and execute readObject())
     * an FileEntry type!!
     * In this way, we can inject any type found in the class path...
     */
    @Test
    public void testReadSerialization() throws IOException, ClassNotFoundException
    {
        FileInputStream in = new FileInputStream(new File("data.bin"));
        ObjectInputStream ois = new ObjectInputStream(in);
        Product copy = (Product) ois.readObject(); // => java.lang.ClassCastException
        in.close();
    }
}
