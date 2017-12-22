package org.se.lab.data;

import org.apache.log4j.Logger;

import java.sql.Connection;

public class DAOFactory
{
    private static final Logger LOG = Logger.getLogger(DAOFactory.class);

    public static UserDAO createUserDAO(Connection connection)
    {
        LOG.debug("createUserDAO(" + connection +")");
        UserDAOImpl userDAO = new UserDAOImpl(connection);
        LOG.debug("    service: " + userDAO);

        return userDAO;
    }
}
