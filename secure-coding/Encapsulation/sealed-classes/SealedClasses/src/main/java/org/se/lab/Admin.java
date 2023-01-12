package org.se.lab;

public non-sealed class Admin extends User
{
    public Admin(int id, String firstName, String lastName, String mail)
    {
        super(id, firstName, lastName, mail);
    }

    // Object methods

    @Override
    public String toString()    
    {
        return "Admin: " + getId() + "," + getFirstName() + "," + getLastName() + "," + getMail();
    }
}
