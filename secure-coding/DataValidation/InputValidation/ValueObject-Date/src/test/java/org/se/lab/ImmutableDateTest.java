package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class ImmutableDateTest
{
    @Test
    public void testDayMonthYear()
    {
        ImmutableDate date = new ImmutableDate("2018-12-11");
        Assert.assertEquals(11, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2018, date.getYear());
    }
       
	@Test
	public void testToString()
	{
		ImmutableDate date = new ImmutableDate("2018-12-11");
		Assert.assertEquals("2018-12-11", date.toString());
	}
	
	@Test
	public void testHashCodeAndEquals()
	{
	    ImmutableDate date1 = new ImmutableDate("2018-12-11");
	    ImmutableDate date2 = new ImmutableDate("2018-12-11");
	    
	    Assert.assertEquals(date1.hashCode(), date2.hashCode());
	    Assert.assertTrue(date1.equals(date2));
	    Assert.assertTrue(date2.equals(date1));
	}
	
	
	@Test
	public void testValidDates()
	{
		new ImmutableDate("2018.12.11");
		new ImmutableDate("2018 12 11");

		new ImmutableDate("1900-12-11");
		new ImmutableDate("2100-12-11");
		
		new ImmutableDate("2015-1-1");
		
		new ImmutableDate("2015-1-31");
		new ImmutableDate("2015-2-28");
		new ImmutableDate("2015-3-31");
		new ImmutableDate("2015-4-30");
		new ImmutableDate("2015-5-31");
		new ImmutableDate("2015-6-30");
		new ImmutableDate("2015-7-31");
		new ImmutableDate("2015-8-31");
		new ImmutableDate("2015-9-30");
		new ImmutableDate("2015-10-31");
		new ImmutableDate("2015-11-30");
		new ImmutableDate("2015-12-31");
		
		new ImmutableDate("2000-2-29");
		new ImmutableDate("2002-2-28");
		new ImmutableDate("2004-2-29");
	    new ImmutableDate("2015-2-28");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNull()
	{
		new ImmutableDate(null);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void testEmpty()
	{
		new ImmutableDate("");
	}

	@Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_Separator()
    {
        new ImmutableDate("2015:12:11");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYear_TooSmall()
    {
        new ImmutableDate("1899-12-11");
    }
	   
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYear_TooLarge()
    {
        new ImmutableDate("2101-12-11");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYear_WrongChar()
    {
        new ImmutableDate("20x5-12-11");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonth_TooSmall()
    {
        new ImmutableDate("2015-0-11");
    }
       
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonth_TooLarge()
    {
        new ImmutableDate("2015-13-11");
    }    

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonth_WrongChar()
    {
        new ImmutableDate("2015-1x-11");
    }
        
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDate_DayToSmall()
	{
		new ImmutableDate("2015-12-0");
	}
	
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge1()
    {
        new ImmutableDate("2015-1-32");
    }
	
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge2()
    {
        new ImmutableDate("2015-2-29");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge3()
    {
        new ImmutableDate("2015-3-32");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge4()
    {
        new ImmutableDate("2015-4-31");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge5()
    {
        new ImmutableDate("2015-5-32");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge6()
    {
        new ImmutableDate("2015-6-31");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge7()
    {
        new ImmutableDate("2015-7-32");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge8()
    {
        new ImmutableDate("2015-8-32");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge9()
    {
        new ImmutableDate("2015-9-31");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge10()
    {
        new ImmutableDate("2015-10-32");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge11()
    {
        new ImmutableDate("2015-11-31");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate_DayToLarge12()
    {
        new ImmutableDate("2015-12-32");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDay_WrongChar()
    {
        new ImmutableDate("2015-12-x1");
    }
}
