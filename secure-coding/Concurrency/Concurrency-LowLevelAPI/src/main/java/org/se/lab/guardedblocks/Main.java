package org.se.lab.guardedblocks;

public class Main
{
	public static void main(String[] args)
	{
		 Buffer buffer = new Buffer();
	     (new Thread(new Producer(buffer))).start();
	     (new Thread(new Consumer(buffer))).start();
	}
}
