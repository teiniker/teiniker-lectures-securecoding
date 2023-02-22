package org.se.lab;

import java.io.UnsupportedEncodingException;
import java.security.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

public class AES128_CTR_Test
{
    private Cipher cipher;
    private SecretKey key;
    private IvParameterSpec iv;

    @Before
    public void setup()
            throws NoSuchPaddingException, NoSuchAlgorithmException, DecoderException
    {
        cipher = Cipher.getInstance("AES/CTR/NoPadding");
        System.out.println("block size: " + cipher.getBlockSize() + " bytes");

        String keyString = "9a1b447e49d037ad41c11032812eeca1";
        byte[] keyBytes =  Hex.decodeHex(keyString.toCharArray());
        key = new SecretKeySpec(keyBytes, "AES");
        System.out.println("key    : " + Hex.encodeHexString(key.getEncoded()));

        byte[] ivBytes = new byte[cipher.getBlockSize()];
        SecureRandom random = new SecureRandom();
        random.nextBytes(ivBytes);
        iv = new IvParameterSpec(ivBytes);
        System.out.println("iv    : " + Hex.encodeHexString(iv.getIV()) + " bytes: " + iv.getIV().length);
    }


	@Test
	public void testSymmetricCipher()
            throws InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException, InvalidAlgorithmParameterException,
            UnsupportedEncodingException
    {
		String message = "This message should not be read!";
		byte[] plainText = message.getBytes("UTF-8");
		System.out.println("Message: " + Hex.encodeHexString(plainText));

        // Encryption
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(plainText);
		System.out.println("cipher: " + Hex.encodeHexString(cipherText) + " bytes: " + cipherText.length);
		
		
		// Decryption
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText2 = cipher.doFinal(cipherText);
		System.out.println("plain : " + Hex.encodeHexString(plainText2) + " bytes: " + plainText2.length);
	}


	@Test
    public void testGenerateKey() throws NoSuchAlgorithmException
    {
        SecretKey key = KeyGenerator.getInstance("AES").generateKey();
        System.out.println("key   : " + Hex.encodeHexString(key.getEncoded()) + " bytes: " + key.getEncoded().length);
    }

}
