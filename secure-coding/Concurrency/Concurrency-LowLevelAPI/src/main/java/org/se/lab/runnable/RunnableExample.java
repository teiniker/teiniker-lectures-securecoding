package org.se.lab.runnable;

public class RunnableExample
	implements Runnable
{

	@Override
	public void run()
	{
		System.out.println("run() - begin: " + Thread.currentThread().getId());
		countIntegers();
		System.out.println("run() - end  : " + Thread.currentThread().getId());
	}

	private static long countIntegers()
	{
		long sum = 0;
		for(int i=0; i< Integer.MAX_VALUE; i++)
		{
			sum++;
		}
		return sum;
	}


	/*
	 * Start some threads
	 */
	public static void main(String... args)
	{
		System.out.println("main() - begin");
		Thread t1 = new Thread(new RunnableExample());
		Thread t2 = new Thread(new RunnableExample());
		Thread t3 = new Thread(new RunnableExample());
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("main() - end");
	}
}
