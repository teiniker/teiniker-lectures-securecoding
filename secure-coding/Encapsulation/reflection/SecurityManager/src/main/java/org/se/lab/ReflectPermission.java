package org.se.lab;

import java.lang.reflect.Field;

public class ReflectPermission
{
	public static void main(String[] args)
	{
		try
		{
			User user = new User(7, "teini", "4m:7MyN9&M");
			Field id = user.getClass().getDeclaredField("id");			
			id.setAccessible(true); // Note that we access a private field!!!
			id.setInt(user, 17);
			int i = id.getInt(user);
			
			System.out.println("id = " + i);
		}
		catch (IllegalAccessException | NoSuchFieldException e)
		{
			System.err.println(e.getMessage());
		}
	}
}
