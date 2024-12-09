package org.se.lab;


/*
 * This is the implementation of a simple service object which is used as an 
 * Object Under Test (OUT).
 */
public class UserService
{
	/*
	 * Constructor
	 */
	public UserService(UserDAO userDAO)
	{
		if(userDAO == null)
			throw new IllegalArgumentException("UserDAO is null!");
		
		setUserDAO(userDAO);
	}

	
	/*
	 * Dependency: userDao:UserDAO
	 */
	private UserDAO userDAO;
    public void setUserDAO(UserDAO userDAO) 
    {
		this.userDAO = userDAO;
	}

    
    /*
     * Business Methods
     */
    
	public String toCSV(int id)
    {
        StringBuilder csv = new StringBuilder();
        try 
        {
            User p = userDAO.findById(id);
            csv.append(p.toString());
        }
        catch(DAOException e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
        return csv.toString();
    }
    
    public void addUser(User p)
    {
        try 
        {
            userDAO.insert(p);
        }
        catch(DAOException e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    
    //...
}
