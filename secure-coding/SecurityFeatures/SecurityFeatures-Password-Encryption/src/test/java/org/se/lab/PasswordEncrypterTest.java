package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PasswordEncrypterTest
{
	private PasswordEncrypter manager;
	
	@Before
	public void setup()
	{
		manager = new PasswordEncrypter();
	}

	@Test
	public void testCheckPasswords()
	{
		Assert.assertTrue(manager.checkPassword("Trink4Bier","vAC/2oo6CtpRA8Pw9SehaR3gUvtbD+6p0v46Q7bX1KX0amSZbeyzAp4Ze/H0FjDX"));
	}
	
	@Test
	public void testEncryptAndCheckPassword() 
	{
		// Note that encryptPassword always returns a different hash value 
		// because of the random salt 
		String hash = manager.encryptPassword("Trink4Bier");
		
		System.out.println(hash);
		
		Assert.assertTrue(manager.checkPassword("Trink4Bier", hash));
		Assert.assertFalse(manager.checkPassword("Trink2Bier", hash));
	}	
}
