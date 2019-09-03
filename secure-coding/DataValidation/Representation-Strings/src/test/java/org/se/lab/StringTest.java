package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class StringTest
{

	@Test
    public void testStringReferenceComparison()
    {
        String s1 = Integer.toString(1234);
        String s2 = Integer.toString(1234);

        Assert.assertFalse(s1 == s2);
    }

    /*
    String Interning is a method of storing only one copy of each
    distinct String Value, which must be immutable.
    By applying String.intern() on a couple of strings will ensure
    that all strings having the same contents share the same memory.
    This can be very useful to reduce the memory requirements of your
    program.

    String.intern()
    Returns a canonical representation for the string object.
    When the intern method is invoked, if the pool already contains a
    string equal to this {@code String} object as determined by
    the equals(Object) method, then the string from the pool is
    returned. Otherwise, this {@code String} object is added to the
    pool and a reference to this {@code String} object is returned.
    */
    @Test
    public void testStringInternComparison()
    {
        String s1 = Integer.toString(1234).intern();
        String s2 = Integer.toString(1234).intern();

        Assert.assertTrue(s1 == s2);
    }


    @Test
    public void testStringValueComparison()
    {
        String s1 = Integer.toString(1234);
        String s2 = Integer.toString(1234);

        Assert.assertTrue(s1.equals(s2));
    }



    @Test
	public void testStringLiteral()
	{
		int size = "Java Security".length();

		assertEquals(13, size);
	}

	@Test
	public void testStringConcatination()
	{
		int i = 7;
		String s = "i" + "=" + i;

		assertEquals("i=7", s);
	}

	@Test
	public void testStringConcatinationUsingStringBuilder()
	{
		int i = 7;
		StringBuilder s = new StringBuilder();
		s.append("i");
		s.append("=").append(i);

		assertEquals("i=7", s.toString());
	}


	@Test
	public void testStringValueOf()
	{
		double pi = 3.1415;
		String s = String.valueOf(pi);

		assertEquals("3.1415", s);
	}


	@Test
	public void testStringFormat()
	{
		String s = String.format("PI = %3.2f", Math.PI);
		assertEquals("PI = 3.14", s);
	}


	@Test
	public void testStringTrim()
	{
		String input = "    3.1415   ";

		// Note that we get a new String object from trim()
		String pi = input.trim();
		assertEquals("3.1415", pi);
	}
}
