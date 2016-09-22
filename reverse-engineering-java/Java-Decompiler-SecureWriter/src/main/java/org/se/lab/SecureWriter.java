package org.se.lab;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecureWriter
{
	private static Cipher cipher; 
	private static SecretKey key;

	public static void main(String... args)
	{
		if(args.length == 0)
		{
			System.out.println("Usage: java -cp ./build org.se.lab.SecureWriter <text>");
			System.exit(0);
		}
		
		try
		{
			key = KeyGenerator.getInstance("AES").generateKey();
			cipher = Cipher.getInstance("AES");
			
			byte[] message = encrypt(args[0]);
			String text = Utility.convertToHexString(message);			
			System.out.println(text);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	
	/*
	 * Utility methods
	 */
	
	private static byte[] encrypt(String input) throws InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException
	{
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] inputBytes = input.getBytes();
		return cipher.doFinal(inputBytes);
	}
}

