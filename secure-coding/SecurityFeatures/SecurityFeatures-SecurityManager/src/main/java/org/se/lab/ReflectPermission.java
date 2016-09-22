package org.se.lab;

import java.lang.reflect.Field;


/*
 * $ java -cp ./target/classes -Djava.security.policy=my.policy -Djava.security.manager org.se.lab.ReflectPermission
 */

public class ReflectPermission
{
	public static void main(String[] args)
	{
		try
		{
			User user = new User(7, "teini", "*****");
			Field id = user.getClass().getDeclaredField("id");			
			id.setAccessible(true); // Note that we access a private field!!!
			id.setInt(user, 17);
			int i = id.getInt(user);
			
			System.out.println("id = " + i);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
