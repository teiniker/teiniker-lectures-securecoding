package org.se.lab.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


class UserDAOImpl // package private
	extends AbstractDAOImpl
	implements UserDAO
{
	private static final Logger LOG = Logger.getLogger(UserDAOImpl.class);

	/*
	 * Constructor
	 */
	public UserDAOImpl(Connection connection)
	{
		LOG.debug("UserDAOImpl(" + connection + ")");
		if(connection == null)
			throw new IllegalArgumentException("Invalid Connection (null)!");

		setConnection(connection);
	}

	
	/*
	 * DAO operations
	 */

	public void insert(User user)
	{
		LOG.debug("insert(" + user + ")");
		
		if (user == null)
			throw new IllegalArgumentException("Invalid User (null)!");

		final String SQL = "INSERT INTO user VALUES (NULL,?,?,?,?)";
		LOG.debug("SQL> " + SQL);

		try(PreparedStatement pstmt = getConnection().prepareStatement(SQL))
		{
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			throw new DAOException("Insert failure", e);
		} 
	}

	public void update(User user)
	{
		LOG.debug("update(" + user + ")");
		
		if (user == null)
			throw new IllegalArgumentException("Invalid User (null)!");

		final String SQL = "UPDATE user SET firstname=?, lastname=?, "
				+ "username=?, password=? WHERE id=?";
		LOG.debug("SQL> " + SQL);
		PreparedStatement pstmt = null;

		try
		{
			pstmt = getConnection().prepareStatement(SQL);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.setLong(5, user.getId());
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			throw new DAOException("Update failure", e);
		} 
		finally
		{
			closePreparedStatement(pstmt);
		}
	}

	
	public void delete(User user) 
	{
		LOG.debug("delete(" + user + ")");

		if (user == null)
            throw new IllegalArgumentException("Invalid User (null)!");

		final String SQL = "DELETE FROM user WHERE ID = ?";
		LOG.debug("SQL> " + SQL);
		PreparedStatement pstmt = null;
		try
		{
			pstmt = getConnection().prepareStatement(SQL);
			pstmt.setLong(1, user.getId());
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			throw new DAOException("Delete failure", e);
		} 
		finally
		{
			closePreparedStatement(pstmt);
		}
	}

	public User findById(int id) 
	{
		LOG.debug("findById(" + id + ")");

		if(id < 0)
            throw new IllegalArgumentException("Invalid id (" + id + ")!");

		final String SQL = "SELECT * FROM user WHERE id=? ";
		LOG.debug("SQL> " + SQL);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try
		{
			pstmt = getConnection().prepareStatement(SQL);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			user = new User();
			user.setId(rs.getInt("id"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
		} 
		catch (SQLException e)
		{
			throw new DAOException("update failure", e);
		} 
		finally
		{
			closeResultSet(rs);
			closePreparedStatement(pstmt);
		}
		return user;
	}

	
	public List<User> findAll()
	{
		LOG.debug("findAll()");
		
		final String SQL = "SELECT * FROM user";
		LOG.debug("SQL> " + SQL);
		Statement stmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();

		try
		{
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(SQL);

			while (rs.next())
			{
				int id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String username = rs.getString("username");
				String password = rs.getString("password");
				User user = new User();
				user.setId(id);
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setUsername(username);
				user.setPassword(password);
				users.add(user);
			}
		} 
		catch (SQLException e)
		{
			throw new DAOException("update failure", e);
		} 
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return users;
	}
	
	
	public User createUser(String firstName, String lastName, String username, String password)
	{
        LOG.debug("createUser(" + firstName + "," + lastName + "," + username + ")");

		User u = new User();
		u.setFirstname(firstName);
		u.setLastname(lastName);
		u.setUsername(username);
		u.setPassword(password);		
		insert(u);
		return u;
	}
}
