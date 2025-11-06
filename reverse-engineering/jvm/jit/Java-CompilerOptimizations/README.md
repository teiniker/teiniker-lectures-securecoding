# Java Compiler Optimizations

In this example, we investigate optimizations that are performed by 
the Java compiler javac and the Java Virtual Machine (JVM).

Compiler optimizations are techniques used by compilers to improve 
the performance and efficiency of the generated code without altering 
its functionality. 

These optimizations include reducing code size, increasing execution 
speed, and optimizing resource usage. Common strategies include **loop 
unrolling** (to decrease loop overhead), **dead code elimination** (removing 
code that doesn't affect the program's outcome), and **inline expansion** 
(replacing function calls with the function's body). 

By performing these optimizations, compilers help ensure that the final 
executable program runs faster and more efficiently on the target hardware.


## Method Inlining
The javac compiler does not support method inlining. This optimization
is done by the JVM at runtime. 

_Example_: EmptyMethod.java
```Java
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
```

From the compiled bytecode we can see that call to empty method `EmptyMethod()` 
was not removed by the Java compiler (line 14).

```bash
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
```

Note that the JIT is addressing that problem.
At runtime, the empty method `EmptyMethod()` is compiled into 
a single byte by the JIT - and thus eliminated.

```bash
$ java -XX:+PrintCompilation -cp build org.se.lab.EmptyMethod
     68    1             java.lang.String::hashCode (55 bytes)
     78    2             java.lang.String::indexOf (70 bytes)
     85    3             sun.nio.cs.UTF_8$Encoder::encode (359 bytes)
     88    4             java.lang.String::charAt (29 bytes)
    106    5             java.lang.String::equals (81 bytes)
    117    6             java.lang.Object::<init> (1 bytes)
    123    7             org.se.lab.EmptyMethod::emptyMethod (1 bytes)
    133    8 %           org.se.lab.EmptyMethod::main @ 13 (27 bytes)
```

## Dead Code Elimination
This optimization allows a compiler to ignore code and 
variables that are never used.

_Example_: DeadCode.java
```Java
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
```

From the bytecode it can be seen that the if block, which certainly cannot 
be executed (the if condition is always `false`), has been eliminated.

```bash
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
```


## String Operations
Concatenation of immutable String objects can be a serious performance
problem, therefor the compiler addresses that problem:

_Example_: StringOperations.java
```Java
public class StringOperations
{
	private long id;
	private String username;
		
	public String toString1()
	{
		return "{" + id + "," + username + "}";
	}
    //...
}
```

```bash
$ javap -c target/classes/org.se.lab/StringOperations

Compiled from "StringOperations.java"
public class org.se.lab.StringOperations {
    public java.lang.String toString1();
    Code:
        0: aload_0
        1: getfield      #7                  // Field id:J
        4: aload_0
        5: getfield      #13                 // Field username:Ljava/lang/String;
        8: invokedynamic #17,  0             // InvokeDynamic #0:makeConcatWithConstants:(JLjava/lang/String;)Ljava/lang/String;
        13: areturn
...
}
```
Current Java compilers solve the problem by InvokeDynamic of `makeConcatWithConstants()`.

Older Java compilers replace string concatenation by using the `StringBuilder` class.
```bash
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
```

_Egon Teiniker, 2016-2025, GPL v3.0_