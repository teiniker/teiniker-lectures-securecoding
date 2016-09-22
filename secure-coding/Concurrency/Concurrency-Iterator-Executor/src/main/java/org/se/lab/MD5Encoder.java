package org.se.lab;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Encoder
{
    /*
     * Don't create an instance of this class.
     */
    private MD5Encoder() {}
    
    
    public static byte[] convertToMD5Bytes(String s) 
        throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        if(s == null)
            throw new IllegalArgumentException();
        
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte[] defaultBytes = s.getBytes("UTF-8");
        algorithm.update(defaultBytes);
        byte[] bytes = algorithm.digest();
        return bytes;
    }

    
    public static String convertToHexString(byte[] bytes)
    {
        if(bytes == null)
            throw new IllegalArgumentException();
        
        StringBuffer hex = new StringBuffer();
        for (byte b : bytes)
        {
            int i = (b & 0xff); // copy the byte bit pattern into int value
            hex.append(String.format("%02x", i));
        }
        return hex.toString();
    }
    
    public static String convertToMD5String(String s)
    {        
        if(s == null)
            throw new IllegalArgumentException();
        
        try
        {
            return convertToHexString(convertToMD5Bytes(s));
        } 
        catch (NoSuchAlgorithmException e)
        {
            throw new IllegalStateException("MD5 convertion failure", e);
           
        } 
        catch (UnsupportedEncodingException e)
        {
            throw new IllegalStateException("MD5 convertion failure",e);        
        }
    }
}
