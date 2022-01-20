package org.se.lab;

import org.junit.Test;

public class ShiftTest
{
    @Test
    public void testShift()
    {
        int value = 0xff;
        
        System.out.printf("%d %x\n", value, value, value);
        
        value = value >> 4;
        System.out.printf("%d %x", value, value, value);
        
        
    }
}
