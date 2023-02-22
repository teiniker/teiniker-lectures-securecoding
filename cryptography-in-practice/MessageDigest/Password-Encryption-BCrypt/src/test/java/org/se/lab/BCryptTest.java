package org.se.lab;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptTest
{
    @Test
    public void testHashpwAndCheckpw()
    {
        String password = "student";
        // Hash a password using the OpenBSD bcrypt scheme
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashedPassword);

        // Check that a plaintext password matches a previously hashed one
        Assert.assertTrue(BCrypt.checkpw("student", hashedPassword));
    }
    
    @Test
    public void testGenSalt()
    {
        // The amount of work increases exponentially (2^n), so each 
        // increment is twice as much work. 
        // The default n is 10, and the valid range is 4 to 31.
        
        String strong_salt = BCrypt.gensalt(10);
        System.out.println(strong_salt);
                
        String stronger_salt = BCrypt.gensalt(12);
        System.out.println(stronger_salt);
    }
}
