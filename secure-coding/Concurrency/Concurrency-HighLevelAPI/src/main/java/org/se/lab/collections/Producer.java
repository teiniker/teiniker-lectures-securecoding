package org.se.lab.collections;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable
{
	private final BlockingQueue<String> sharedQ;
	
	public Producer(BlockingQueue<String> sharedQ)
	{
		this.sharedQ = sharedQ;
	}
	  
	@Override
	public void run()
	{
		String importantInfo[] =
		{ 
			"Eins", 
			"Zwei", 
			"Drei",
			"Vier",
			"DONE"
		};

		for (int i = 0; i < importantInfo.length; i++)
		{
			try 
			{
				sharedQ.put(importantInfo[i]);
			} 
			catch (InterruptedException e) 
			{
			}
        }
	}
}
