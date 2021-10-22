Java Compiler Optimizations
---------------------------------------------------------------------
In this project, we investigate optimizations that are performed by 
the Java compiler javac and the Java Virtual Machine (JVM).

Common compiler optimization techniques are method inlining, 
constant propagation, constant folding and dead code elimination. 


Method Inlining
---------------
The javac compiler does not support method inlining. This optimization
is done by the JVM at runtime. 

Example: EmptyMethod.java

public class EmptyMethod
{
	public void emptyMethod() {}
	
	
	public static void main(String... args)
	{
		EmptyMethod obj = new EmptyMethod();
		
		int i=0;
		while(i < 100000)
		{
			obj.emptyMethod();
			i++;
		}
		
	}
}

$ javap -c target/classes/org/se/lab/EmptyMethod.class 

Compiled from "EmptyMethod.java"
public class org.se.lab.EmptyMethod {
  public org.se.lab.EmptyMethod();
    Code:
       0: aload_0       
       1: invokespecial #8                  // Method java/lang/Object."<init>":()V
       4: return        

  public void emptyMethod();
    Code:
       0: return        

  public static void main(java.lang.String...);
    Code:
       0: new           #1                  // class org/se/lab/EmptyMethod
       3: dup           
       4: invokespecial #17                 // Method "<init>":()V
       7: astore_1      
       8: iconst_0      
       9: istore_2      
      10: goto          20
      13: aload_1       
      14: invokevirtual #18                 // Method emptyMethod:()V
      17: iinc          2, 1
      20: iload_2       
      21: ldc           #20                 // int 100000
      23: if_icmplt     13
      26: return        
}

Note that the JIT is addressing that problem:

$ java -XX:+PrintCompilation -cp build org.se.lab.EmptyMethod
     68    1             java.lang.String::hashCode (55 bytes)
     78    2             java.lang.String::indexOf (70 bytes)
     85    3             sun.nio.cs.UTF_8$Encoder::encode (359 bytes)
     88    4             java.lang.String::charAt (29 bytes)
    106    5             java.lang.String::equals (81 bytes)
    117    6             java.lang.Object::<init> (1 bytes)
    123    7             org.se.lab.EmptyMethod::emptyMethod (1 bytes)
    133    8 %           org.se.lab.EmptyMethod::main @ 13 (27 bytes)




Constant Propagation and Constant Folding
-----------------------------------------
Fixed-value variables in the source code are replaced by their values.
Constant folding replaces expressions with fixed values.


public class Constants
{
	public int doConstantFolding()
	{
		final int VERSION = 10 + 25 + 15;		
		return VERSION;
	}

	public int doConstantPropagation()
	{
		final int A = 111;
		final int B = 222;

		int c = A+B;
		return c + A; 
	}

	public int doSomething(int a, int b)
	{
		int c = a+b;
		return c + a; 
	}
}


$ javap -c target/classes/org/se/lab/Constants.class 

Compiled from "Constants.java"
public class org.se.lab.Constants {
  public org.se.lab.Constants();
    Code:
       0: aload_0       
       1: invokespecial #8                  // Method java/lang/Object."<init>":()V
       4: return        

  public int doConstantFolding();
    Code:
       0: bipush        50  				// Constant Folding
       2: istore_1      
       3: bipush        50
       5: ireturn       

  public int doConstantPropagation();
    Code:
       0: bipush        111
       2: istore_1      
       3: sipush        222
       6: istore_2      
       7: sipush        333
      10: istore_3      
      11: iload_3       
      12: bipush        111					// Constant Propagation
      14: iadd          
      15: ireturn       

  public int doSomething(int, int);
    Code:
       0: iload_1       
       1: iload_2       
       2: iadd          
       3: istore_3      
       4: iload_3       
       5: iload_1       
       6: iadd          
       7: ireturn       
}



Dead Code Elimination
---------------------
Allows a compiler to ignore code and variables that are never used.

public class DeadCode
{
	private final static boolean DEBUG = false; 
		
	public void operation()
	{
		if(DEBUG)
		{
			System.out.println("operation()");
		}
		
		// some code
	}	
}

$ javap -c target/classes/org/se/lab/DeadCode.class 

Compiled from "DeadCode.java"
public class org.se.lab.DeadCode {
  public org.se.lab.DeadCode();
    Code:
       0: aload_0       
       1: invokespecial #12                 // Method java/lang/Object."<init>":()V
       4: return        

  public void operation();
    Code:
       0: return 							// Dead code has been eliminated!!       
}



String Operations
-----------------
Concatenation of immutable String objects can be a serious performance
problem, therefor the compiler addresses that problem:

public class StringOperations
{
	private long id;
	private String username;
		
	
	public String toString1()
	{
		return "{" + id + "," + username + "}";
	}
	
$ javap -c target/classes/org.se.lab/StringOperations

Compiled from "StringOperations.java"
public class org.se.lab.StringOperations {

  public java.lang.String toString1();
    Code:
       0: new           #20                 // class java/lang/StringBuilder
       3: dup
       4: ldc           #22                 // String {
       6: invokespecial #24                 // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
       9: aload_0
      10: getfield      #27                 // Field id:J
      13: invokevirtual #29                 // Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
      16: ldc           #33                 // String ,
      18: invokevirtual #35                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      21: aload_0
      22: getfield      #38                 // Field username:Ljava/lang/String;
      25: invokevirtual #35                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      28: ldc           #40                 // String }
      30: invokevirtual #35                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      33: invokevirtual #42                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      36: areturn
	

	Note that this is no working across loops!
	In the toString3() example, only the string inside the loop is 
	concatenated using a StringBuilder. 
	
	public String toString3()
	{
		String s = "";		
		for(int i = 0; i<10; i++)
		{
			s = s + "i = " + i + "\n"; 
		}
		return s;
	}
	
    public java.lang.String toString3();
    Code:
       0: ldc           #50                 // String
       2: astore_1
       3: iconst_0
       4: istore_2
       5: goto          40
       8: new           #20                 // class java/lang/StringBuilder
      11: dup
      12: aload_1
      13: invokestatic  #52                 // Method java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
      16: invokespecial #24                 // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
      19: ldc           #58                 // String i =
      21: invokevirtual #35                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      24: iload_2
      25: invokevirtual #60                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      28: ldc           #63                 // String \n
      30: invokevirtual #35                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      33: invokevirtual #42                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      36: astore_1
      37: iinc          2, 1
      40: iload_2
      41: bipush        10
      43: if_icmplt     8
      46: aload_1
      47: areturn
		 
