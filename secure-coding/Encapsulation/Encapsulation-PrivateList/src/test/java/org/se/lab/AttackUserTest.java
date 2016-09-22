package org.se.lab;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.EMail;
import org.se.lab.User;

public class AttackUserTest
{
	private User user;
	
	@Before
	public void setup()
	{
		List<EMail> list = new ArrayList<EMail>();
		list.add(new EMail("egon.teiniker@fhj.at"));
		list.add(new EMail("teiniker@gmx.com"));
		
		user = new User("teini", list);
	}
	@Test
	public void testAttack_RemoveUsersMails()
	{
		user.getMails().clear();	
		Assert.assertEquals(2,user.getMails().size());
	}
	
	
	@Test
	public void testAttack_InjectWrongMailAddressToUser()
	{
		user.getMails().set(1, new EMail("devil@hell.com"));
		
		final String expected = "teini,[egon.teiniker@fhj.at, teiniker@gmx.com]";
		Assert.assertEquals(expected, user.toString());
	}
	
	
	@Test
	public void testAttack_ChangingPassedMailList()
	{
		List<EMail> list = new ArrayList<EMail>();
		list.add(new EMail("egon.teiniker@fhj.at"));
		list.add(new EMail("teiniker@gmx.com"));
		user.setMails(list);

		list.set(1, new EMail("devil@hell.com"));
		final String expected = "teini,[egon.teiniker@fhj.at, teiniker@gmx.com]";
		Assert.assertEquals(expected, user.toString());		
	}

    
    @Test
    public void testAttack_MailAddress()
    {
        user.getMails().get(0).setAddress("devil@hell.com");
        
        final String expected = "teini,[egon.teiniker@fhj.at, teiniker@gmx.com]";
        Assert.assertEquals(expected, user.toString());
    }
}
