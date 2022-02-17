package org.se.lab;

import java.io.File;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;


public class FingerprintTest
{
    public static final String INPUT_FILE_NAME = "./tux.jpg";

    @Test
    public void testArrayFingerprint() throws DecoderException
    {
        byte[] data = Hex.decodeHex("000102030405060708090a0b0c0d0e0f".toCharArray());
        
        String hashValue = Fingerprint.sha256(data);
        
        Assert.assertEquals("be45cb2605bf36bebde684841a28f0fd43c69850a3dce5fedba69928ee3a8991", hashValue);
    }
    
    @Test
    public void testFileFingerprint()
    {
        String hashValue = Fingerprint.sha256(new File(INPUT_FILE_NAME));
        
        Assert.assertEquals("8d31e130ba8b62c0ac79b6e0eba3ea8b06013cdb9db395f46ad46d15df1bf521", hashValue);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testArrayFingerprint_NullPointer()
    {
        Fingerprint.sha256((byte[])null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFileFingerprint_NullPointer()
    {
        Fingerprint.sha256((File)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFileFingerprint_InvalidFile()
    {
        Fingerprint.sha256(new File("./xxx.jpg"));
    }

}
