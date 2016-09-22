package org.se.lab;

/*
 * $ java -cp ./target/classes -Djava.security.policy=my.policy -Djava.security.manager org.se.lab.PropertyPermission
 */

public class PropertyPermission
{
	public static void main(String[] args)
	{
		String p = System.getProperty("user.home");	
		System.out.println(p);
		
	}
}
