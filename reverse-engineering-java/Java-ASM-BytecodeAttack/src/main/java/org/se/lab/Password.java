package org.se.lab;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class Password
{
	public Password(String plainPassword)
	{
		byte[] bytes = null;
	
		// System.out.println(plainPassword);
		
		try
		{
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			algorithm.update(plainPassword.getBytes("UTF-8"));
			bytes = algorithm.digest();
	
		} 
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
		{
			throw new IllegalStateException("Can't calculate hash value!", e);
		} 
		password = Hex.encodeHexString(bytes);
	}


	private final String password;


	public String getPassword()
	{
		return password;
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Password other = (Password) obj;
		if (password == null)
		{
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


	@Override
	public String toString()
	{
		return "Password [password=" + password + "]";
	}
}
