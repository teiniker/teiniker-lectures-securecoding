package org.se.lab;

import org.junit.Assert;
import org.junit.Test;
import org.owasp.encoder.Encode;


public class EncoderTest
{
	@Test
	public void testForHtmlContent()
	{
		String html = Encode.forHtmlContent("<script>");
		
		Assert.assertEquals("&lt;script&gt;", html);
	}
	
// https://www.owasp.org/index.php/OWASP_Java_Encoder_Project#tab=Use_the_Java_Encoder_Project	
// public static String forHtmlAttribute(String input)
// public static String forCssString(String input) 
//  public static String forCssUrl(String input)
// public static String forUriComponent(String input)
// public static String forJavaScript(String input)
// public static String forJavaScriptAttribute(String input) 
	
	
// public static String forXmlContent(String input)
// public static String forXmlAttribute(String input)
// public static String forXmlComment(String input) 
// public static String forCDATA(String input)
	
}
