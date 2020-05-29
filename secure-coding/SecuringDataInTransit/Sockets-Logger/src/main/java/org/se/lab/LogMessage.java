package org.se.lab;

import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

public class LogMessage
	implements Comparable<LogMessage>
{
	/*
	 * Constants
	 */
	
	private final static Format FORMATTER = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	
	/*
	 * Constructor
	 */
	public LogMessage(long timestamp, Level level, String text)
	{
		if(timestamp < 0)
			throw new IllegalArgumentException();
		if(level == null)
			throw new IllegalArgumentException();
		if(text == null || text.trim().length() == 0)
			throw new IllegalArgumentException();

		this.timestamp = timestamp;
		this.level = level;
		this.text = text;
	}
	
	
	/*
	 * Property: timestamp
	 */
	private final long timestamp;
	public long getTimestamp()
	{
		return timestamp;
	}


	/*
	 * Property: level:Level
	 */
	private final Level level;

	public Level getLevel()
	{
		return level;
	}
	
	
	/*
	 * Property: text:String
	 */
	private final String text;

	public String getText()
	{
		return text;
	}
	
	
	/*
	 * Object methods
	 */
	
	public String toString()
	{
		
		return "[" + FORMATTER.format(new Date(getTimestamp())) + "] " + getLevel() + " - " + getText();  
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
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
		LogMessage other = (LogMessage) obj;
		if (timestamp != other.timestamp)
			return false;
		return true;
	}


	@Override
	public int compareTo(LogMessage m)
	{
		if(m.getTimestamp() == getTimestamp())
			return 0;
		if(m.getTimestamp() < getTimestamp())
			return 1;
		else
			return -1;
	}
}
