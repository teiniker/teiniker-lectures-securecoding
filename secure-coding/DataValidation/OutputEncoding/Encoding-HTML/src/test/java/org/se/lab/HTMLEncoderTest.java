package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class HTMLEncoderTest
{
	
	@Test
	public void testHtmlEncoding()
	{
		String html = HTMLEncoder.encodeForHTML("<script>");
		
		Assert.assertEquals("&lt;script&gt;", html);
	}

}
