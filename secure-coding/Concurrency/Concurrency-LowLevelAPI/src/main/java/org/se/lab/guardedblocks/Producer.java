package org.se.lab.guardedblocks;

public class Producer implements Runnable
{
	private Buffer buffer;

	public Producer(Buffer buffer)
	{
		if (buffer == null)
			throw new NullPointerException();
		this.buffer = buffer;
	}

	public void run()
	{
		String importantInfo[] =
		{ 
			"Eins", 
			"Zwei", 
			"Drei",
			"Vier" 
		};
		
		for (int i = 0; i < importantInfo.length; i++)
		{
			buffer.sendMessage(importantInfo[i]);
			try
			{
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
		}
		buffer.sendMessage("DONE");
	}
}
