package org.se.lab;

public interface LinkedList<E>
{
	void append(E value);
	void prepend(E value);
	E get(int i);
	int length();
	void removeAll();
}
