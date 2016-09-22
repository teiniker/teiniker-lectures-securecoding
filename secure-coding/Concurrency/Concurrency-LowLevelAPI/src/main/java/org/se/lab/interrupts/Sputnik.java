package org.se.lab.interrupts;

/*
 * An interrupt is an indication to a thread that it should stop what it is 
 * doing and do something else. It's up to the programmer to decide exactly 
 * how a thread responds to an interrupt, but it is very common for the 
 * thread to terminate.
 */

public class Sputnik
	implements Runnable 
{
	private final String name;
	private final int interval;
	
	public Sputnik(String name, int interval)
	{
		if(name == null)
			throw new NullPointerException();
		if(interval < 0)
			throw new IllegalArgumentException("interval");

		this.name = name;
		this.interval = interval;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				System.out.println(name + ": peeep!");
				Thread.sleep(interval);
			}
		} 
		catch (InterruptedException e)
		{
			System.out.println(name + " interrupted.");
		}
	}
}
