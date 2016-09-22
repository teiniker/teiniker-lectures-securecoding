package org.se.lab;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest 
{   
	private UserService service;
	private UserDAOStub stub;
	
	@Before
	public void setup()
	{
		// setup
		stub = new UserDAOStub();
		service = new UserService(stub);     			
	}
	
    @Test
    public void testAddPerson()
    {
    	User user = new User(7, "Egon");
        service.addUser(user);      
        
        // Verify results and states
        Assert.assertEquals(new User(7, "Egon"), stub.user);
    }

    @Test
    public void testToCsv() 
    {
    	// setup
    	stub.user = new User(7,"Teiniker");
        
        String csv = service.toCSV(7);
        
        // Verify results and states
        Assert.assertEquals("7,Teiniker", csv);
    }    
    
    
    @Test
    public void testConstructor_NullPointer()
    {
    	try
    	{
    		new UserService(null);
    		Assert.fail();
    	}
    	catch(IllegalArgumentException e)
    	{
    		Assert.assertEquals("UserDAO is null!", e.getMessage());
    	}
    }
    
    @Test
    public void testAddUser_DAOException()
    {
    	stub.exception = new DAOException("Can't insert User");

    	try
    	{
    		service.addUser(new User(7, "Egon"));      
    		Assert.fail();
    	}
    	catch(ServiceException e)
    	{
    		Assert.assertTrue(e.getCause() instanceof DAOException);
    		Assert.assertEquals("Can't insert User", e.getMessage());
    	}
    }
    
    
    @Test
    public void testToCSV_DAOException()
    {
    	stub.exception = new DAOException("Can't find User");
    	stub.user = new User(7,"Teiniker");	
        

    	try
    	{
    		service.toCSV(7);
    		Assert.fail();
    	}
    	catch(ServiceException e)
    	{
    		Assert.assertTrue(e.getCause() instanceof DAOException);
    		Assert.assertEquals("Can't find User", e.getMessage());
    	}    	
    }
}
