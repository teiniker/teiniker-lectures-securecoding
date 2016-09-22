package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ParallelIteratorWithThreads
{

	public static void execute(List<String> list, Class<? extends Algorithm> clazz, int n)
	{
		if(n > list.size())
			throw new IllegalArgumentException("Number of threads exceeds number of items in the list!");
		
		List<Thread> threads = new ArrayList<Thread>(n);
		int elementsPerThread = list.size() / n;

		try
		{
			for (int i = 0; i < n; i++)
			{
				Algorithm algorithm = clazz.newInstance();

				int from = i * elementsPerThread;
				int to = from + elementsPerThread; 

				// if last thread, fix eventual rounding-errors.
				if (i == (n - 1))
				{
					to = list.size();
				}

				// set data to algorithm (sublist depending on n)
				algorithm.init(list, from, to);

				// instantiate thread and start it right away
				Thread t = new Thread(algorithm);
				t.start();
				threads.add(t);
			}

			// join all threads
			// doesn't matter if later threads finish earlier than the previous
			// ones because joining has to be done for all of them anyway
			for (Thread t : threads)
			{
				try
				{
					t.join();
				} 
				catch (InterruptedException e)
				{
					System.out.println("Thread "
									+ t.getId()
									+ " threw InterruptedException during join()!");
				}
			}
		} 
		catch (InstantiationException e)
		{
			throw new RuntimeException("Can't create runnable object!", e);
		} 
		catch (IllegalAccessException e)
		{
			throw new RuntimeException("Can't access newInstance()!", e);
		}
	}
}