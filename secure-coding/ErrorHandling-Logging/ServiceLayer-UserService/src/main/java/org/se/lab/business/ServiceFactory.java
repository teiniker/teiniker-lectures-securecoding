package org.se.lab.business;

import org.apache.log4j.Logger;
import org.se.lab.data.DAOFactory;
import org.se.lab.data.UserDAO;

import java.sql.Connection;

public class ServiceFactory
{
    private static final Logger LOG = Logger.getLogger(ServiceFactory.class);
        
    public static UserService createUserService(Connection connection)
    {
        LOG.debug("createUserService(" + connection +")");
        
		UserDAO userDAO = DAOFactory.createUserDAO(connection);
		UserServiceImpl service = new UserServiceImpl(connection);
		service.setUserDAO(userDAO);
        LOG.debug("    service: " + service);

        return service;
    }
}
