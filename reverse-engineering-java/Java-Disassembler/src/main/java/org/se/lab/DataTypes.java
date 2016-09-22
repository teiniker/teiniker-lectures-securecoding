package org.se.lab;

public class DataTypes
{

	@SuppressWarnings("unused")
	public void primitiveTypes()
	{
		int i = 100;
		int j = 1000000;
		long l1 = 1;
		long l2 = 0xffffffff;
		double d = 3.14;

		//...
	}

//	Constant pool:
//		   #1 = Class              #2             //  org/se/lab/DataTypes
//		   #2 = Utf8               org/se/lab/DataTypes
//		   #3 = Class              #4             //  java/lang/Object
//		   #4 = Utf8               java/lang/Object
//		   #5 = Utf8               <init>
//		   #6 = Utf8               ()V
//		   #7 = Utf8               Code
//		   #8 = Methodref          #3.#9          //  java/lang/Object."<init>":()V
//		   #9 = NameAndType        #5:#6          //  "<init>":()V
//		  #10 = Utf8               LineNumberTable
//		  #11 = Utf8               LocalVariableTable
//		  #12 = Utf8               this
//		  #13 = Utf8               Lorg/se/lab/DataTypes;
//		  #14 = Utf8               primitiveTypes
//		  #15 = Integer            1000000
//		  #16 = Long               -1l
//		  #18 = Double             3.14d
//		  #20 = Utf8               i
//		  #21 = Utf8               I
//		  #22 = Utf8               j
//		  #23 = Utf8               l1
//		  #24 = Utf8               J
//		  #25 = Utf8               l2
//		  #26 = Utf8               d
//		  #27 = Utf8               D
//		  #28 = Utf8               SourceFile
//		  #29 = Utf8               DataTypes.java
	
//	  public void primitiveTypes();
//    Code:
//        stack=2, locals=9, args_size=1	
//	         0: bipush        100				// push byte as int
//	         2: istore_1     					// store in local var[1] - i 
//	         3: ldc           #15               // push constant (int 1000000)
//	         5: istore_2      					// store in local var[2] - j
//	         6: lconst_1      					// push long 1L
//	         7: lstore_3      					// sore in local var[3+4] - l1
//	         8: ldc2_w        #16               // push long constant -1L
//	        11: lstore        5					// store in local var[5+6] - l2
//	        13: ldc2_w        #18               // push double constant 3.14d
//	        16: dstore        7					// store in local var[7+8]
//	        18: return        
}
