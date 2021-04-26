package org.se.lab;

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
			throw new IllegalStateException(e);
		}
	}

}
