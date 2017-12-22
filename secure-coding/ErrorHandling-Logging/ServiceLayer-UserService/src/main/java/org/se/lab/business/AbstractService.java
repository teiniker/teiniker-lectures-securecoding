package org.se.lab.business;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

abstract class AbstractService // package private
{
	private static final Logger LOG = Logger.getLogger(AbstractService.class);
	
	/*
	 * Dependency: ---[1]-> connection:Connection
	 */
	protected Connection connection;
	protected Connection getConnection()
	{
		return connection;
	}
	public void setConnection(Connection connection)
	{
		if(connection == null)
			throw new NullPointerException("Invalid Connection (null)!");

		this.connection = connection;
	}
	
	
	
	/*
	 * Transaction methods
	 */
	
	protected void txBegin() 
	{
	    LOG.debug("txBegin()");

		try
        {
            connection.setAutoCommit(false);
        } 
		catch (SQLException e)
        {
		    throw new ServiceException("Transaction begin failure");
        } 
	}

	protected void txCommit() 
	{
	    LOG.debug("txCommit()");

		try
        {
            connection.commit();
            connection.setAutoCommit(true);
        } 
		catch (SQLException e)
        {
		    throw new ServiceException("Transaction commit failure");
        }
	}

	protected void txRollback() 
	{
        LOG.debug("txRollback()");

		try
        {
            connection.rollback();
        } 
		catch (SQLException e)
        {
            throw new ServiceException("Transaction rollback failure");
        }
	}
}