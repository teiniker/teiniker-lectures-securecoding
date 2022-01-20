package org.se.lab;

import static org.junit.Assert.fail;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


/*
 * The unicode normalization form KC (NFKC - Compatibility
 * Decomposition,followed by Canonical Composition) is the
 * most suitable for performing input validation because the
 * input is transformed into an equivalent canonical form
 * that can be safely compared with the required form.
 */

public class StringNormalizationTest
{	
	private String s = "<script>";
//	private String s = "\uFE64" + "script" + "\uFE65";
	private Pattern pattern = Pattern.compile("[<>]");

	@Test
	public void testValidationWithoutNormalization()
	{
		System.out.println("input string = \"" + s + "\"");
		Matcher m = pattern.matcher(s);
		if(m.find())
		{
			System.out.println("found blacklist tag!");
		}
		else
		{
			fail("Blacklist tags not found!");
		}
	}


	/*
	 * This compliant solution normalizes the string before
	 * validating it. Alternative representations of the
	 * string are normalized to the canonical angle brackets.
	 */
	@Test
	public void testValidation()
	{
		s = Normalizer.normalize(s, Form.NFKC);

		System.out.println("input string = \"" + s + "\"");
		Matcher m = pattern.matcher(s);
		if(m.find())
		{
			System.out.println("found blacklist tag!");
		}
		else
		{
			fail("Blacklist tags not found!");
		}
	}
}
