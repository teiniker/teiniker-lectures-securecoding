package org.se.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;


/*
 * To generate a wordlist, we use crunch, a wordlist generator
 * (see http://sourceforge.net/projects/crunch-wordlist/)
 * 
 * This is the procedure from the downloaded tar ball to the
 * final word list:
 * 
 * tar -xvzf crunch-3.2.tgz 
 * cd crunch3.2/
 * make
 * ./crunch 4 4 -o wordlist.txt
 */

public class BruteForceTest
{
	@Test
	public void testCalculateMd5String() throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		final String passwd = "student";
	
		String hash = calculateMd5String(passwd);
		Assert.assertEquals("cd73502828457d15655bbd7a63fb0bc8", hash);
	}

	
	@Test
	public void testMd5Attack() throws NoSuchAlgorithmException, IOException
	{
		final String md5 = "54a8723466e5d487247f3d93d51c66bc";
		final String filename = "wordlist.txt";
			
		BufferedReader in = new BufferedReader(new FileReader(filename));			
		String line;	
		while((line = in.readLine()) != null)
		{
			String hash = calculateMd5String(line);
			if(hash.equals(md5))
			{
				System.out.println("Success, password is: " + line);
				break;
			}
		}
		in.close();
	}

	
	/*
	 * Helper methods
	 */
	
	private String calculateMd5String(final String message)
			throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		MessageDigest algorithm = MessageDigest.getInstance("MD5");		
		algorithm.update(message.getBytes("UTF-8"));
		byte[] bytes = algorithm.digest();
		return convertToHexString(bytes);
	}

	
	private String convertToHexString(byte[] bytes)
	{
		StringBuilder hex = new StringBuilder();
		for(byte b : bytes)
		{
			int i = (b & 0xff); // copy the byte bit pattern into int value
			hex.append(String.format("%02x", i));
		}
		return hex.toString();
	}
}
