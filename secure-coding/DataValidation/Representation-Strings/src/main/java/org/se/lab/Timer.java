package org.se.lab;

public class Timer
{
	/*
	 * Constructor
	 */
	public Timer(String name)
	{
		if(name == null || name.length() < 5)
			throw new IllegalArgumentException("name: " + name);
		this.name = name;
	}
	
	
	/*
	 * Timer states
	 */
	private String name;
	private long t0;
	private long t1;
	
	
	/*
	 * Timer methods
	 */
	
	public void reset()
	{
		t0 = t1 = 0;
	}
	
	public void start()
	{
		t0 = System.currentTimeMillis();
	}
	
	public void stop()
	{
		t1 = System.currentTimeMillis();
	}
	
	
	public long getMillis()
	{
		return t1-t0;
	}
	
	public String toString()
	{
		return name + ": " + getMillis() + " ms";
	}
}
