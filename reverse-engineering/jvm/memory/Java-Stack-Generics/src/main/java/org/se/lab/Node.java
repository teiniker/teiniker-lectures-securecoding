package org.se.lab;

public class Node<E>
{
	/*
	 * Constructor
	 */
	public Node(E value, Node<E> next)
	{
		setValue(value);
		setNext(next);
	}
	
	
	/*
	 * Properties:
	 */
		
	private E value;
	public E getValue()
	{
		return value;
	}
	public void setValue(E value)
	{
		this.value = value;
	}
	
	
	private Node<E> next;
	public Node<E> getNext()
	{
		return next;
	}
	public void setNext(Node<E> next)
	{
		this.next = next;
	}
}
