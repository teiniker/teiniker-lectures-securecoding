package org.se.lab.collections;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable
{
	private final BlockingQueue<String> sharedQ;	
	public Consumer(BlockingQueue<String> sharedQ)
	{
		this.sharedQ = sharedQ;
	}	

	@Override
	public void run()
	{
		String message = null;
		do
		{
			try
			{
				message = sharedQ.take(); 
				System.out.format("MESSAGE RECEIVED: %s\n", message);
				
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {}
		}while(!message.equals("DONE")); 
	}
}
