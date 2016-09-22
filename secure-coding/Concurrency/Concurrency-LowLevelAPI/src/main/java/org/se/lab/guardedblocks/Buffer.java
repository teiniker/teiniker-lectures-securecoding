package org.se.lab.guardedblocks;

public class Buffer
{
    private String message;
    private boolean empty = true;

	public synchronized String receiveMessage()
	{
		while(empty)
		{
			try
			{
				wait();
			} 
			catch (InterruptedException e) {}
		}
		empty = true;
		notifyAll();
		return message;
	}

	public synchronized void sendMessage(String message)
	{
		while(!empty)
		{
			try
			{
				wait();
			} 
			catch (InterruptedException e) {}
		}
		empty = false;
		this.message = message;
		notifyAll();
	}
}
