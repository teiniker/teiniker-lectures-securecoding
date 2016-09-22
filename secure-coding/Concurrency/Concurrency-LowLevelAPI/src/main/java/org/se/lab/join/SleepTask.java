package org.se.lab.join;

/*
 * Thread.sleep causes the current thread to suspend execution for a 
 * specified period. This is an efficient means of making processor 
 * time available to the other threads of an application or other 
 * applications that might be running on a computer system.
 * 
 * However, these sleep times are not guaranteed to be precise, because 
 * they are limited by the facilities provided by the underlying OS.
 * 
 * Many methods that throw InterruptedException, such as sleep, are 
 * designed to cancel their current operation and return immediately 
 * when an interrupt is received.
 */

public class SleepTask
	implements Runnable 
{
	private final int interval;
	private final String name;
	
	public SleepTask(String name, int interval)
	{
		if(name == null)
			throw new NullPointerException();
		if(interval < 0)
			throw new IllegalArgumentException();
		this.name = name;
		this.interval = interval;
	}
	
	
	public void run()
	{
		System.out.println(getClass().getName() + ": " + name + " - start");
		try
		{
			Thread.sleep(interval);
		} 
		catch (InterruptedException e)
		{
			System.out.println(getClass().getName() + ": " + name +  " - interrupted");
		}		
		finally
		{
			System.out.println(getClass().getName() + ": " + name +  " - stop");
		}
	}
}
