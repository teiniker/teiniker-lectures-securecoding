package org.se.lab;

public class Attacker extends Admin
{
    public Attacker(int id, String firstName, String lastName, String mail)
    {
        super(id, firstName, lastName, mail);
    }

    // Object methods

    @Override
    public String toString()
    {
        return "Attacker: " + getId() + "," + getFirstName() + "," + getLastName() + "," + getMail();
    }
}
