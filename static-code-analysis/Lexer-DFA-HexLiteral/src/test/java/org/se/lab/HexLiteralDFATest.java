package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HexLiteralDFATest
{
	// HEX_LITERAL = 0x[0-9a-z]+
	
	private HexLiteralDFA dfa;
	
	@Before
	public void setup()
	{
		dfa = new HexLiteralDFA();
	}
	@Test
	public void testHexLiterals()
	{
		Assert.assertTrue(dfa.isAccepted("0x0"));
		Assert.assertTrue(dfa.isAccepted("0xd2"));
		Assert.assertTrue(dfa.isAccepted("0x00d2"));
		Assert.assertTrue(dfa.isAccepted("0xffd2"));
		
		Assert.assertTrue(dfa.isAccepted("0x0123456789012345678901234567890"));
	}


	@Test
	public void testHexLiterals_NoPrefix1()
	{
		Assert.assertFalse(dfa.isAccepted("0"));
	}

	
	@Test
	public void testHexLiterals_NoPrefix2()
	{
		Assert.assertFalse(dfa.isAccepted("12"));
	}

	
	@Test
	public void testHexLiterals_NoNumber()
	{
		Assert.assertFalse(dfa.isAccepted("0x"));
	}

	@Test
	public void testHexLiterals_IllegalNumber()
	{
		Assert.assertFalse(dfa.isAccepted("0x00x00"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testHexLiterals_IllegalInputSymbol1()
	{
		Assert.assertFalse(dfa.isAccepted("gx00"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testHexLiterals_IllegalInputSymbol2()
	{
		Assert.assertFalse(dfa.isAccepted("0y00"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testHexLiterals_IllegalInputSymbol3()
	{
		Assert.assertFalse(dfa.isAccepted("0xg0"));
	}
}
