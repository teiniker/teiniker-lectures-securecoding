package org.se.lab;

public class LinkedListImpl<E>
	implements LinkedList<E>
{
	private Node<E> list = null;
	
	@Override
	public void append(E value)
	{
		Node<E> newNode = new Node<E>(value, null);
		if(list == null)
		{
			list = newNode;
		}
		else
		{
			Node<E> tmp = list;
			while(tmp.getNext() != null)
			{
				tmp = tmp.getNext();
			}
			tmp.setNext(newNode);
		}
	}

	
	@Override
	public void prepend(E value)
	{
		Node<E> newNode = new Node<E>(value, null);
		if(list != null)
		{
			newNode.setNext(list);
		}
		list = newNode;
	}

	
	@Override
	public E get(int index)
	{
		if(list == null)
			return null;
		
		Node<E> tmp = list;
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
		Node<E> tmp = list;
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
