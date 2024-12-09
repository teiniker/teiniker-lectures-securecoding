# Validation Proxy Pattern 

The Validation Proxy pattern is a design pattern used in secure software 
development, particularly in scenarios where **input validation** or certain 
**precondition checks** are necessary before the execution of a method or 
access to an object.

The Validation Proxy pattern is **based on the Proxy design pattern**. 
In the Proxy pattern, a surrogate or placeholder object controls access 
to another object, which could be a remote, expensive to create, or needs 
to be secured.

In the context of the Validation Proxy pattern, the proxy object's primary 
responsibility is to perform validations or checks before delegating the 
call to the actual object.

By ensuring that all inputs or conditions are validated before any significant 
action is taken, this pattern can **enhance the security and robustness** 
of the application.

**Benefits** of using the Validation Proxy pattern:

* **Improved Security**: By validating inputs or conditions upfront, the 
  pattern helps in preventing various kinds of attacks and data integrity issues.

* **Separation of Concerns**: It keeps validation logic separate from business 
  logic, leading to cleaner and more maintainable code.

* **Reusability**: The validation logic in proxies can often be reused across 
  different parts of the application.

Introducing a proxy layer can add overhead to method calls and might lead to 
overcomplicate the design.

## References
* Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides ("Gang of Four").
  **Design Patterns: Elements of Reusable Object-Oriented Software**.
  Prentice Hall, 1997.

*Egon Teiniker, 2016-2024, GPL v3.0*