package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class UserTest
{
    @Test
    public void testUser()
    {
        User homer = new User(7, "Homer", "Simpson", "homer.simpson@springfield.com");

        Assert.assertEquals("User: 7,Homer,Simpson,homer.simpson@springfield.com", homer.toString());
    }
}
