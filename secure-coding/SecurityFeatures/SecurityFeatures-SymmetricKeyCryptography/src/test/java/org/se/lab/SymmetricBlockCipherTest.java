package org.se.lab;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

public class SymmetricBlockCipherTest
{			
	@Test
	public void testAES_CTR() 
		throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException 
	{
		byte[] input = new byte[]
		{
			0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07,
			0x08,0x09,0x0a,0x0b,0x0c,0x0d,0x0e,0x0f,
			0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07			
		};
				
		byte[] ivBytes = new byte[16]; // Cipher block size
		SecureRandom random = new SecureRandom();
		random.nextBytes(ivBytes);
		
		System.out.println("input : " + Hex.encodeHexString(input) + " bytes: " + input.length);
		
		
		// Setup
		SecretKey key = KeyGenerator.getInstance("AES").generateKey();
		System.out.println("key   : " + Hex.encodeHexString(key.getEncoded()) + " bytes: " + key.getEncoded().length);

		IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		System.out.println("iv    : " + Hex.encodeHexString(ivSpec.getIV()) + " bytes: " + ivSpec.getIV().length);
		
		Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");		
//		Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding", "BC");		
		System.out.println("block size: " + cipher.getBlockSize() + " bytes");	

		
		// Encryption
		cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
		
		byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
	
		int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
		ctLength += cipher.doFinal(cipherText, ctLength);
		System.out.println("cipher: " + Hex.encodeHexString(cipherText) + " bytes: " + ctLength);
		
		
		// Decryption
		cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
		
		byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
		
		int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);
		ptLength += cipher.doFinal(plainText, ptLength);
		System.out.println("plain : " + Hex.encodeHexString(plainText) + " bytes: " + ptLength);
	}

}
