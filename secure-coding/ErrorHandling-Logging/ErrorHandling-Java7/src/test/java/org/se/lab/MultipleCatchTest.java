package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class MultipleCatchTest
{
	/*
	 * In Java SE 7 and later, a single catch block can handle more 
	 * than one type of exception. 
	 * This feature can reduce code duplication and lessen the 
	 * temptation to catch an overly broad exception.
	 * 
	 * Note: If a catch block handles more than one exception type, 
	 * then the catch parameter is implicitly final.
	 */
	private Connection getConnection(String propertyFileName)
	{
		final String driver;
		final String url;
		final String user;
		final String password;  
	    
    	Properties jdbcProperties = new Properties();
		try
		{
			jdbcProperties.load(new FileInputStream(new File("src/test/resources", propertyFileName)));
			driver = jdbcProperties.getProperty("jdbc.driver");
			url = jdbcProperties.getProperty("jdbc.url");
			user = jdbcProperties.getProperty("jdbc.username");
			password = jdbcProperties.getProperty("jdbc.password"); 
			
			Class.forName(driver);
	        Connection con = DriverManager.getConnection(url, user, password);
	        return con;
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			throw new RuntimeException("Can't connect to the database", e);
		}
	}

	
	@Test(expected = RuntimeException.class)
	public void testReadFirstLineFinally() throws IOException
	{
		// There is no JDBC driver so we will cause an exception
		getConnection("jdbc.properties");
	}
}
