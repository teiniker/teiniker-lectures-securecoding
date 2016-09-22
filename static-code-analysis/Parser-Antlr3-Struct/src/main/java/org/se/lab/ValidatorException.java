package org.se.lab;

public class ValidatorException
	extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public ValidatorException(String message)
	{
		super(message);
	}
	
	public ValidatorException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
