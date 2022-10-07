package org.se.lab;

public class ControlStructures
{
	public boolean ifStatement(int i)
	{
		int value = 3; 
		boolean result;
		
		if(value == i)
		{
			result = true; 
		}
		else
		{
			result = false;
		}
		return result;
	}
//	  public boolean ifStatement(int);
//	         0: iconst_3      			// push constant 3
//	         1: istore_2				// value = pop     
//	         2: iload_2       			// push value
//	         3: iload_1       			// push i
//	         4: if_icmpne     12		// compare and jump if not equal

//	         7: iconst_1 				// push constant 1     
//	         8: istore_3      			// result = pop
//	         9: goto          14		// goto

//	        12: iconst_0      			// push constant 0
//	        13: istore_3      			// result = pop

//	        14: iload_3       			// push result 
//	        15: ireturn       			// return

}
