package org.se.lab;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;


public class FileEntrySerializationTest
{
    private final static String FILENAME = "file_entry.bin";

    private byte[] data;

    @Before
    public void setup() throws DecoderException
    {
        data = Hex.decodeHex("000102030405060708090a0b0c0d0e0f".toCharArray());
    }

    @Test
    public void testWriteSerialization() throws IOException, ClassNotFoundException
    {
        FileEntry entry = new FileEntry("evil.exe", data);

        FileOutputStream out = new FileOutputStream(new File("data.bin"));
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(entry);
        out.close();
    }


    @Test
    public void testReadSerialization() throws IOException, ClassNotFoundException
    {
        FileInputStream in = new FileInputStream(new File("data.bin"));
        ObjectInputStream ois = new ObjectInputStream(in);
        FileEntry entry = (FileEntry) ois.readObject();
        in.close();

        Assert.assertEquals("evil.exe", entry.getPath());
        System.out.println(entry);
    }
}
