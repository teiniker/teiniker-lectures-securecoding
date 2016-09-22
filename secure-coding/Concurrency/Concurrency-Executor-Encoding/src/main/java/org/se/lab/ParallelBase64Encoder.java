package org.se.lab;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelBase64Encoder
{
	public static void encode(List<String> fileNameList, int numberOfThreads)
	{	
		try
		{
			ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
			
			for(String filename : fileNameList)
			{
				Runnable task = new EncodingTask(filename + ".jpg", filename + ".txt");
				executor.submit(task);
			}
			
			executor.shutdown();
			executor.awaitTermination(1, TimeUnit.MINUTES);
		}
		catch(InterruptedException e)
		{
			throw new RuntimeException("Executor interrupted.", e);
		}
	}
}
