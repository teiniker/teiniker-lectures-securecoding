package org.se.lab.sleep;

import org.se.lab.util.StopWatch;

public class BusyApp
{
	public static void main(String[] args)
	{
		StopWatch watch = new StopWatch();
		watch.start();
		waitBusy();
		watch.stop();
		System.out.println("> " + watch + " sec");
	}

	private static long waitBusy()
	{
		long sum = 0;
		for(int i =0; i< Integer.MAX_VALUE; i++)
		{
			sum += 1;
		}
		return sum;
	}
}
