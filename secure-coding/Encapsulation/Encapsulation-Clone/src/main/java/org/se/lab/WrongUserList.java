package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class WrongUserList
    implements Cloneable
{
    /*
     * Property: users
     */
    private List<User> users = new ArrayList<User>();
    public void addUser(User u)
    {
        users.add(u);
    }
    public List<User> getUsers()
    {
        return users;
    }
    public User findUserById(int id)
    {
        for(User u : getUsers())
        {
            if(u.getId() == id)
                return u;
        }
        return null;
    }
    
 
    /*
     * In many cases, the default implementation of clone will be wrong because it
     * duplicates a reference to an object that should not be shared.
     * The default implementation assigns each field from the source to the same 
     * field in the destination object.
     */
    @Override
    public WrongUserList clone()
    {
        try
        {
            return (WrongUserList)super.clone();
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
