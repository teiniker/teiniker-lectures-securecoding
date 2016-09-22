package org.se.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.se.lab.EMail;


public class EMailTest

{
	@Test
	public void testToString()
	{
		EMail mail = new EMail("egon.teiniker@fh-joanneum.at");
		assertEquals("egon.teiniker@fh-joanneum.at", mail.toString());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNull()
	{
		new EMail(null);
	}


	@Test
	public void testEquals()
	{
		EMail mail1 = new EMail("egon.teiniker@fhj.at");
		EMail mail2 = new EMail("egon.teiniker@fhj.at");

		assertFalse(mail1 == mail2);
		assertTrue(mail1.equals(mail2));
	}
}
