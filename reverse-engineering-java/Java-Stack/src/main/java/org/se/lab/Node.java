package org.se.lab;

public class Node
{
	/*
	 * Constructor
	 */
	public Node(Integer value, Node next)
	{
		setValue(value);
		setNext(next);
	}
	
	
	/*
	 * Properties:
	 */
		
	private Integer value;
	public Integer getValue()
	{
		return value;
	}
	public void setValue(Integer value)
	{
		this.value = value;
	}
	
	
	private Node next;
	public Node getNext()
	{
		return next;
	}
	public void setNext(Node next)
	{
		this.next = next;
	}
}
