package org.se.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class MatcherTest
{
	@Test
	public void testMatches()
	{
		final String regex = "0[0-7]+";
		final String input = "0715";
							
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(input);
		boolean result = m.matches();

		assertTrue(result);	
	}	
	
	@Test
	public void testLookingAt()
	{
		final String regex = "0[0-7]+";
		final String input = "0715fjsdhfksahfdkjas";
							
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(input);
		boolean result = m.lookingAt();

		assertTrue(result);	
	}

	@Test
	public void testFind()
	{
		final String regex = "0[0-7]+";
		final String input = "octal: 0123, 07765, 05432";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		while(matcher.find())
		{
		    String group = matcher.group(); 
			System.out.println("group() = " + group);
			
			int start = matcher.start();
			System.out.println("start() = " + start);
			
			int end = matcher.end();
			System.out.println("end()   = " + end);
		}
	}
	
	@Test
	public void testReplaceFirst()
	{
		final String regex = "[ÄäÜüÖö]"; 
		final String input = "Über den Dächern von Österreich.";		
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		String result = matcher.replaceFirst("-");
		assertEquals("-ber den Dächern von Österreich.", result);
	}
	
	@Test
	public void testReplaceAll()
	{
		final String regex = "[ÄäÜüÖö]";		
		final String input = "Über den Dächern von Österreich.";		

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		String result = matcher.replaceAll("-");
		
		assertEquals("-ber den D-chern von -sterreich.",result);
	}
}
