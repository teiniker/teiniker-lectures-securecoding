package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class BigIntegerTest
{
    /*
     * BigInteger​(String val)
     * Translates the decimal String representation of a BigInteger into a BigInteger.
     */
    @Test
    public void testConstructor()
    {
        BigInteger i = new BigInteger("6666");

        Assert.assertEquals(6666, i.intValue());
    }

    /*
     * static BigInteger valueOf​(long val)
     * Returns a BigInteger whose value is equal to that of the specified long.
     */
    @Test
    public void testValueOf()
    {
        BigInteger i = BigInteger.valueOf(6666);

        Assert.assertEquals(6666, i.intValue());
    }

    /*
     * BigInteger add​(BigInteger val)
     * Returns a BigInteger whose value is (this + val).
     */
    @Test
    public void testAdd()
    {
        BigInteger a = BigInteger.valueOf(111);
        BigInteger b = BigInteger.valueOf(222);
        BigInteger r = a.add(b);  // returns a new object

        Assert.assertEquals(333, r.intValue());
    }

    /*
     * String toString()
     * Returns the decimal String representation of this BigInteger.
     */
    @Test
    public void testToString()
    {
        BigInteger i = BigInteger.valueOf(6666);

        Assert.assertEquals("6666", i.toString());
    }

    /*
     * If the value of this BigInteger is out of the range of the
     * int type, then an ArithmeticException is thrown.
     * Since  1.8
     */
    @Test(expected=ArithmeticException.class)
    public void testExtractExact()
    {
        BigInteger i = BigInteger.valueOf(Integer.MAX_VALUE + 1L); //!! 1 doesn't work!!
        //BigInteger i = BigInteger.valueOf(Integer.MAX_VALUE).add(BigInteger.valueOf(1));
        int value = i.intValueExact();
    }
}
