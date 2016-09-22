package org.se.lab;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;


public class HMACTest
{
    private Key hmacKey;
    
    @Before
    public void setup() throws NoSuchAlgorithmException
    {
        hmacKey = KeyGenerator.getInstance("HmacSHA1").generateKey();
        // new SecretKeySpec(key.getBytes(), "HmacSHA1"); // String key
    }
    
	@Test
	public void testHMac() 
		throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException
	{
		String message = "Hello KBerg!"; 		
		byte[] inputBytes = message.getBytes("UTF-8");
		System.out.println("inputBytes: " + Hex.encodeHexString(inputBytes));
		
		Mac hmac = Mac.getInstance("HmacSHA1");		
		hmac.init(hmacKey);
		hmac.update(inputBytes);
		byte[] macBytes = hmac.doFinal();

		System.out.println("macBytes  : " + Hex.encodeHexString(macBytes));
	}

}
