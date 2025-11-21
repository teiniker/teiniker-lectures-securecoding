# Error Handling

Proper error handling in Java programming is essential for creating 
robust, reliable, and maintainable applications. It ensures that the 
application can gracefully handle unexpected situations and continue 
to function correctly or fail gracefully.

* [Java Exceptions](https://github.com/teiniker/teiniker-lectures-java/tree/main/java-basics/oop/exceptions)

* [Exception Handling in Software Architectures](https://github.com/teiniker/teiniker-lectures-softwarearchitectures/tree/master/layered/domain/error-handling/exception-handling)


## Exploiting Error Messages

Hackers can extract information from an application during an actual attack.
This mainly involves interacting with the application in unexpected and malicious 
ways. 

Many applications return **informative error messages when unexpected events occur**.
These may range from simple build-in messages that disclose only the category 
of the error, to full-blown debugging information that gives away a lot of detail 
about the application's state.


## Preventing Information Leakage

Measures that can be taken to reduce information leakage:

* **Use Generic Error Messages**: 
    The application should never return verbose error messages or debug
    information to the user.
    When an unexpected event occurs, the application should return the
    same, **generic message informing the user that an error occurred**.

* **Protect Sensitive Information**:
  The application should not publish information that may be of use to an
  attacker, including usernames, log entries, or user profile details.


## Testing Exception Handling

**Code Coverage** measurement ensures comprehensive testing of 
exception handling:

* **Validation of Error Handling Logic**: High code coverage includes 
  testing all exception handling blocks, ensuring that errors are 
  handled as intended.

* **Identifies Unreachable Code**: Code coverage tools can reveal 
  untested exception-handling logic, such as a catch block that is 
  never triggered during tests. 
  This might indicate missing test cases or unreachable code.

In order to test exception handling we usually have to use 
[Test Doubles](https://github.com/teiniker/teiniker-lectures-softwaredesign/tree/master/software-quality/unit-tests/doubles) like **stubs** or **mocks**.


## Resources
* Joshua Bloch. **Effective Java**. Addison-Wesley, 3rd Edition 2018.
    Chapter 10: Exceptions

*Egon Teiniker, 2016-2024, GPL v3.0* 
