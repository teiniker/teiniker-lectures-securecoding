package org.se.lab;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Assert;
import org.junit.Test;

/*
 * The URLCodec class Implements the 'www-form-urlencoded' 
 * encoding scheme, also known as URL encoding.
 */

public class URLTest
{
	private final URLCodec codec = new URLCodec();

	@Test
	public void testStringToURL() throws EncoderException
	{
		String s = "app?path=\\..\\..\\home&username=homer";
	
		String urlString = codec.encode(s);
		Assert.assertEquals("app%3Fpath%3D%5C..%5C..%5Chome%26username%3Dhomer", urlString);
	}

	
	@Test
	public void testURLToString() throws DecoderException
	{
		String urlString = "app%3Fpath%3D%5C..%5C..%5Chome%26username%3Dhomer";
			
		String s = codec.decode(urlString);
		
		Assert.assertEquals("app?path=\\..\\..\\home&username=homer", s);
	}
}
