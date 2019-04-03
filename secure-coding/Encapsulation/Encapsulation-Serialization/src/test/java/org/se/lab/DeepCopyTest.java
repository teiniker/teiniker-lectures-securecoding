package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class DeepCopyTest
{
    @Test
    public void testDeepCopy() throws IOException, ClassNotFoundException
    {
        Product product = new Product("Applied Cryptography", 7);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(product);
        oos.close();

        byte[] bytes = bout.toByteArray();

        ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bin);
        Product copy = (Product) ois.readObject();
        ois.close();

        Assert.assertEquals("Applied Cryptography", copy.getName());
        Assert.assertEquals(7, copy.getQuantity());
    }


}
