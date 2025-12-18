package org.se.lab;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import org.apache.log4j.Logger;
import org.junit.Before;

public abstract class AbstractHttpsClientTest
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

		// read path to the used keystore file
		System.setProperty( "javax.net.ssl.trustStore", properties.getProperty("ssl.trustStore"));
		System.setProperty( "javax.net.ssl.trustStorePassword", properties.getProperty("ssl.trustStorePassword"));
		
		// configure proxy
		String proxyAddress = properties.getProperty("http.proxy.address");
		String proxyPort = properties.getProperty("http.proxy.port");
		if (proxyAddress != null && proxyPort != null)
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

	protected String httpsGetRequest(URL url)
	{
		HttpsURLConnection connection = null;
		try
		{
			HttpsURLConnection.setDefaultHostnameVerifier(new LocalhostVerifyer());

			connection = (HttpsURLConnection) url.openConnection(PROXY);
			printHttpsCert(connection);

			logger.debug("URL: " + url);
			logger.debug("Request-Method: " + connection.getRequestMethod());

			// read response
			int httpResponseCode = connection.getResponseCode();
			logger.debug("Response-Code: " + httpResponseCode);
			logger.debug("Response-Content-Length:"
					+ connection.getContentLength());

			String content;
			if (httpResponseCode >= 400)
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
			throw new HttpClientException("Can't execute GET request!", e);
		} 
		finally
		{
			if (connection != null)
				connection.disconnect();
		}
	}


	protected String httpsPostRequest(URL url, String requestContent)
	{
		HttpURLConnection connection = null;
		try
		{
			HttpsURLConnection.setDefaultHostnameVerifier(new LocalhostVerifyer());
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

	private void printHttpsCert(HttpsURLConnection con)
	{
		if (con != null)
		{
			try
			{
				logger.debug("Response Code : " + con.getResponseCode());
				logger.debug("Cipher Suite : " + con.getCipherSuite());

				Certificate[] certs = con.getServerCertificates();
				for (Certificate cert : certs)
				{
					logger.debug("Cert Type : " + cert.getType());
					logger.debug("Cert Hash Code : " + cert.hashCode());
					logger.debug("Cert Public Key Algorithm : " + cert.getPublicKey().getAlgorithm());
					logger.debug("Cert Public Key Format : " + cert.getPublicKey().getFormat());
				}
			} 
			catch(IOException e)
			{
                throw new HttpClientException("Can't print HTTPS certificate data!", e);
			} 
		}
	}

	protected String readResponseContent(InputStream in) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		StringBuffer content = new StringBuffer();
		while ((line = reader.readLine()) != null)
		{
			content.append(line).append("\n");
		}
		logger.debug("Response-Content:\n" + content.toString());
		return content.toString();
	}
}
