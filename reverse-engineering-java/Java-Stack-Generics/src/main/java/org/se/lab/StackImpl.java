package org.se.lab;

public class StackImpl<E>
	implements Stack<E>
{
	private Node<E> stack = null;
	
	
	@Override
	public void push(E value)
	{
		Node<E> newNode = new Node<E>(value, null);
		if(stack != null)
		{
			newNode.setNext(stack);
		}
		stack = newNode;
	}

	
	@Override
	public E pop()
	{
		if(stack == null)
			return null;
		
		Node<E> tmp = stack;
		stack = tmp.getNext();

		return tmp.getValue();
	}

	
	@Override
	public int size()
	{
		if(stack == null)
			return 0;
		
		int size = 1;
		Node<E> tmp = stack;
		while(tmp.getNext() != null)
		{
			size++;
			tmp = tmp.getNext();
		}
		
		return size;
	}
}
