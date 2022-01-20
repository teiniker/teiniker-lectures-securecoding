package org.se.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class StringTest
{
	/*
	 * public boolean matches(String regex)
	 * Tells whether or not this string matches the given
	 * regular expression.
	 */
	@Test
	public void testMatches()
	{
		final String regex = "0[0-7]+"; // Octal number
		
		final String input1 = "0123";		
		assertTrue(input1.matches(regex));
		
		final String input2 = "0815";
		assertFalse(input2.matches(regex));
	}
	
	
	/*
	 * public String replaceFirst(String regex, String replacement)
	 * Replaces the first substring of this string that matches the given
	 * regular expression with the given replacement.
	 */
	@Test
	public void testReplaceFirst()
	{
		final String regex = "[ÄäÜüÖö]"; 
		
		final String input = "Über den Dächern von Österreich.";		
		
		String output = input.replaceFirst(regex, "-"); 
		assertEquals("-ber den Dächern von Österreich.", output);
	}

	
	/*
	 * public String replaceAll(String regex, String replacement)
	 * Replaces each substring of this string that matches the given
	 * regular expression with the given replacement.
	 */
	@Test
	public void testReplaceAll()
	{
		final String regex = "[ÄäÜüÖö]";
		
		final String input = "Über den Dächern von Österreich.";		
		
		String output = input.replaceAll(regex, "-"); 
		assertEquals("-ber den D-chern von -sterreich.", output);
	}


	/*
	 * public String[] split(String regex)
	 * Splits this string around matches of the given regular expression.
	 */
	@Test
	public void testSplit()
	{
		final String regex = "[,;: ]";		
		final String input = "23,23;323:323 3232;";		
		
		String[] output = input.split(regex); 
		
		assertEquals("[23, 23, 323, 323, 3232]", Arrays.toString(output));
	}
}
