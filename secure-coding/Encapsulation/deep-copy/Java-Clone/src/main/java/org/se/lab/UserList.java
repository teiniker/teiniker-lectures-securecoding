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
    public UserList clone() throws CloneNotSupportedException
    {
        UserList list = (UserList)super.clone();

        // We have to implement a deep copy of persons.
        list.users = new ArrayList<User>();
        for(User u : users)
        {
            list.users.add(u.clone());
        }
        return list;
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
