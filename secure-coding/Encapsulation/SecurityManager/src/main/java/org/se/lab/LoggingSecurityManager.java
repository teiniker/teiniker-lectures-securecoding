package org.se.lab;

import java.security.Permission;

public class LoggingSecurityManager
	extends SecurityManager
{
	public void checkPermission(Permission perm) 
	{
		System.out.println(perm);
	}
}
