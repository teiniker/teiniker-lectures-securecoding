package org.se.lab.guardedblocks;

public class Consumer implements Runnable
{
	private Buffer buffer;

	public Consumer(Buffer buffer)
	{
		if (buffer == null)
			throw new NullPointerException();
		this.buffer = buffer;
	}
	
	public void run()
	{
		String message;
		do
		{
			message = buffer.receiveMessage(); 
			System.out.format("MESSAGE RECEIVED: %s\n", message);
			try
			{
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) {}
		}while(!message.equals("DONE")); 
	}	
}
