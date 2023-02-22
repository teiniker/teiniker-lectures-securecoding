package org.se.lab;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class EncryptedFileTest {
    private EncryptedFile file;

    @Before
    public void setup()
    {
        String ivString = "f7c317b693e5e60ef152b348e40763a9";
        String keyString = "9a1b447e49d037ad41c11032812eeca1";
        file = new EncryptedFile(keyString, ivString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidKeyString_Null()
    {
        new EncryptedFile(null, "f7c317b693e5e60ef152b348e40763a9");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidKeyString_TooShort()
    {
        new EncryptedFile(null, "f7c317b693e5e60ef152b348e40763a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidKeyString_TooLong()
    {
        new EncryptedFile(null, "f7c317b693e5e60ef152b348e40763a90");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidIvString_Null()
    {
        new EncryptedFile("9a1b447e49d037ad41c11032812eeca1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidIvString_TooShort()
    {
        new EncryptedFile("9a1b447e49d037ad41c11032812eeca1", "f7c317b693e5e60ef152b348e40763");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidIvString_TooLong()
    {
        new EncryptedFile("9a1b447e49d037ad41c11032812eeca1", "f7c317b693e5e60ef152b348e40763a90");
    }


    @Test
    public void testSaveFile() throws DecoderException, IOException
    {
        byte[] data = Hex.decodeHex("000102030405060708090a0b0c0d0e0f".toCharArray());

        file.save("target/data.bin", data);

        String dataString = hexDump("target/data.bin");
        Assert.assertEquals("000102030405060708090a0b0c0d0e0f", dataString);
        System.out.println(dataString);
    }

    @Test
    public void testLoadFile()
    {
        byte[] data = file.load("target/data.bin");

        String dataString = Hex.encodeHexString(data);
        Assert.assertEquals("000102030405060708090a0b0c0d0e0f", dataString);
    }


    @Test
    public void testSaveEncryptedFile() throws DecoderException, IOException
    {
        byte[] data = Hex.decodeHex("000102030405060708090a0b0c0d0e0f".toCharArray());

        file.saveEncrypted("target/encrypted_data.bin", data);

        String dataString = hexDump("target/encrypted_data.bin");
        Assert.assertEquals("5281a3d077881bc8b514dfae332d9af2", dataString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveEncryptedFile_InvalidFilename() throws DecoderException
    {
        byte[] data = Hex.decodeHex("000102030405060708090a0b0c0d0e0f".toCharArray());
        file.saveEncrypted(null, data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveEncryptedFile_InvalidData()
    {
        file.saveEncrypted("target/encrypted_data.bin", null);
    }


    @Test
    public void testLoadEncryptedFile()
    {
        byte[] data = file.loadEncrypted("target/encrypted_data.bin");
        String dataString = Hex.encodeHexString(data);
        Assert.assertEquals("000102030405060708090a0b0c0d0e0f", dataString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoadEncryptedFile_InvalidFilename()
    {
        file.loadEncrypted(null);
    }


    private String hexDump(String filename) throws IOException
    {
        FileInputStream fis = new FileInputStream(new File(filename));
        byte[] dataFromFile = fis.readAllBytes();
        fis.close();
        return Hex.encodeHexString(dataFromFile);
    }
}
