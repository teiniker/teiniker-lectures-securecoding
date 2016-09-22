package org.se.lab;

/**
 * The Cloneable interface was intended as a mixin interface for objects to
 * advertise that they permit cloning. Unfortunately, it fails to serve this
 * purpose.
 * Its primary flaw is that it lacks a clone() method, and java.lang.Object's
 * clone() method is protected.
 * 
 * A given class can have one of four different attitudes toward clone():
 * 
 * o Support clone().
 *   Such a class implements Cloneable and declares its clone method to throw 
 *   no exceptions.
 *   
 * o Conditionally support clone().
 *   Such a class might be a collection class that can be cloned in principle
 *   but cannot successfully be cloned unless its contents can be cloned.
 *   Or a class may have the ability to be cloned.
 *   This kind of class will implement Cloneable, but will let its clone()
 *   method pass through any CloneNotSupportedException it may receive
 *   from other objects it tries to clone.
 *  
 * o Allow subclasses to support clone but don't publicly support it.
 *   Such a class does not implement Cloneable, but if the default 
 *   implementation of clone isn't correct, the class provides a protected 
 *   clone implementation that clones its fields correctly. 
 *  
 * o Forbid clone.
 *   Such a class does not implement Cloneable and provides a clone method
 *   that always throws CloneNotSupportedException.
 */
public class User
    implements Cloneable
{
    /* Init constructor */
    public User(int id, String firstName, String lastName, String mail)
    {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setMail(mail);
    }
    
    /*
     * Clone method
     * A clone method returns a new object whose initial state is a copy of the 
     * current state of the object on which clone was invoked.
     * The simplest way to make a class that can be cloned is to declare that it
     * implements the Cloneable interface, and override the clone method,
     * redeclaring it to be public.
     */    
    @Override
    public User clone()
    {
        try
        {
            return (User)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            // Cannot happen!
            throw new InternalError(e.toString());
        }
    }
    
        
    /*
     * Property: id
     */
    private int id;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }


    /*
     * Property: firstName
     */
    private String firstName;
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    
    /*
     * Property: lastName
     */
    private String lastName;
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    
    /*
     * Property: mail
     */
    private String mail;
    public String getMail()
    {
        return mail;
    }
    public void setMail(String mail)
    {
        this.mail = mail;
    }
    

    /* Override Objeckt.toString() */
    public String toString()    
    {
        return getId() + "," + getFirstName() + "," + getLastName() + "," + getMail();
    }
}
