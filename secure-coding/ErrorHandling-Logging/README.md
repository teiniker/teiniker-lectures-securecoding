# Exception Handling

Exceptions can **improve a program's readability, reliability, and maintainability**.
When used improperly, they can have the opposite effect.

## Use Exceptions Only for Exceptional Conditions

Exceptions are, as their name implies, to be used only for exceptional conditions.
**They should never be used for ordinary control flow**.

This principle also has implications for API design.
A well-designed API must not force its clients to use exceptions for ordinary control flow.

_Example_: Infinite loop terminates by throwing, catching, and ignoring an Exception.
```Java
    try
    {
        while(true)
        {
            // do something
            if(count > 1000)
                throw new MaximumCountReachedException();
        }   
    }
    catch(MaximumCountReachedException e) {}
    // continue execution
```
Not only does the exception-based loop obfuscate the prpose of the code and reduce its performance,
but it's not guaranteed to work.
If there is a bug in the loop, the use of exceptions for flow control can mask the bug, complicating the 
debugging process.

## Use Checked Exceptions for Recoverable Conditions and Runtime Exceptions for Programming Errors

Java provides three kinds of throwables: checked exceptions, runtime exceptions, and errors.

The cardinal rule in deciding whether to use a checked or an unchecked exception is this:
**Use checked exceptions for conditions from which the caller can reasonably be expected to recover**.
By throwing a checked exception, we force the caller to handle the exception in a `catch` clause or to
propagate it outward. By confronting the user with a checked exception, the API designer presents a mandate 
to recover from the condition. 
Provide methods on checked exceptions to aid in recovery.

If a program throws an **unchecked exception** or an **error**, it is generally the case that recovery is impossible and 
continued execution would do more harm than good.

**Use runtime exceptions to indicate programming errors.**
The great majority of runtime exceptions indicate **precondition violations**.
A precondition violation is simply a failure by the client of an API based on the contract established by the API
specification.
**All of the unchecked throwables we implement should subclass RuntimeException** (directly or indirectly). 

There is a strong convention that **errors** are reserved for use by the JVM to indicate resource deficiences, 
invariant failures, or other conditions that make it impossible to continue execution.

## Favor the Use of Standard Exceptions

The Java libraries provide a set of exceptions that covers most of the exception-throwing needs of most APIs.
Reusning standard exceptions make an API easier to learn and use because it matches the established conventions that 
programmers are already familiar with.

**Do not reuse Exception, RuntimeException, Throwable, or Error directly.**

The most commonly reused exception type is **IllegalArgumentException**.
This is the exception to throw when the caller passes in an arguent whose value is inapproriate.

If a caller passes null in some parameter for which null values are prohibited, convention dictates that 
**NullPointerException** be thrown rather than `IllegalArgumentException`.
Similarly, if a caller passes out-of-range value in a parameter representing an index into a sequence, 
**IndexOutOfBoundsException** should be thrown rather than IllegalArgumentException.

Another commonly reused exception is **IllegalStateException**. This is generally the exception to throw if the invocation 
is illegal because of the state of the receiving object.

The **UnsupportedOperationException** is thrown if an object does not support an attempted operation.
This exception is used by classes that fail to implement one or more optional operations defined by an interface 
they implement.

It would be appropriate to reuse **ArithmeticException** and **NumberFormatException** if you were implementing arithmetic 
objects such as complex numbers or rational numbers.

If an exception fits your needs, go ahead and use it, but only if the conditions under which you would throw it are 
consistent with the exception's documentation: **Reuse must be based on documented semantics, not just on name**.
 

## Don't Ignore Exceptions

When the designers of an API declare a method to throw an exception, they are trying to tell you something - 
Don't ignore it!

_Example_: Empty catch block ignores exception. 
```Java
    try
    {
        // do something
    }
    catch(IOException e)
    {
    } 
```
**An empty catch block defeats the purpose of the exceptions**, which is to force us to handle exceptional conditions.

Ignoring an exception with an empty `catch` block will result in a program that continues silently in the face of error.


## Throw Exceptions Appropriate to the Abstraction

It is awkward when a method throws an exception that has no apparent connection to the task that it performs.
This often happens when a method propagates an exception thrown by a lower-level abstraction.
Not only is it disconcerting, but it pollutes the API of the higher layer with implementation details.
If the implementation changes in a later release, the exceptions it throws will change too, potentially breaking 
existing client programs.

