package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class AdminTest
{
    @Test
    public void testUser()
    {
        Admin monty = new Admin(666, "Montgomery", "Burns", "monty.burns@powerplant.com");

        Assert.assertEquals("Admin: 666,Montgomery,Burns,monty.burns@powerplant.com", monty.toString());
    }
    
}
