package org.se.lab;

import org.junit.Test;



public class StringPerformanceTest
{
	private final int LOOP_COUNT = 50000;

	@Test
	public void testStringConcat()
	{
		Timer timer = new Timer("JUnit: testStringConcat()");
		timer.start();
		String s = "";
		for(int i = 0; i < LOOP_COUNT; i++)
		{
			s += "X";
		}
		timer.stop();

		System.out.println(s.length());
		System.out.println(timer);
	}


	@Test
	public void testStringBuilder()
	{
		Timer timer = new Timer("JUnit: testStringBuilder()");
		timer.start();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < LOOP_COUNT*100; i++)
		{
			sb.append("X");
		}
		timer.stop();

		String s = sb.toString();
		System.out.println(s.length());
		System.out.println(timer);
	}


	@Test
	public void testStringBuffer()
	{
		Timer timer = new Timer("JUnit: testStringBuffer()");
		timer.start();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < LOOP_COUNT*100; i++)
		{
			sb.append("X");
		}
		timer.stop();

		String s = sb.toString();
		System.out.println(s.length());
		System.out.println(timer);
	}
}
