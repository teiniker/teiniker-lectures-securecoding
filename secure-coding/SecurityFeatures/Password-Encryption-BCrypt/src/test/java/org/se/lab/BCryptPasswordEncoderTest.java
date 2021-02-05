package org.se.lab;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptPasswordEncoderTest
{
    @Test
    public void testEncoder()
    {
        String password = "student";        
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String hashedPassword = encoder.encode(password);        
        System.out.println(hashedPassword);
        
        Assert.assertTrue(encoder.matches(password, hashedPassword));
    }

    
    @Test
    public void testEncoderSettingStrength()
    {
        String password = "student";        
        PasswordEncoder encoder = new BCryptPasswordEncoder(14);
        
        String hashedPassword = encoder.encode(password);        
        System.out.println(hashedPassword);
        
        Assert.assertTrue(encoder.matches(password, hashedPassword));
    }
}
