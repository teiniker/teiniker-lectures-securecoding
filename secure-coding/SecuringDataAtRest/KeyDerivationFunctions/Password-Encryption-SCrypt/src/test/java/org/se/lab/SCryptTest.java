package org.se.lab;

import com.lambdaworks.crypto.SCryptUtil;
import org.junit.Assert;
import org.junit.Test;

public class SCryptTest
{
    @Test
    public void testEncodeAndCheck()
    {
        String password = "student";        
        String hashedPassword = SCryptUtil.scrypt(password, 16, 8, 1);
        System.out.println(hashedPassword);

        Assert.assertTrue(SCryptUtil.check("student", hashedPassword));
    }
}
