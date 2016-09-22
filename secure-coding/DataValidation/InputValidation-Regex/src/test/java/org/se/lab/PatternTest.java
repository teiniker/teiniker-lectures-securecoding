package org.se.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.junit.Test;

/*
 * There are convenience methods on Pattern which create their own
 * Pattern and Matcher. These are easy to use, but inefficient if we
 * use the same pattern multiple times. 
 */

public class PatternTest
{
	/*
	 * public String[] split(CharSequence input)
	 * A convenience method that splits the given input sequence
	 * around matches of this pattern.
	 */
	@Test
	public void testPatternSplit()
	{
		final String regex = "[,;: ]";		
		final String input = "23,23;323:323 3232;";		
		
		Pattern pattern = Pattern.compile(regex);		
		String[] tokens = pattern.split(input);
		
		assertEquals("[23, 23, 323, 323, 3232]", Arrays.toString(tokens));
	}
	

	/*
	 * public static boolean matches(String regex, CharSequence input)
	 * A convenience method that compiles the given regular expression 
	 * and attempts to match the given input against it.
	 */
	@Test
	public void testPatternMatches()
	{
		boolean result = Pattern.matches("0[0-7]+", "0715");

		assertTrue(result);
	}
	

	/*
	 * public String pattern()
	 * Returns the string representation of this pattern. This
	 * is the regular expression from which this pattern was
	 * compiled.
	 */
	@Test
	public void testPattern()
	{
		Pattern pattern = Pattern.compile("0[0-7]+");
		
		String regex = pattern.pattern();

		assertEquals("0[0-7]+", regex);
	}
}
