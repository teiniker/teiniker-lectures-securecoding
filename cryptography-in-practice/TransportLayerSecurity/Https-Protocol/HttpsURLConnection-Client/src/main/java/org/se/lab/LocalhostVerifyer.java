package org.se.lab;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/*
 * Java by default verifies that the certificate CN (Common Name) is the same 
 * as host name in the URL. If the CN in the certificate is not the same as 
 * the host name, your web service client fails.
 * 
 * So, a valid solution would be create an implementation of HostnameVerifier 
 * that returns ok for localhost, regardless of the certificate.
 */
public class LocalhostVerifyer implements HostnameVerifier
{
	public boolean verify(String hostname, SSLSession sslSession)
	{
		if (hostname.equals("localhost"))
		{
			return true;
		}
		return false;
	}
}
