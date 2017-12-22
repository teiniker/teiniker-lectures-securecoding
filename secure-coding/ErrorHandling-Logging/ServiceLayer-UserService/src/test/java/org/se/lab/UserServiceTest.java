package org.se.lab;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.business.ServiceFactory;
import org.se.lab.business.UserService;
import org.se.lab.data.User;

public class UserServiceTest 
{	
	private static final JdbcTestHelper JDBC_HELPER = new JdbcTestHelper("src/test/resources/jdbc.properties");
	private Connection connection = null;

	private UserService service;
	
	@Before
	public void setup() throws ClassNotFoundException, SQLException  
	{		
		JDBC_HELPER.executeSqlScript("src/test/resources/sql/createUserTable.sql");
		connection = JDBC_HELPER.getConnection();
		
		service = ServiceFactory.createUserService(connection);
		
		service.addUser("Homer", "Simpson", "homer", "hjkH&68FFG");
		service.addUser("Bart", "Simpson", "bart", "HJH76787bnbn");
		service.addUser("Lisa", "Simpson", "lisa", "87Nmnn676&");
	}
	
	@After
	public void teardown() throws SQLException
	{		        
		JDBC_HELPER.executeSqlScript("src/test/resources/sql/dropUserTable.sql");
		connection.close();
	}

	
	@Test
    public void testFindAll() 
	{			
		List<User> users = service.findAllUsers();
    
		Assert.assertEquals(3, users.size());

		Assert.assertEquals(1, users.get(0).getId());
		Assert.assertEquals("homer",users.get(0).getUsername());
		Assert.assertEquals("4379DE14451F1E80B2263F0E664D892B4E858F8F75015C432D62D11BD31F3553", users.get(0).getPassword());

		Assert.assertEquals(2, users.get(1).getId());
		Assert.assertEquals("bart",users.get(1).getUsername());
		Assert.assertEquals("69C63108150E2CFFBF5BCDF426891892C5ABB9D6E20A93EC353CE7409B1BCAF7", users.get(1).getPassword());


		Assert.assertEquals(3, users.get(2).getId());
		Assert.assertEquals("lisa",users.get(2).getUsername());
		Assert.assertEquals("4F1E792DE6C0D1E5BFD842B082EBE20B3FB5AD0650D2067C1A7A48EF330DBF69", users.get(2).getPassword());
    }
}
