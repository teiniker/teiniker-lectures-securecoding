package org.se.lab;


public class BadPractice
{

    public void toSomething(boolean b)
    {
        String s = null;
        if(b)
        {
            s = "Hallo";
        }
        s.length();
    }
    
    
    public void showNullPointer()
    {
        String s = null;
        
        int l = s.length();
    }
    
    public void WrongNameConvention()
    {}

    
    public void callSystemExit(String s)
    {
        String s1 = "AAAA";
        if(s1 == s)
        {
            System.out.println("Strings are equal!");
        }
    }
    
    public Boolean booleanReturnNull()
    {
        return null;
    }
}
