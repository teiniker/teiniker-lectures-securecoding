package org.se.lab;

public class EMail
	implements Comparable<EMail>
{
	/*
	 * Constructors
	 */
	public EMail(String address)
	{
	    setAddress(address);
	}


	/*
	 * Property: address:String
	 */
	private String address;
	public final String getAddress()
	{
		return address;
	}
	public final void setAddress(String address)
	{
        if(address == null)
            throw new IllegalArgumentException("address");

        this.address = address;	    
	}
	

	/*
	 * Object methods
	 */
	public String toString()
	{
		return getAddress();
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
		}
		else if (!address.equals(other.address))
			return false;
		return true;
	}

	@Override
	public int compareTo(EMail o)
	{
		return getAddress().compareTo(o.getAddress());
	}
}
