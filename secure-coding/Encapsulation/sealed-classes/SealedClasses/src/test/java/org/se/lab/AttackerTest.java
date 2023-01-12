package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class AttackerTest
{
    @Test
    public void testUser()
    {
        Attacker bart = new Attacker(13, "Bart", "Simpsons", "bart.simpson@springfield.com");

        Assert.assertEquals("Attacker: 13,Bart,Simpsons,bart.simpson@springfield.com", bart.toString());
    }
    
}
