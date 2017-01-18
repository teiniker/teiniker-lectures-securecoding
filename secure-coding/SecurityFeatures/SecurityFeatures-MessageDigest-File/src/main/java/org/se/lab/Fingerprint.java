package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class Fingerprint
{
    private Fingerprint() {}
    
    public static String sha256(byte[] data)
    {
        if(data == null)
            throw new IllegalArgumentException("Byte array is null!");
        
        try
        {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            algorithm.update(data);
            byte[] bytes = algorithm.digest();
            return Hex.encodeHexString(bytes);
        } 
        catch (NoSuchAlgorithmException e)
        {
            throw new IllegalStateException("Unable to calulate fingerprint!", e);
        }
    }
    
    public static String sha256(File file)
    {
        if(file == null)
            throw new IllegalArgumentException("File is null!");
            
        if(!file.exists())
            throw new IllegalArgumentException("File " + file.getAbsolutePath() + " does not exist!");
        
        try
        {        
            int length = (int) file.length();
            byte[] content = new byte[length];

            InputStream in = new FileInputStream(file);
            in.read(content);
            in.close();
            
            return sha256(content);
        } 
        catch (IOException e)
        {
            throw new IllegalStateException("Can't read file: " + file.getAbsolutePath());
        }      
    }
}
