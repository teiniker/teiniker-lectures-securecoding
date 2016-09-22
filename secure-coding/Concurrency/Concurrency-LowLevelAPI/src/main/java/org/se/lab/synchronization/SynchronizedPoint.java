package org.se.lab.synchronization;

public class SynchronizedPoint
{
	private int x;
	private int y;
	private String name;
	
	public SynchronizedPoint(int x, int y, String name)
	{
		check(x, y, name);
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public void setPoint(int x, int y, String name)
	{
		check(x, y, name);
		synchronized(this)
		{
			this.x = x;
			this.y = y;
			this.name = name;
		}
	}
	
	synchronized public void invert()
	{
		x = -x;
		y = -y;
		name = "inverse of " + name;
	}
	
	synchronized public String toString()
	{
		return "(" + name + ":" + x + ";" + y + ")";
	}
		
	private void check(int x, int y, String name)
	{
		if(x < -100 || x > 100)
			throw new IllegalArgumentException();
		if(y < -100 || y > 100)
			throw new IllegalArgumentException();
		if(name == null)
			throw new NullPointerException();
	}
}
