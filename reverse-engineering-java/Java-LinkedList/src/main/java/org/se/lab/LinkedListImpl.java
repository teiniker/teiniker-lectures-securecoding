package org.se.lab;

public class LinkedListImpl
	implements LinkedList
{
	private Node list = null;
	
	@Override
	public void append(Integer value)
	{
		Node newNode = new Node(value, null);
		if(list == null)
		{
			list = newNode;
		}
		else
		{
			Node tmp = list;
			while(tmp.getNext() != null)
			{
				tmp = tmp.getNext();
			}
			tmp.setNext(newNode);
		}
	}

	
	@Override
	public void prepend(Integer value)
	{
		Node newNode = new Node(value, null);
		if(list != null)
		{
			newNode.setNext(list);
		}
		list = newNode;
	}

	
	@Override
	public Integer get(int index)
	{
		if(list == null)
			return null;
		
		Node tmp = list;
		for(int i=0; i<index; i++)
		{
			if(tmp.getNext() != null)
				tmp = tmp.getNext();
		}
		return tmp.getValue();
	}

	
	@Override
	public int length()
	{
		if(list == null)
			return 0;
		
		int length = 1;
		Node tmp = list;
		while(tmp.getNext() != null)
		{
			length++;
			tmp = tmp.getNext();
		}

		return length;
	}

	
	@Override
	public void removeAll()
	{
		list = null;
	}
}
