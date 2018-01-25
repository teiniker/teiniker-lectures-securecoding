package org.se.lab;

public class AnonymousClass
{

	public static void main(String... args)
	{
		
		Thread t = new Thread(new Runnable() {
			public void run()
			{
				System.out.println("Hello from thread " + Thread.currentThread().getId());
			}
		});
		
		t.start();		
	}

}
