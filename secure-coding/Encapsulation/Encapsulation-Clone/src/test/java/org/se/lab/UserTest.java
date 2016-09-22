package org.se.lab;

import static java.lang.System.out;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.User;

public class UserTest
{
    @Test
    public void testClone()
    {
        User k = new User(1, "Homer", "Simpson", "homer.simpson@fhj.at");        
        User x = k.clone();
        
        out.println(k);
        out.println(x);
        
        Assert.assertEquals(k.getId(), x.getId());
        Assert.assertEquals(k.getFirstName(), x.getFirstName());
        Assert.assertEquals(k.getLastName(), x.getLastName());
        Assert.assertEquals(k.getMail(), x.getMail());
    }
    
    
    @Test
    public void testCloneAndChange() throws CloneNotSupportedException
    {
        User k = new User(1, "Homer", "Simpson", "homer.simpson@fhj.at");
        User x = k.clone();
        x.setId(7);
        x.setMail("hs@fhj.at");
        
        out.println(k);
        out.println(x);
    }
}
