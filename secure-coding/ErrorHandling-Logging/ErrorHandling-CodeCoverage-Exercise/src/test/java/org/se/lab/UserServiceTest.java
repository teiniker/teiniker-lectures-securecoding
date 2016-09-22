package org.se.lab;

import static org.junit.Assert.assertEquals;

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
        assertEquals(new User(7, "Egon"), stub.user);
    }

    @Test
    public void testToCsv() 
    {
    	// setup
    	stub.user = new User(7,"Teiniker");
        
        String csv = service.toCSV(7);
        
        // Verify results and states
        assertEquals("7,Teiniker", csv);
    }    
}
