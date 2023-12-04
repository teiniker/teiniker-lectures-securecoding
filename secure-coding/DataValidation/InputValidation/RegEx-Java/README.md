# Java Regular Expression API

Regular expressions are a way to describe a set of strings based on common characteristics shared 
by each string in the set. They can be used to search, edit, or manipulate text and data.

The `java.util.regex` package primarily consists of three classes:
* A **Pattern** object is a compiled representation of a regular expression. 
  The `Pattern` class provides no public constructors. 
  To create a pattern, you must first invoke one of its public static compile methods, 
  which will then return a `Pattern` object.
* A **Matcher** object is the engine that interprets the pattern and performs match operations against 
  an input string. `Matcher` defines no public constructors. 
  We obtain a `Matcher` object by invoking the `matcher` method on a Pattern object.
* A **PatternSyntaxException** object is an unchecked exception that indicates a syntax error in a 
regular expression pattern.
     
_Example_: Match the input against a regular expression
```Java 
    final String regex = "0[0-7]+";
    final String input = "0715";
                        
    Pattern pattern = Pattern.compile(regex);
    Matcher m = pattern.matcher(input);
    boolean result = m.matches();
```

 Evaluating a regular expression can be **compute intensive**, and in many
 instances a single regular expression will be used repeatedly.
 This can be addressed by **compiling the regular expression once** and  using the result.
 
  Model of using a regular expression:
  * Turn the regular expression string into a `Pattern` object that is the compiled version of the `Pattern`.
  * Ask the Pattern object for a `Matcher` object that applies that `Pattern` to a character sequence     
    (`String`, `StringBuilder`).
  * Ask the `Matcher` to perform operations on the sequence using the compiled `Pattern`.   
 
## Class Matcher

A `Matcher` is created from a `Pattern` by invoking the pattern's `matcher` method. 
Once created, a `Matcher` can be used to perform three different kinds of **match operations**:
* The **matches** method attempts to match the entire input sequence against the pattern.
* The **lookingAt** method attempts to match the input sequence, starting at the beginning, 
    against the pattern.
* The **find** method scans the input sequence looking for the next subsequence that matches 
    the pattern.

Each of these methods **returns a boolean** indicating success or failure. 
More information about a successful match can be obtained by querying the state of the `Matcher`.

* **public boolean matches()**\
    Attempts to match the entire region against the pattern.
    If the match succeeds then more information can be obtained via the `start()`, 
    `end()`, and `group()` methods.
    Returns `true` if, and only if, a **subsequence of the input sequence** matches this `Matcher`'s 
    pattern.

* **public boolean lookingAt()**\
    Attempts to match the input sequence, **starting at the beginning of the region**, against the pattern.
    Like the matches method, this method always starts at the beginning of the region; 
    unlike that method, it does not require that the entire region be matched.    
    If the match succeeds then more information can be obtained via the `start()`, `end()`, and `group()` 
    methods.
    Returns `true` if, and only if, a **prefix of the input sequence** matches this matcher's pattern    

* **public boolean find()**\
    Attempts to find the **next subsequence** of the input sequence that matches the pattern.
    This method starts at the beginning of this `Matcher`'s region, or, if a previous invocation 
    of the method was successful and the `Matcher` has not since been reset, at the first character 
    not matched by the previous match.
    If the match succeeds then more information can be obtained via the `start()`, `end()`, and `group()` 
    methods.
    Returns `true` if, and only if, a **subsequence of the input sequence** matches this `Matcher`'s 
    pattern

* **public int start()**\
    Returns the **start index** of the previous match (index of the first character matched).
    
* **public int end()**\
    Returns the **offset** after the last character matched.   

* **public String group()**\
    Returns the **input subsequence matched** by the previous match.
    For a `Matcher` m with input sequence `s`, the expressions `m.group()` and `s.substring(m.start(), m.end())` 
    are equivalent.


* **public String replaceFirst(String replacement)**\
    Replaces the **first subsequence of the input sequence** that matches the pattern with the given replacement string.
    This method first resets this `Matcher`. It then scans the input sequence looking for a match of the pattern. 
    Returns the string constructed by replacing the first matching subsequence by the replacement string, substituting 
    captured subsequences as needed.
    
* **public String replaceAll(String replacement)**\
    Replaces **every subsequence of the input sequence** that matches the pattern with the given replacement string.    
    This method first resets this `Matcher`. It then scans the input sequence looking for matches of the pattern.
    
## References
[The Java Tutorials: Lesson: Regular Expressions](https://docs.oracle.com/javase/tutorial/essential/regex/)

[Java API: Matcher](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html)


*Egon Teiniker, 2020 - 2021, GPL v3.0* 
