package org.se.lab.join;

public class BusyTask
	implements Runnable 
{
	private final int times;
	private final String name;
	
	public BusyTask(String name, int times)
	{
		if(name == null)
			throw new NullPointerException();
		if(times < 0)
			throw new IllegalArgumentException();
		
		this.name = name;
		this.times = times;
	}
	
	
	public void run()
	{
		System.out.println(getClass().getName() + ": " + name + " - start");
		try
		{
			busyWait();
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


	private long busyWait() throws InterruptedException
	{
		long sum = 0;
		for(int j = 0; j < times; j++)
		{
			for(int i =0; i< Integer.MAX_VALUE; i++)
			{
				if(Thread.interrupted())
					throw new InterruptedException();
				sum += 1;
			}
		}
		return sum;
	}
}
