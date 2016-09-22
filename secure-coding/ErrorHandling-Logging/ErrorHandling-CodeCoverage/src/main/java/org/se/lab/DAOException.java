/**
 * A DAOException is used to encapsulate all kinds of SQL related exceptions.
 */

package org.se.lab;

public class DAOException
	extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public DAOException()
	{
		super("DAOException");
	}
	
	public DAOException(String msg)
	{
		super(msg);
	}
}
