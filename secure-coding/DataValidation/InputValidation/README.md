# Input Validation

> **Input validation** is the process of verifying and ensuring that the data 
> provided by a user or an external system adheres to expected formats, types, 
> or constraints before being processed by an application. 

It is a crucial aspect of **application security** and functionality, protecting 
the system from invalid, malicious, or unintended inputs that could lead to:
* SQL Injection
* Cross-Site Scripting (XSS)
* Command Injection
* ...

## Techniques for Input Validation

### Boundary Checking

Boundary Checking validates that input is within acceptable numeric 
or length ranges.

_Example:_ Boundary checking for an numerical input:

```Java
if(age <= 0 || age > 120)
    throw new IllegalArgumentException("Age must be between 0 and 120")
```

### Regular Expressions

> A regular expression (RegEx) is a sequence of characters that define a 
> search pattern. 
> It is used for matching, searching, and manipulating text strings based 
> on defined rules or patterns. 

Regular expressions are a powerful tool in programming, text processing, and data validation.

* [Introduction](README.md)
* [grep Regex](RegEx/grep-regex/)
* [Java Regex](RegEx/RegEx-Java/)


## Techniques Used Together With Regular Expressions

### Normalization 

Normalization refers to **transforming input data into a standard, 
consistent format** before applying validations or processing. 

This step ensures that variations in input (e.g., different encodings, 
extra whitespace, or character representations) do not affect the 
matching or validation process.

In the context of RegEx, normalization is particularly important 
when dealing with **Unicode text**, where visually identical 
characters can have different binary representations.

_Example:_ Convert Unicode characters to a consistent representation
```Java
import java.text.Normalizer;

String normalizedInput = Normalizer.normalize(userInput, Normalizer.Form.NFKC);
```

### Whitelisting

Whitelisting is the practice of specifying a set of allowed patterns or 
characters and rejecting anything that does not conform. This is a 
restrictive approach, where only explicitly permitted inputs are 
considered valid.

Whitelisting is used to enforce strict rules, allowing only well-defined 
inputs and excluding all others.

_Example:_ Whitelisting in Java
```Java
String filenameRegex = "^[a-zA-Z0-9_]+\\.(txt|jpg|png)$";
```

* Allows filenames like document.txt or image.png.

* Rejects filenames with special characters or unsupported extensions.


### Blacklisting

Blacklisting is the practice of specifying a set of patterns or 
characters that are explicitly disallowed. Inputs matching the 
blacklisted patterns are rejected, while everything else is permitted.

Blacklisting is useful when there is a specific set of known patterns 
that must be avoided, such as special characters or malicious strings.

_Example:_ Blacklisting Using RegEx
```Java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

String sqlInjectionRegex = "(;|--|\\b(OR|AND)\\b)";
Pattern pattern = Pattern.compile(sqlInjectionRegex, Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher(userInput);

if (matcher.find()) 
{
  throw new IllegalArgumentException("Potential SQL injection detected");
}
```

* Protects against specific threats or unwanted patterns.

* Useful for adding additional safeguards on top of whitelisting.


## Value Object and Validation Proxy

In an application, **input validation must be performed consistently**.

Two design patterns that can help with this are:

* **Value Object**:
  * [Introduction](ValueObject/README.md)
  * Exercise: [Mail](ValueObject/EMail-Exercise/) ([Model Solution](ValueObject/EMail/))
  * Exercise: [Date](ValueObject/Date-Exercise/) ([Model Solution](ValueObject/Date/))
  
* **Validation Proxy**:
  * [Introduction](ValidationProxy/README.md)
  * Exercise: [ArticleService](ValidationProxy/ArticleService-Exercise/) ([Model Solution](ValidationProxy/ArticleService/))
  * Exercise: [NetworkService](ValidationProxy/NetworkService-Exercise/) ([Model Solution](ValidationProxy/NetworkService/))


*Egon Teiniker, 2016-2024, GPL v3.0*
