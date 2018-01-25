package org.se.lab;

public class LambdaExpression
{

//	@FunctionalInterface
//	public interface Runnable 
//	{
//	    public abstract void run();
//	}

	public static void main(String... args)
	{
		Thread t = new Thread(() -> System.out.println("Hello from thread " + Thread.currentThread().getId()));
		t.start();	
	}

}
