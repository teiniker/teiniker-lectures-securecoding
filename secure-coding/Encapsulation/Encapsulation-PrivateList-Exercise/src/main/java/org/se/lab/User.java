package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class User
{
	/*
	 * Constructor
	 */
	public User(final String username, final List<EMail> mails)
	{
		setUsername(username);
		setMails(mails);
	}

	/*
	 * Property: username:String
	 */
	private String username;
	public final String getUsername()
	{
		return username;
	}
	public final void setUsername(final String username)
	{
		this.username = username;
	}

		
	/*
	 * Property: mails:EMail[*]
	 */
	private List<EMail> mails = new ArrayList<EMail>();
	public final List<EMail> getMails()
	{
		return mails; 
	}
	public final void setMails(final List<EMail> mails)
	{
		if(mails == null)
			throw new IllegalArgumentException();

		this.mails = mails; 
	}
		
	
	/*
	 * Object method
	 */

	public String toString()
	{
		return getUsername() + "," + getMails();
	}
}
