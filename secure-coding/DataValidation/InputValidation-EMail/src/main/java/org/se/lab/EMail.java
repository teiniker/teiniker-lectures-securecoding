package org.se.lab;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EMail
{
	/*
	 * Constructor
	 */
	public EMail(String address)
	{
		// check for null pointer
		if(address == null)
			throw new IllegalArgumentException("Address is null!");
		
		// validate address format
		String s = Normalizer.normalize(address, Form.NFKC);
		Matcher m = ADDRESS_PATTERN.matcher(s);
		if(!m.matches())
			throw new IllegalArgumentException("Invalid address!");
			
		// store address
		this.address = address;
	}
	
	
	/*
	 * Property: address:String
	 */
	private final String address;
	private final static Pattern ADDRESS_PATTERN = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
	public String getAddress()
	{
		return address;
	}
	

	
	/*
	 * Object methods
	 */
	
	@Override
	public String toString()
	{
		return address;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		EMail other = (EMail) obj;
		if (address == null)
		{
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		return true;
	}
}
