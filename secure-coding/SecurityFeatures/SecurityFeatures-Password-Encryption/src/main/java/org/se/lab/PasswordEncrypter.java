package org.se.lab;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class PasswordEncrypter 
{
	public String encryptPassword(String password)
	{
		try
		{
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			byte[] salt = new byte[16];
			random.nextBytes(salt);
	
			byte[] result = encryptPasswordWithSalt(password.getBytes("UTF-8"), salt);
			return Base64.encodeBase64String(result);
		}
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
		{
			throw new IllegalStateException(e);
		}
	}
	
	
	public boolean checkPassword(String password, String hashString)
	{
		try
		{	
			byte[] result = Base64.decodeBase64(hashString);			
			byte[] salt = Arrays.copyOfRange(result, 0, 16);
		
			byte[] encryptedPassword = encryptPasswordWithSalt(password.getBytes("UTF-8"), salt);
			return Arrays.equals(result, encryptedPassword);
		}
		catch (UnsupportedEncodingException e)
		{
			throw new IllegalStateException(e);
		}
	}

	
	private byte[] encryptPasswordWithSalt(byte[] password, byte[] salt)
	{
		// hash = MessageDigest(password+salt
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt);
			md.update(password);
			byte[] hash = md.digest();
			
			// result = hash+salt		
			byte[] result = new byte[hash.length+salt.length];						
			System.arraycopy(salt, 0, result, 0, salt.length);
			System.arraycopy(hash, 0, result, salt.length, hash.length);			

			System.out.println("hash  : " + Hex.encodeHexString(hash) + " " + hash.length + " bytes ");
			System.out.println("salt  : " + Hex.encodeHexString(salt) + " " + salt.length + " bytes ");
			System.out.println("result: " + Hex.encodeHexString(result) + " " + result.length + " bytes ");
			
			return result;
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new IllegalStateException(e);
		}		
	}	
}
