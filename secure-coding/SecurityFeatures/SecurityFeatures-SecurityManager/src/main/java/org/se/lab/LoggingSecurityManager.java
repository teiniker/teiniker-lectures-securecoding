package org.se.lab;

/*
 * To have a look on the used permissions we create a LoggingSecurityManager that
 * prints out all requested permissions.
 * 
 * $ java -cp ./target/classes -Djava.security.manager=org.se.lab.LoggingSecurityManager org.se.lab.PropertyPermission
 */

import java.security.Permission;

public class LoggingSecurityManager
	extends SecurityManager
{
	public void checkPermission(Permission perm) 
	{
		System.out.println(perm);
	}
}
