package org.se.lab;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date
{
	public int year;
	public int month;
	public int day;

	public Date(String dateString)
	{
		String[] tokens = dateString.split("[-. ]");
		int y = Integer.parseInt(tokens[0]);
		validateYear(y);
		int m = Integer.parseInt(tokens[1]);
		validateMonth(m);
		int d = Integer.parseInt(tokens[2]);

		year = y;
		month = m;
		day = d;
	}
}
