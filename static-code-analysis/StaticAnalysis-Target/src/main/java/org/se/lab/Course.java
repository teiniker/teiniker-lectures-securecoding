package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Course
	extends Entity
{
	/*
	 * Constructor
	 */
	public Course(long id, String title, int sws, int ects, CourseType type, String semester)
	{
		setId(id);
		setTitle(title);
		setSws(sws);
		setEcts(ects);
		setType(type);
		setSemester(semester);
	}
	
	
	
	/*
	 * Property: title:String
	 */
	private String title;
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		if(title == null)
			throw new IllegalArgumentException();
		this.title = title;
	}
	
	
	/*
	 * Property: sws:int
	 */
	private int sws;
	public int getSws()
	{
		return sws;
	}
	public void setSws(int sws)
	{
		if(sws < 0)
			throw new IllegalArgumentException();
		this.sws = sws;
	}
	
	
	/*
	 * Property: ects:int
	 */
	private int ects;
	public int getEcts()
	{
		return ects;
	}
	public void setEcts(int ects)
	{
		if(ects < 0)
			throw new IllegalArgumentException();
		this.ects = ects;
	}
	
	
	/*
	 * Property: type:CourseType
	 */
	private CourseType type;
	public CourseType getType()
	{
		return type;
	}
	public void setType(CourseType type)
	{
		if(type == null)
			throw new IllegalArgumentException();
		this.type = type;
	}
	
	
	/*
	 * Property: semester
	 */
	private String semester;
	public String getSemester()
	{
		return semester;
	}
	public void setSemester(String semester)
	{
		if(semester == null)
			throw new IllegalArgumentException();
		this.semester = semester;
	}
	
	
	
	/*
	 * Association: ---[1]-> lecturer:Lecturer
	 */
	private Lecturer lecturer;
	public Lecturer getLecturer()
	{
		return lecturer;
	}
	public void setLecturer(Lecturer lecturer)
	{
		if(lecturer == null)
			throw new IllegalArgumentException();
		this.lecturer = lecturer;
	}
	
		
	/*
	 * Association: ---[*]-> studends:Student
	 */
	private List<Student> students = new ArrayList<Student>();
	public void addStudent(Student student)
	{
		if(student == null)
			throw new IllegalArgumentException();
		students.add(student);
	}
	public List<Student> getStudents()
	{
		return students;
	}
	
}
