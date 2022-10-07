package org.se.lab;

public class InvokingMethods
{
//	  public org.se.lab.InvokingMethods();
//	    flags: ACC_PUBLIC
//	    Code:
//	      stack=1, locals=1, args_size=1
//	         0: aload_0       
//	         1: invokespecial #8                  // Method java/lang/Object."<init>":()V
//	         4: return        


	public int add(int a, int b)
	{
		return a+b;
	}
//	  public int add(int, int);
//	    flags: ACC_PUBLIC
//	    Code:
//	      stack=2, locals=3, args_size=3
								// local var[0] - this pointer
//	         0: iload_1			// push local var[1] - a       
//	         1: iload_2       	// push local var[2] - b
//	         2: iadd          	// perform add and push result
//	         3: ireturn       	// return int value

	
	
	
	public static int addStatic(int a, int b)
	{
		return a+b;
	}
//	  public static int addStatic(int, int);
//	    flags: ACC_PUBLIC, ACC_STATIC
//	    Code:
//	      stack=2, locals=2, args_size=2
//	         0: iload_0       	// push local var[0] - a 
//	         1: iload_1       	// push local var[1] - b
//	         2: iadd          
//	         3: ireturn     	
}
