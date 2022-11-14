package org.se.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
		this.data = new ArrayList<>();
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
		List<String> result = new ArrayList<>();
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
		return "Message[" + "id=" + id + ", data=" + data + ']';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Message message = (Message) o;
		if (id != message.id) return false;
		return Objects.equals(data, message.data);
	}

	@Override
	public int hashCode()
	{
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (data != null ? data.hashCode() : 0);
		return result;
	}
}
