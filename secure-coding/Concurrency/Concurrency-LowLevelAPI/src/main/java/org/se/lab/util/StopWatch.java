package org.se.lab.util;

public class StopWatch
{
	private long start;
	private long stop;
	
	public void start()
	{
		start = System.currentTimeMillis();
	}
	
	public void stop()
	{
		stop = System.currentTimeMillis();
	}
	
	public void reset()
	{
		start = stop = 0;
	}
	
	
	public long getTimeMillis()
	{
		return stop - start;
	}
	
	public double getTimeSecs()
	{
		return getTimeMillis()/1000.0;
	}

	@Override
	public String toString()
	{
		return String.format("%10.6f", getTimeSecs());
	}
}
