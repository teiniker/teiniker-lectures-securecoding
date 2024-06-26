# CWE/SANS Top 25 - 2022

This [CWE/SANS Top 25](https://cwe.mitre.org/top25/archive/2022/2022_cwe_top25.html) list
demonstrates the currently most common and impactful software weaknesses. Often easy to 
find and exploit, these can lead to exploitable vulnerabilities that allow adversaries to completely take over a system, steal data, or prevent applications from working.

1. **Out-of-bounds Write**\
    The software writes data past the end, or before the beginning, of the intended buffer.

2. **Improper Neutralization of Input During Web Page Generation (Cross-site Scripting)**\
    The software does not neutralize or incorrectly neutralizes user-controllable input before 
    it is placed in output that is used as a web page that is served to other users.

3. **Improper Neutralization of Special Elements used in an SQL Command (SQL Injection)**\
    The software constructs all or part of an SQL command using externally-influenced input 
    from an upstream component, but it does not neutralize or incorrectly neutralizes special 
    elements that could modify the intended SQL command when it is sent to a downstream component.

4. **Improper Input Validation**\
    The product receives input or data, but it does not validate or incorrectly validates that the input has the properties that are required to process the data safely and correctly.

5. **Out-of-bounds Read**\
    The software reads data past the end, or before the beginning, of the intended buffer.

6. **Improper Neutralization of Special Elements used in an OS Command (OS Command Injection)**\
    The software constructs all or part of an OS command using externally-influenced input from 
    an upstream component, but it does not neutralize or incorrectly neutralizes special elements that could modify the intended OS command when it is sent to a downstream component.

7. **Use After Free**\
    Referencing memory after it has been freed can cause a program to crash, use unexpected values, or execute code.

8. **Improper Limitation of a Pathname to a Restricted Directory (Path Traversal)**\
    The software uses external input to construct a pathname that is intended to identify a file or directory that is located underneath a restricted parent directory, but the software does not properly neutralize special elements within the pathname that can cause the pathname to resolve to a location that is outside of the restricted directory.

9. **Cross-Site Request Forgery (CSRF)**\
    The web application does not, or can not, sufficiently verify whether a well-formed, valid, 
    consistent request was intentionally provided by the user who submitted the request.

10. **Unrestricted Upload of File with Dangerous Type**\
    The software allows the attacker to upload or transfer files of dangerous types that can be 
    automatically processed within the product's environment.

11. **NULL Pointer Dereference**\
    A NULL pointer dereference occurs when the application dereferences a pointer that it expects to be valid, but is NULL, typically causing a crash or exit.

12. **Deserialization of Untrusted Data**\
    The application deserializes untrusted data without sufficiently verifying that the resulting data will be valid.

13. **Integer Overflow or Wraparound**\
    The software performs a calculation that can produce an integer overflow or wraparound, when the logic assumes that the resulting value will always be larger than the original value. 
    This can introduce other weaknesses when the calculation is used for resource management or 
    execution control.

14. **Improper Authentication**\
    When an actor claims to have a given identity, the software does not prove or insufficiently proves that the claim is correct.

15. **Use of Hard-coded Credentials**\
    The software contains hard-coded credentials, such as a password or cryptographic key, which it uses for its own inbound authentication, outbound communication to external components, or encryption of internal data.

16. **Missing Authorization**\
    The software does not perform an authorization check when an actor attempts to access a 
    resource or perform an action.

17. **Improper Neutralization of Special Elements used in a Command (Command Injection)**\
    The software constructs all or part of a command using externally-influenced input from an 
    upstream component, but it does not neutralize or incorrectly neutralizes special elements 
    that could modify the intended command when it is sent to a downstream component.

18. **Missing Authentication for Critical Function**\
    The product does not perform any authentication for functionality that requires a provable 
    user identity or consumes a significant amount of resources.

19. **Improper Restriction of Operations within the Bounds of a Memory Buffer**\
    The software performs operations on a memory buffer, but it can read from or write to a memory location that is outside of the intended boundary of the buffer.

20. **Incorrect Default Permissions**\
    During installation, installed file permissions are set to allow anyone to modify those files.

21. **Server-Side Request Forgery (SSRF)**\
    The web server receives a URL or similar request from an upstream component and retrieves the contents of this URL, but it does not sufficiently ensure that the request is being sent to the expected destination.

22. **Concurrent Execution using Shared Resource with Improper Synchronization (Race Condition)**\
    The program contains a code sequence that can run concurrently with other code, and the code sequence requires temporary, exclusive access to a shared resource, but a timing window exists in which the shared resource can be modified by another code sequence that is operating concurrently.

23. **Uncontrolled Resource Consumption**\
    The software does not properly control the allocation and maintenance of a limited resource, thereby enabling an actor to influence the amount of resources consumed, eventually leading to the exhaustion of available resources.

24. **Improper Restriction of XML External Entity Reference**\
    The software processes an XML document that can contain XML entities with URIs that resolve to documents outside of the intended sphere of control, causing the product to embed incorrect documents into its output.

25. **Improper Control of Generation of Code (Code Injection)**\
    The software constructs all or part of a code segment using externally-influenced input from an upstream component, but it does not neutralize or incorrectly neutralizes special elements that could modify the syntax or behavior of the intended code segment.

## References

* [2022 CWE Top 25 Most Dangerous Software Weaknesses](https://cwe.mitre.org/top25/archive/2022/2022_cwe_top25.html)

*Egon Teiniker, 2016-2024, GPL v3.0*	