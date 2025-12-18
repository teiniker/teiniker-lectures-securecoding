package org.se.lab;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;

public abstract class AbstractHttpClientTest 
{
	protected Logger logger = Logger.getLogger(this.getClass());
	
	protected Proxy PROXY;
	protected String HOST;
	protected String PORT;

	@Before
	public void setup() throws IOException
	{
		// read connection settings
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/test/resources/http.properties"));
		HOST = properties.getProperty("http.host");
		PORT = properties.getProperty("http.port");
		logger.debug("Connect to " + HOST + ":" + PORT);
		
		// configure proxy
		String proxyAddress = properties.getProperty("http.proxy.address");
		String proxyPort = properties.getProperty("http.proxy.port");
		if(proxyAddress != null && proxyPort != null)
		{
			logger.debug("Use proxy " + proxyAddress + ":" + proxyPort);
			int port = Integer.parseInt(proxyPort);
			PROXY = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyAddress, port));
		}
		else
		{
			PROXY = Proxy.NO_PROXY;
		}
	}
	
	
	public String httpGetRequest(URL url)
	{
		HttpURLConnection connection = null;
		try
		{
			connection = (HttpURLConnection) url.openConnection(PROXY);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "text/html");
			logger.debug("URL: " + url);
			logger.debug("Request-Method: " + connection.getRequestMethod());
	
			// read response
			int httpResponseCode = connection.getResponseCode();			
			logger.debug("Response-Code: " + httpResponseCode);
			logger.debug("Response-Content-Length:" + connection.getContentLength());
			
			String content;
			if(httpResponseCode >= 400)
			{				
				content = readResponseContent(connection.getErrorStream());				
				throw new HttpClientException("Invalid HTTP response!", url,  
						connection.getResponseCode(), content);
			}
	        
	        content = readResponseContent(connection.getInputStream()); 
	        return content.toString();
		}
		catch (IOException e)
		{
			throw new HttpClientException("IO problems", e);
		}		
		finally
		{
			if(connection != null)
				connection.disconnect();
		}
	}

	
	public String httpPostRequest(URL url, String requestContent)
	{
		HttpURLConnection connection = null;
		try
		{
			// send request
			connection = (HttpURLConnection) url.openConnection(PROXY);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Accept", "text/html");
			logger.debug("URL: " + url);
			logger.debug("Request-Method: " + connection.getRequestMethod());		
			logger.debug("Request-Content:\n" + requestContent);
			OutputStreamWriter w = new OutputStreamWriter(connection.getOutputStream());
			w.write(requestContent);
			w.flush();
			w.close();
			
			// receive response
			int httpResponseCode = connection.getResponseCode();
			logger.debug("Response-Code: " + httpResponseCode);
			logger.debug("Response-Content-Length:" + connection.getContentLength());

			String content;
			if(httpResponseCode >= 400)
			{				
				content = readResponseContent(connection.getErrorStream());				
				throw new HttpClientException("Invalid HTTP response!", url,  
						connection.getResponseCode(), content);
			}
	        
	        content = readResponseContent(connection.getInputStream()); 
	        return content.toString();
		}
		catch (IOException e) 
		{
			logger.debug("IO problems", e);
			throw new HttpClientException("IO problems", e);
		}
		finally
		{
			if(connection != null)
				connection.disconnect();
		}
	}

	
	protected String readResponseContent(InputStream in) 
		throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        StringBuffer content = new StringBuffer();
        while((line=reader.readLine()) != null)
        {
        	content.append(line).append("\n");
        }
        logger.debug("Response-Content:\n" + content.toString());
        return content.toString();
	}
}
