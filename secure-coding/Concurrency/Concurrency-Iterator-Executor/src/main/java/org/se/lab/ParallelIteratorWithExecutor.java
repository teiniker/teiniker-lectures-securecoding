package org.se.lab;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelIteratorWithExecutor
{	
	
	public static void execute(List<String> list, Class<? extends Algorithm> clazz, int n)
	{	
		if(n > list.size())
			throw new IllegalArgumentException("# threads exceeds # items in list");
		
		int elementsPerThread = list.size() / n;
		
		try
		{
			ExecutorService executor = Executors.newFixedThreadPool(n);

			for(int i = 0; i < n; i++)
			{
				int from = i * elementsPerThread;
				int to = from + elementsPerThread; 

				// if last thread, fix eventual rounding-errors.
				if (i == (n - 1))
				{
					to = list.size();
				}
				
				Algorithm algorithm = clazz.newInstance();
				algorithm.init(list, from, to);				
				executor.submit(algorithm);
			}
			
			executor.shutdown();
			executor.awaitTermination(1, TimeUnit.MINUTES);
		}
		catch(IllegalAccessException e)
		{
			throw new RuntimeException("Can't access newInstance()!", e);
		}
		catch(InterruptedException e)
		{
			throw new RuntimeException("Executor interrupted!", e);
		}
		catch(InstantiationException e)
		{
			throw new RuntimeException("Can't create runnable object!", e);
		}
	}
}
