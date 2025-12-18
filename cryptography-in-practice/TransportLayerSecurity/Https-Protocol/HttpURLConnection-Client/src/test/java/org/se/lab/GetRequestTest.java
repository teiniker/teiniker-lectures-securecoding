package org.se.lab;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

public class GetRequestTest
	extends AbstractHttpClientTest
{
	@Test
	public void test() throws MalformedURLException 
	{
		URL url = new URL("http://localhost:8080/index.html");
		String response = httpGetRequest(url);
		
		Assert.assertTrue(response.contains("Online Translator"));
	}
}
