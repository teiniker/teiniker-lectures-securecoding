package org.se.lab;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

/*
 * A Pseudo-Random Number Generator (PRNG) is an algorithm used to 
 * generate numbers that approximate true randomness. 
 * PRGN approximate randomness by using a seed from which subsequent 
 * values are generated.
 * 
 * When using the SecureRandom class you must also ensure that the 
 * algorithm used by the underlying provider is a cryptographically 
 * strong algorithm like SHA1PRNG.
 */
public class SecureRandomTest
{
	/*
	 * On Windows with the Oracle JRE and the default configuration 
	 * the SHA1PRNG generator is used.
	 * 
	 * On Linux with the Oracle JRE and default configuration the 
	 * NativePRNG algorithm is used. This algorithm provides the 
	 * output of the /dev/urandom PRNG that is provided by the OS. 
	 */
	@Test
	public void testPRNGType()
	{
		SecureRandom random = new SecureRandom();
				
		System.out.println(random.getAlgorithm());
	}
	
	
	/*
	 * If we need to ensure that the same PRNG is used no matter 
	 * where the code is running, then we have to explicitly specify 
	 * the algorithm using the getInstance() method.
	 */	
	@Test
	public void testOtherPRNGType() throws NoSuchAlgorithmException
	{
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
				
		Assert.assertEquals("SHA1PRNG", random.getAlgorithm());
	}
	
	
	/*
	 * To actually retrieve random data from SecureRandom, the 
	 * nextBytes(byte[]) method can be used to fill the input byte 
	 * array with the specified number of random bytes.
	 */
	@Test
	public void testNextBytes()
	{
		SecureRandom random = new SecureRandom();
		
		byte bytes[] = new byte[20];
	    random.nextBytes(bytes);
		
	    String hexString = Hex.encodeHexString(bytes);		    
	    System.out.println(hexString);
	}
}
