package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public abstract class Person
	extends Entity
{
	public Person(long id, String firstName, String lastName, String email)
	{
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
	}
		
	
	/*
	 * Property: firstName
	 */
	private String firstName;
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		if(firstName == null)
			throw new IllegalArgumentException();
		this.firstName = firstName;
	}
	
	
	
	/*
	 * Property: lastName
	 */
	private String lastName;
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		if(lastName == null)
			throw new IllegalArgumentException();
		this.lastName = lastName;
	}
	
	
	
	/*
	 * Property: email
	 */
	private String email;
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		// email can be null!! [0-1]
		this.email = email;
	}
	
	
	/*
	 * Association: ---[*]-> courses:Course
	 */
	private List<Course> courses = new ArrayList<Course>();
	public void addCourse(Course course)
	{
		if(course == null)
			throw new IllegalArgumentException();
		courses.add(course);
	}
	public List<Course> getCourses()
	{
		return courses;
	}
	
	
	/*
	 * Object methods
	 */
	
	@Override
	public String toString()
	{
		return getId() + "," + getFirstName() + "," + getLastName() + "," + getEmail();
	}	
}
