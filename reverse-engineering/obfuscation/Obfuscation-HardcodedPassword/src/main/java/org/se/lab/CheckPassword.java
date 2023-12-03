package org.se.lab;

public class CheckPassword
{
    public int constant()
    {
        return 2;
    }

    public int len()
    {
        return 6 * constant();
    }

    public String secret()
    {
        return "VvnoWnioi8hjHGzu&56nm;:mkhjghfg";
    }
    public boolean validate(String password)
    {
        return secret().substring(10, 10 + len()).equals(password);
    }
}
