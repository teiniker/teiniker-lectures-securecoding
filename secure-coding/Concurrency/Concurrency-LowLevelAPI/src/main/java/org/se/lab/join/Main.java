package org.se.lab.join;

import java.io.IOException;


/*
 * The join method allows one thread to wait for the completion of another.
 * If t is a Thread object whose thread is currently executing, t.join();
 * causes the current thread to pause execution until t's thread terminates.
 * 
 * join is dependent on the OS for timing, so you should not assume that 
 * join will wait exactly as long as you specify.
 * 
 * Like sleep, join responds to an interrupt by exiting with an 
 * InterruptedException.
 */
public class Main
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.out.println("program begin");
		
		Thread t1 = new Thread(new SleepTask("task A", 10000));		
		t1.start();
		
		Thread t2 = new Thread(new SleepTask("task B", 3000));		
		t2.start();
		
		t2.join();
		t1.join();
		
		System.out.println("program end");
	}
	
}
