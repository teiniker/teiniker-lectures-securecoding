package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class User
{
	/*
	 * Constrcutor
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
// Vulnerability:		
//		return mails; // Return the reference to a private mutable object!!!

		// Defensively copy mutable outputs.
		List<EMail> list = new ArrayList<EMail>();
		for(EMail mail : mails)
			list.add(new EMail(mail.getAddress()));
		return list;
		
// Other possible solutions:				
//		return new ReadOnlyList<EMail>(mails); // read-only proxy
//		return Collections.unmodifiableList(mails);
	}
	
	public final void setMails(final List<EMail> mails)
	{
		if(mails == null)
			throw new IllegalArgumentException();
// Vulnerability:
//		this.mails = mails; // store an external reference in a private field!!!
		
		// Defensively copy mutable inputs.
		this.mails = new ArrayList<EMail>(); 
		for(int i=0; i< mails.size();i++)
			this.mails.add(new EMail(mails.get(i).getAddress()));
	}
		
	
	/*
	 * Object method
	 */

	public String toString()
	{
		return getUsername() + "," + getMails();
	}
}
