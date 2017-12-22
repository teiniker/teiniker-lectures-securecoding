package org.se.lab.business;

public class ServiceException
    extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /*
     * Constructors
     */

    public ServiceException(String message)
    {
        super(message);
    }
    
    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
