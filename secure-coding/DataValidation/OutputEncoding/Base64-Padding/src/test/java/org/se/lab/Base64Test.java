package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class Base64Test
{
	@Test
	public void test6Bytes()
	{
		byte[] binaryData = 
		{ 
			(byte)0x14,(byte)0xfb,(byte)0x9c, (byte)0x03, (byte)0xd9, (byte)0x7e
		};
		
		String base64String = Base64.toBase64String(binaryData);
		
		Assert.assertEquals("FPucA9l+", base64String);
	}

	
    // 0x03 0xd9
    // 3 x 8 bits (with padding)
    // 0000 0011  1101 1001  0000 0000
    
    // 4 x 6 bits (left to right)
    // 000000 111101 100100 000000
    // "A"    "9"    "k"    "=" 
    @Test
    public void test5Bytes()
    {
        byte[] binaryData = 
        { 
            (byte)0x14,(byte)0xfb,(byte)0x9c, (byte)0x03, (byte)0xd9
        };
        
        String base64String = Base64.toBase64String(binaryData);
        
        Assert.assertEquals("FPucA9k=", base64String);
    }


    // 0x03
    // 3 x 8 bits (with padding)
    // 0000 0011  0000 0000  0000 0000
    
    // 4 x 6 bits (left to right)
    // 000000 110000 000000 000000
    // "A"    "w"    "="    "=" 
    @Test
    public void test4Bytes()
    {
        byte[] binaryData = 
        { 
            (byte)0x14,(byte)0xfb,(byte)0x9c, (byte)0x03
        };
        
        String base64String = Base64.toBase64String(binaryData);
        
        Assert.assertEquals("FPucAw==", base64String);
    }

}
