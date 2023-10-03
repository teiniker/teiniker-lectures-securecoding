package org.se.lab;

public interface Stack<E>
{
	void push(E value);
	E pop();
	int size();
}
