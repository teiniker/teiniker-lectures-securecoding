package org.se.lab.business;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class PasswordEncoder // package private
{
    /*
     * Don't create an instance of this class.
     */
    private PasswordEncoder() {}
    
    
    public static String toHashValue(String s)
        throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        if(s == null)
            throw new IllegalArgumentException();
        
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte[] defaultBytes = s.getBytes("UTF-8");
        algorithm.update(defaultBytes);
        byte[] bytes = algorithm.digest();
        return HexBin.encode(bytes);
    }
}
