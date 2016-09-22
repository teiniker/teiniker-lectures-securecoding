package org.se.lab;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Iterator;

import org.junit.Test;

public class ProviderTest
{
	@Test
	public void testProviderInfo()
	{
		Provider[] providers = Security.getProviders();
		
		for(Provider p : providers)
		{
			System.out.println(p.getInfo());
		}
	}


	@Test
	public void testSHA1() throws NoSuchAlgorithmException
	{
		MessageDigest algorithm = MessageDigest.getInstance("SHA-1");	
		Provider provider = algorithm.getProvider();
		
		System.out.println(provider.getInfo());
	}

	
	@Test
	public void testSHA1WithNewProvider() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		MessageDigest algorithm = MessageDigest.getInstance("SHA-1", "BC");	
		Provider provider = algorithm.getProvider();
		
		System.out.println(provider.getInfo());
	}


	@Test
	public void testProviderCapabilities()
	{
		Provider provider = Security.getProvider("BC");
		
		Iterator<Object> it = provider.keySet().iterator();
		
		while(it.hasNext())
		{
			String entry = (String)it.next();
			
			if(entry.startsWith("Alg.Alias."))
			{
				entry = entry.substring("Alg.Alias.".length());
			}
			
			String factoryClass = entry.substring(0, entry.indexOf('.'));
			String name = entry.substring(factoryClass.length() + 1);
			
			System.out.println(factoryClass + ": " + name);
		}
	}
}
