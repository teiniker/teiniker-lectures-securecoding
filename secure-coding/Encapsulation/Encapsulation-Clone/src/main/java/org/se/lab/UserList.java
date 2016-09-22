package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class UserList
    implements Cloneable
{
    /*
     * Property: users
     */
    private List<User> users = new ArrayList<User>();
    public void addUser(User p)
    {
        users.add(p);
    }
    public List<User> getUsers()
    {
        return users;
    }
    public User findUserById(int id)
    {
        for(User p : getUsers())
        {
            if(p.getId() == id)
                return p;
        }
        return null;
    }
    
 
    /*
     * In many cases, the default implementation of clone will be wrong because it
     * duplicates a reference to an object that should not be shared.
     */
    @Override
    public UserList clone()
    {
        try
        {
            UserList list = (UserList)super.clone();

            // ArrayList.clone() returns a shallow copy! 
            // (The elements themselves are not copied.)
            // list.persons = persons.clone();
        
            // An ArrayList's copy constructor does not make a deep copy too!
            // list.persons = new ArrayList<Person>(persons);
        
            // Therefore, we have to implement a deep copy of persons.
            list.users = new ArrayList<User>();
            for(User u : users)
            {
                list.users.add(u.clone());
            }
            return list;
        }
        catch(CloneNotSupportedException e)
        {
            // Cannot happen!
            throw new InternalError(e.toString());
        }
    }
    
    
    
    public String toString()
    {
        StringBuilder out = new StringBuilder();
        for(User p : getUsers())
        {
            out.append(p.toString()).append("\n");
        }
        return out.toString();
    }
}
