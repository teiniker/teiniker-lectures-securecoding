package org.se.lab;

public class StackImpl
	implements Stack
{
	private Node stack = null;
	
	
	@Override
	public void push(Integer value)
	{
		Node newNode = new Node(value, null);
	
		if(stack != null)
		{
			newNode.setNext(stack);
		}
		stack = newNode;
	}

	
	@Override
	public Integer pop()
	{
		if(stack == null)
			return null;
		
		Node tmp = stack;
		stack = tmp.getNext();
	
		return tmp.getValue();
	}

	
	@Override
	public int size()
	{
		if(stack == null)
			return 0;
		
		int size = 1;
		Node tmp = stack;
		while(tmp.getNext() != null)
		{
			size++;
			tmp = tmp.getNext();
		}
		
		return size;
	}
}
