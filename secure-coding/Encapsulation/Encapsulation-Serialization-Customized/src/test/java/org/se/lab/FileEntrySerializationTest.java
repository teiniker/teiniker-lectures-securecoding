package org.se.lab;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;


public class FileEntrySerializationTest
{
    private final static String FILENAME = "file_entry.bin";

    private byte[] data = HexBin.decode("000102030405060708090a0b0c0d0e0f");

    @Test
    public void testWriteSerialization() throws IOException, ClassNotFoundException
    {
        FileEntry entry = new FileEntry("eval.bin", data);

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

        System.out.println(entry);
    }
}
