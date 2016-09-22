package org.se.lab.sleep;

import org.se.lab.util.StopWatch;

public class SleepApp
{
	public static void main(String[] args) throws InterruptedException
	{
		StopWatch watch = new StopWatch();
		watch.start();
		waitSuspended();
		watch.stop();
		System.out.println("> " + watch + " sec");
	}

	private static void waitSuspended()
	{
		try
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}		
	}

}
