package org.se.lab;

/**
 * We use this Transfer Object (TO) to carry multiple data elements across 
 * all application tiers.
 * Instead of sending or receiving individual data elements, a TO contains
 * all the data elements in a single structure required by the request or 
 * response. The TO is passed by value to the client, even in the remote case.
 */
public class User
{
    private int id;
    private String name;
            
    public User(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int hashCode()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + id;
        result = PRIME * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final User other = (User) obj;
        if (id != other.id)
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        return true;
    }

    public String toString()
    {
        return id + "," + name;
    }
}
