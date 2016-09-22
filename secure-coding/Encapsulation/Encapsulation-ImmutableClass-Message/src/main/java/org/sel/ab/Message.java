package org.sel.ab;

import java.util.ArrayList;
import java.util.List;

public final class Message
{
	/*
	 * Constructor
	 */
	public Message(long id, List<String> data)
	{
		if(id < 0)
			throw new IllegalArgumentException();
		if(data == null)
			throw new IllegalArgumentException();
		
		this.id = id;
	
		// create a deep copy of the data list
		this.data = new ArrayList<String>();
		for(String d : data)
			this.data.add(d);
	}
	
	
	/*
	 * Property: id:long
	 */
	private final long id;
	public long getId()
	{
		return id;
	}


	/*
	 * Property: data: String[*]
	 */
	private final List<String> data;
	public List<String> getData()
	{
		// create a deep copy of the data list
		List<String> result = new ArrayList<String>();
		for(String d : data)
			result.add(d);
				
		return result;	
	}
	
	
	/*
	 * Object methods
	 */
	
	@Override
	public String toString()
	{
		return getId() + ":" + getData().toString(); 
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Message other = (Message) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
