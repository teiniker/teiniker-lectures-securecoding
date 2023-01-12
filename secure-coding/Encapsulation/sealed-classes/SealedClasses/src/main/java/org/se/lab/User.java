package org.se.lab;

import java.util.Objects;

public sealed class User permits Admin
{
    public User(int id, String firstName, String lastName, String mail)
    {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setMail(mail);
    }

    // Property: id
    private int id;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    // Property: firstName
    private String firstName;
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    // Property: lastName
    private String lastName;
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    // Property: mail
    private String mail;
    public String getMail()
    {
        return mail;
    }
    public void setMail(String mail)
    {
        this.mail = mail;
    }


    // Object methods

    @Override
    public String toString()    
    {
        return "User: " + getId() + "," + getFirstName() + "," + getLastName() + "," + getMail();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
