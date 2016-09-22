package org.se.lab;

public abstract class Entity
	implements XmlElement
{
	/*
	 * Static attribute
	 */
	private static int nextId = 1;

	protected static void setNextId(int i)
	{
		nextId = i;
	}

	protected int getNextId()
	{
		return nextId++;
	}
}
