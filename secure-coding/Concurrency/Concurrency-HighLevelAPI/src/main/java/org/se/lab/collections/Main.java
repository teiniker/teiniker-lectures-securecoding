package org.se.lab.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main
{
	public static void main(String args[])
	{
		BlockingQueue<String> sharedQ = new LinkedBlockingQueue<String>();

		(new Thread(new Producer(sharedQ))).start();
		(new Thread(new Consumer(sharedQ))).start();
	}
}
