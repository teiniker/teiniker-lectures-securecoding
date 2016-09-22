package org.se.lab;

import java.util.List;

public abstract class Algorithm 
	implements Runnable
{
	private List<String> list;
	private int from;
	private int to;

	public void init(List<String> list, int from, int to)
	{
		System.out.println("process sublist index: [" + from + "," + to + ")");

		if (list == null)
			throw new NullPointerException();
		if (from > to)
			throw new IllegalArgumentException("from > to");

		
		this.list = list;
		this.from = from;
		this.to = to;
	}

	public void run()
	{
		for(int i = from; i < to; i++)
		{
			String s = modifyElement(list.get(i));
			list.set(i, s);
		}
	}

	protected abstract String modifyElement(String s);
}