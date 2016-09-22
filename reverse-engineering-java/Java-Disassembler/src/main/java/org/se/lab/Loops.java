package org.se.lab;

// $ javap -v -c build/org/se/lab/Loops.class

public class Loops
{
	public void emptyForLoop()
	{
		for(int i = 0; i < 10; i++)
		{
			
		}
	}
	
//	  public void emptyForLoop();
//	         0: iconst_0 					// push int constant 0     
//	         1: istore_1      				// store into local variable 1 
//	         2: goto          8				// first time don't increment
//	         5: iinc          1, 1			// increment local variable 1 by 1
//	         8: iload_1       				// push local variable 1
//	         9: bipush        10			// push int constant 100
//	        11: if_icmplt     5				// compare and loop if less than (i < 100)
//	        14: return        				// return void when done

	
	public void emptyForLoopShort()
	{
		for(short i = 0; i < 10; i++)
		{
			
		}
	}
	
//	  public void emptyForLoopShort();
//	         0: iconst_0      
//	         1: istore_1      
//	         2: goto          10
//	         5: iload_1				// short is used as an int       
//	         6: iconst_1      
//	         7: iadd          
//	         8: i2s           		// truncate into short
//	         9: istore_1      
//	        10: iload_1       
//	        11: bipush        10
//	        13: if_icmplt     5
//	        16: return        

	
	
	public void emptyWhileLoop()
	{
		int i=0;
		while(i < 10)
		{
			i++;
			
		}
	}
//	 public void emptyWhileLoop();	// same code as with for loop
//	         0: iconst_0      
//	         1: istore_1      
//	         2: goto          8
//	         5: iinc          1, 1
//	         8: iload_1       
//	         9: bipush        10
//	        11: if_icmplt     5
//	        14: return        

	
	public void emptyDoWhileLoop()
	{
		int i=0;
		do
		{
			
			i++;
		}while(i < 10);
	}
//	 public void emptyDoWhileLoop();
//	         0: iconst_0      
//	         1: istore_1      
//	         2: iinc          1, 1
//	         5: iload_1       
//	         6: bipush        10
//	         8: if_icmplt     2			
//	        11: return        
	
}
