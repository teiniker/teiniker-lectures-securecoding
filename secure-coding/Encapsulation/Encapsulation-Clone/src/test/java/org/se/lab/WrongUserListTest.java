package org.se.lab;

import static java.lang.System.out;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.User;
import org.se.lab.WrongUserList;


public class WrongUserListTest
{
    private WrongUserList list;
    
    @Before
    public void setUp()
    {
        list = new WrongUserList();
        list.addUser(new User(1, "Homer", "Simpson", "homer.simpson@fhj.at"));
        list.addUser(new User(7, "Bart", "Simpson", "bart.simpson@fhj.at"));
    }
    
    
    @Test
    public void testClone() 
    {
        WrongUserList x = list.clone();
        out.println("Original:\n" + list);
        out.println("Clone:\n" + x);
        String expected = "1,Homer,Simpson,homer.simpson@fhj.at" + "\n" + 
                          "7,Bart,Simpson,bart.simpson@fhj.at" + "\n";
        Assert.assertEquals(expected, x.toString());
    }
    
    @Test
    public void testCloneAndModify() 
    {        
        out.println("Original (before changing an element):\n" + list);

        WrongUserList x = list.clone();
        User u = x.findUserById(7);
        u.setMail("bs@fhj.at");

        out.println("Clone (after changing an element):\n" + x);
        out.println("Original (after changing an element):\n" + list);
    
        String original = "1,Homer,Simpson,homer.simpson@fhj.at" + "\n" + 
                          "7,Bart,Simpson,bs@fhj.at" + "\n";        
        Assert.assertEquals(original, list.toString()); // We also modified the original !!!!
    }
}
