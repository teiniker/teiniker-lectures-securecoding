package org.se.lab;

/**
 * This interface defines the DAO methods which can be implemented
 * in different ways and technologies (JDBC, Hibernate, XML, etc.)  
 */
public interface UserDAO
{
    void insert(User p);
    void update(User p);
    void delete(int id);
    
    User findById(int id);    
}
