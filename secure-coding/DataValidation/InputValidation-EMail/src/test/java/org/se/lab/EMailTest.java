package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class EMailTest
{
	@Test
	public void testGetAddress()
	{
		EMail mail = new EMail("egon.teiniker@fhj.at");		
		Assert.assertEquals("egon.teiniker@fhj.at", mail.getAddress());
	}

	@Test
	public void testToString()
	{
		EMail mail = new EMail("egon.teiniker@fhj.at");		
		Assert.assertEquals("egon.teiniker@fhj.at", mail.toString());
	}
	
	@Test
	public void testValidAddresses()
	{
		new EMail("t-e-i-n-i-k-e-r@fh-joanneum.at");
		new EMail("e%g%o%n@fh-joanneum.at");
		new EMail("e_g_o_n@fh-joanneum.at");
		new EMail("e.g.o.n@fh-joanneum.at");
		new EMail("e+g-o+n-@fh-joanneum.at");
		new EMail("0815@fh-joanneum.at");
		
		new EMail("egon@f.h.j.at");
		new EMail("egon@f-h-j.at");
		new EMail("egon@0815.at");
		
		new EMail("egon@fhj.at");
		new EMail("egon@fhj.com");
		new EMail("egon@fhj.misc");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNull()
	{
		new EMail(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmpty()
	{
		new EMail("");
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidName_UpperCase()
	{
		new EMail("Egon@fh-joanneum.at");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidName_IllegalChar()
	{
		new EMail("eg*n@fh-joanneum.at");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidName_Missing()
	{
		new EMail("@fh-joanneum.at");
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCompany_UpperCase()
	{
		new EMail("egon@FHJ.at");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCompany_IllegalChar()
	{
		new EMail("egon@f*j.at");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCompany_Missing()
	{
		new EMail("egon@.at");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDomain_UpperCase()
	{
		new EMail("egon@fhj.AT");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDomain_IllegalChar()
	{
		new EMail("egon@fhj.a1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDomain_TooShort()
	{
		new EMail("egon@fhj.a");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDomain_TooLong()
	{
		new EMail("egon@fhj.austr");
	}
	

	@Test
	public void testEquals()
	{
		EMail m1 = new EMail("egon.teiniker@fhj.at");
		EMail m2 = new EMail("egon.teiniker@fhj.at");
		
		Assert.assertTrue(m1.equals(m2));
		Assert.assertTrue(m2.equals(m1));
	}
	
	@Test
	public void testHashCode()
	{
		EMail m1 = new EMail("egon.teiniker@fhj.at");
		EMail m2 = new EMail("egon.teiniker@fhj.at");
		
		Assert.assertEquals(m1.hashCode(), m2.hashCode());
	}
}
