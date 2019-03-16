package org.se.lab;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;


public class HMACTest
{
	@Test
	public void testHMacSHA256()
            throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, DecoderException
    {
		String message = "This message should not be changed!";
		byte[] inputBytes = message.getBytes("UTF-8");
		System.out.println("Message: " + Hex.encodeHexString(inputBytes));

        String key = "d77cc40cf67845a619bcee9113093780c843fadf252db07a5fa87fec7bd8c385";
        byte[] keyBytes =  Hex.decodeHex(key.toCharArray());
        Key hmacKey = new SecretKeySpec(keyBytes, "HmacSHA256");
        System.out.println("key    : " + Hex.encodeHexString(hmacKey.getEncoded()));

		Mac hmac = Mac.getInstance("HmacSHA256");
		hmac.init(hmacKey);
		hmac.update(inputBytes);
		byte[] macBytes = hmac.doFinal();
		System.out.println("HMAC   : " + Hex.encodeHexString(macBytes));
	}



	@Test
    public void testGenerateKey()
            throws NoSuchAlgorithmException
    {
        // Generate a random secret key
        Key hmacKey = KeyGenerator.getInstance("HmacSHA256").generateKey();
        System.out.println("key       : " + Hex.encodeHexString(hmacKey.getEncoded()));
    }
}
