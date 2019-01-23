package org.se.lab;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtility
{
    private HashUtility() {}

    public static String sha256AsBase64String(String message)
    {
        if(message == null || message.length() == 0)
            throw new IllegalArgumentException("Invalid message string!");

        byte[] bytes = sha256(message);
        String base64String = Base64.encodeBase64String(bytes);
        return base64String;
    }


    public static String sha256AsHexString(String message)
    {
        if(message == null || message.length() == 0)
            throw new IllegalArgumentException("Invalid message string!");

        byte[] bytes = sha256(message);
        String hexString = Hex.encodeHexString(bytes);
        return hexString;
    }


    private static byte[] sha256(String message)
    {
        try
        {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            algorithm.update(message.getBytes("UTF-8"));
            byte[] bytes = algorithm.digest();
            return bytes;
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
        {
            throw new IllegalStateException("Can't calculate SHA-256 for the given message!", e);
        }
    }

}
