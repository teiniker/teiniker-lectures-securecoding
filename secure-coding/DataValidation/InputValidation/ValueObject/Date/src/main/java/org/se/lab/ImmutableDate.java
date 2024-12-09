package org.se.lab;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ImmutableDate
{
    private final static Pattern PATTERN = Pattern.compile("^[0-9]{4}[-. ][0-9]{1,2}[-. ][0-9]{1,2}$");
    
	/*
	 * Constructor
	 */
	public ImmutableDate(String dateString)
	{
		// check for null pointer
		if(dateString == null || dateString.isBlank())
			throw new IllegalArgumentException("Invalid date string!");
		
		// validate address format
		String s = Normalizer.normalize(dateString, Form.NFKC);
		Matcher matcher = PATTERN.matcher(s);
		if(!matcher.matches())
			throw new IllegalArgumentException("Invalid date format!");
			
		// store address
		String[] tokens = dateString.split("[-. ]");
		int y = Integer.parseInt(tokens[0]);
		validateYear(y);
		int m = Integer.parseInt(tokens[1]);
		validateMonth(m);
		int d = Integer.parseInt(tokens[2]);
		validateDay(d, m, y);

		year = y;
		month = m;
		day = d;
	}
	
	
	private final int year;
	public int getYear()
	{
	    return year;
	}

	private final int month;    
	public int getMonth()
	{
	    return month;
	}
	
	private final int day;
	public int getDay()
	{
	    return day;
	}

	private void validateYear(int y)
	{
	    if(y < 1900 || y > 2100)
	        throw new IllegalArgumentException("Invalid range of year!");
	}
	
	private void validateMonth(int m)
	{
	    if(m < 1 || m > 12)
	        throw new IllegalArgumentException("Invalid range of month!");
	}
	
	private final static int[] DAYS_OF_MONTH = new int[] {0,31,28,31,30,31,30,31,31,30,31,30,31};
	private void validateDay(int d, int m, int y)
	{
	    int max = DAYS_OF_MONTH[m];	    
	    if(m == 2 && isLeapYear(y))
	        max++; 
	            
        if(d < 1 || d > max)
            throw new IllegalArgumentException("Invalid range of day!");
	    
	}
	
	private boolean isLeapYear(int y)
	{
	    boolean isLeapYear;
	    
        // divisible by 4
        isLeapYear = (y % 4 == 0);

        // divisible by 4 and not 100
        isLeapYear = isLeapYear && (y % 100 != 0);

        // divisible by 4 and not 100 unless divisible by 400
        isLeapYear = isLeapYear || (y % 400 == 0);

        return isLeapYear;
    }
	
	
	/*
	 * Object methods
	 */
	
	@Override
	public String toString()
	{
		return getYear() + "-" + getMonth() + "-" + getDay();
	}

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + day;
        result = prime * result + month;
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImmutableDate other = (ImmutableDate) obj;
        if (day != other.day)
            return false;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        return true;
    }
}
