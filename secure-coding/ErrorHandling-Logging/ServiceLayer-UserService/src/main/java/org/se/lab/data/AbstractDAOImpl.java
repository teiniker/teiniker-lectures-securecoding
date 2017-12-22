package org.se.lab.data;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class AbstractDAOImpl // package private
{
	private static final Logger LOG = Logger.getLogger(AbstractDAOImpl.class);

	/*
	 * Dependency: ---[1]-> connection:Connection
	 */
	private Connection connection;
	protected final Connection getConnection()
	{
		return connection;
	}
	public final void setConnection(final Connection connection)
	{
		if (connection == null)
			throw new IllegalArgumentException("Invalid Connection (null)!");
		this.connection = connection;
	}


	/*
	 * Helper methods
	 */

	protected void closeResultSet(ResultSet rs)
	{
		LOG.debug("closeResultSet(" + rs + ")");

		if (rs != null)
		{
			try
			{
				rs.close();
			} 
			catch (SQLException e)
			{
				throw new DAOException("Result set closing failure", e);
			}
		}
	}

	protected void closePreparedStatement(PreparedStatement pstmt)
	{
        LOG.debug("closePreparedStatement(" + pstmt + ")");

		if (pstmt != null)
		{
			try
			{
				pstmt.close();
			} 
			catch (SQLException e)
			{
				throw new DAOException("Prepared statement closing failure", e);
			}
		}
	}

	protected void closeStatement(Statement stmt) 
	{
        LOG.debug("closeStatement(" + stmt + ")");

		if (stmt != null)
		{
			try
			{
				stmt.close();
			} 
			catch (SQLException e)
			{
				throw new DAOException("Statement closing failure", e);
			}
		}
	}
}
