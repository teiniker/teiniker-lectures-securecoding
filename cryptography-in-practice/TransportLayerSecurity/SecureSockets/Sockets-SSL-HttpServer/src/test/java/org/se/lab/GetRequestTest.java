package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GetRequestTest
	extends AbstractHttpClientTest
{
	@Test
	public void testIndex() throws MalformedURLException
	{
		URL url = new URL("http://localhost:8080/index.html");
		String response = httpGetRequest(url);
		System.out.println(response);
	}

	@Test
	public void testTest() throws MalformedURLException
	{
		URL url = new URL("http://localhost:8080/test.html");
		String response = httpGetRequest(url);
		System.out.println(response);
	}

    @Test
    public void test404() throws MalformedURLException
    {
        URL url = new URL("http://localhost:8080/unknown.html");
        String response = httpGetRequest(url);
        System.out.println(response);
    }

}