**Higher layers should catch lower-level exceptions and throw exceptions that can be explained in terms 
of the higher-level abstraction.** This is known as **exception translation**.
_Example_: Exception translation
```Java
    try
    {
        pstmt = getConnection().prepareStatement(SQL);
        pstmt.setLong(1, user.getId());
        pstmt.executeUpdate();
    } 
    catch(SQLException e)
    {
        throw new DAOException("Can't delete entity!", e);
    }
```
A special form of exception translation called **exception chaining** (exception wrapping) is used in cases where the 
lower-level exception might be helpful to someone debugging the problem that caused the higher-level exception.
**The lower-level exception (the cause) is passed to the higher-level exception**, which provides an accessor method 
(`getCause()`) to retrive the lower-level exception.
Exception chaining also integrates the cause's **stack trace** into that of the higher-level exception.

Most standard exceptions have chaining-aware constructors.


## Document All Exceptions Thrown by Each Method

A description of the exceptions thrown by a method is an important part of the documentation required to use the 
method properly.

**Always declare checked exceptions individually, and document precisely the conditions under which each one is thrown**
using the Javadoc `@throws` tag.

While the language does not require programmers to declare the **unchecked exceptions** that a method is capable of 
throwing, it is wise to **document them as carefully as the checked exceptions**.
Unfortunately, documenting all of the unchecked exceptions that each method can throw is an ideal, not always
achivable in the real world.


## Exceptions and Resource Management

**Resources** such as input and output streams or database connections **must be closed in any case**, regardless of 
whether the try block is terminated normally or by an exception.

We can use the **finally statement** to close resources because the `finally` block will be executed in either case.

_Example_: Using a finally statement
```Java
    BufferedReader br = null;
    try
    {
        br = new BufferedReader(new FileReader(path));
        return br.readLine();
    }
    catch(IOException e)
    {
        throw new IllegalStateException("Can't read from " + path, e);
    }
    finally
    {
        try
        {
            if (br != null)
                br.close();
        }
        catch(IOException e)
        {
            LOG.error("Can't close the buffered reader", e);
        }
    }
```

Since Java 7 we can use the **try-with-resources** statement which is a `try` statement that declares one 
or more resources. A resource is an object that must be closed after the program is finished with it. 
The try-with-resources statement ensures that each resource is closed at the end of the statement. 

_Example_: Using a try-with-resources statement.
```Java
    try (BufferedReader br = new BufferedReader(new FileReader(path)))
    {
        return br.readLine();
    }
    catch(IOException e)
    {
        throw new IllegalStateException("Can't read from " + path, e);
    }
```
Any object that implements `java.lang.AutoCloseable`, which includes 
all objects which implement `java.io.Closeable`, can be used as a resource.


## Exceptions and Logging

**Logging statements are used for debugging** in many applications. 
In addition to public method calls, critical states and errors are also written to the log file.

**Exception stack traces** are a great help in debugging and should therefore be recorded in the event of errors.
A problem arises when the same exception stack trace appears several times in the log file - this makes troubleshooting 
more tedious.

The following rule therefore applies when we catch an exception: **Either log the exception, or throw it 
(exception translation), but never do both.** (see _Example_: Using a finally statement)

There is one exception to this rule. At a **trust boundary**, the exception stack trace is written to the log file and an 
exception with a displayable error message is thrown on. 
This prevents details of the implementation from leaking out.

_Example_: Service layer operation
```Java
public void addUser(String firstName, String lastName,	String username, String password) 
	{
		logger.debug("addUser(" + firstName + "," + lastName + "," + username + ")");

		// Input Validation

		try
		{
			txBegin();
			String hashValue = PasswordEncoder.toHashValue(password);
			getUserDAO().createUser(firstName,lastName, username, hashValue);
			txCommit();
		}
		catch(DAOException e)
		{
			txRollback();
			logger.error(e); // Log stack trace instead of passing it to the presentation
			throw new ServiceException("Can't add user " + username);
		}
		catch(Exception e)  // Safety net to catch all exceptions.
		{
			txRollback();
			logger.error(e); // Log stack trace instead of passing it to the presentation
			throw new ServiceException("Unknown error during adding: " + username);			
		}
	}
```
In a **layered architecture**, all exceptions are caught in the **service layer**, the stack trace is written to 
the log file and a service exception with an error message is passed on to the **presentation layer**.



## Resources
* Joshua Bloch. **Effective Java**. Addison-Wesley, 3rd Edition 2018.
    Chapter 10: Exceptions
    
* [Exception Handling in Java](https://www.baeldung.com/java-exceptions)    
* [10 Best Practices to Handle Java Exceptions](https://www.javacodegeeks.com/10-best-practices-to-handle-java-exceptions.html)