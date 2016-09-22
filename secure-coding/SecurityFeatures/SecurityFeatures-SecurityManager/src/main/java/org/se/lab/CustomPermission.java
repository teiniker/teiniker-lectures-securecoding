package org.se.lab;

/*
 * Here we create our own permission to switch on and off the usage of a method.
 * 
 * $ java -cp ./target/classes -Djava.security.policy=my.policy -Djava.security.manager org.se.lab.CustomPermission
 */

public class CustomPermission
{
	 static final private java.security.Permission CUSTOM_PERMISSION =
			new RuntimePermission("customPermission");
	 
	public static void main(String[] args)
	{
		
		try
		{
			SecurityManager sm = System.getSecurityManager();
			if (sm != null) 
			{
				sm.checkPermission(CUSTOM_PERMISSION);
			}
			System.out.println("Blah...");
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
	}

}
