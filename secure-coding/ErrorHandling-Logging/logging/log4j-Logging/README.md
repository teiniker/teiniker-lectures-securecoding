# Logging with log4j

Logging is an important component of the software development. 
A well-written logging code offers quick debugging, easy maintenance, 
and structured storage of an application’s runtime information.

Log4j is an open-source logging framework that allows software developers 
to log various data within their application and it is part of the Apache 
Logging Services. 


## Log4j Vulnerability  CVE-2021–44228 (also known as Log4Shell)

The Log4Shell vulnerability, officially known as CVE-2021-44228, is a critical 
security flaw in the Apache Log4j 2 library, a popular Java logging framework. 
This vulnerability became widely known in December 2021 and posed a significant 
threat to systems worldwide. 

The Log4Shell vulnerability is a **remote code execution (RCE) flaw**. 
It allows attackers to execute arbitrary code on a server or other computer 
running the vulnerable Log4j version (2.0 to 2.14.1).

Mechanism of Exploit:
* Log4j supports message lookup substitution, where it can interpret 
   and process special codes within log messages.
* The vulnerability arises when an attacker sends a specially crafted 
   string (like a username, header, etc.) that gets logged. 
* This string includes a **JNDI (Java Naming and Directory Interface)** 
   lookup request to a malicious LDAP (Lightweight Directory Access Protocol) 
   server controlled by the attacker.
* When Log4j processes this request, it inadvertently executes the code 
   fetched from the attacker's LDAP server.

Mitigation and Fixes:
* The immediate recommendation was to **update Log4j to version 2.15.0 or 
   later**, where this vulnerability was patched.
* For those who couldn’t update immediately, certain configurations and 
   JVM (Java Virtual Machine) parameters were suggested to mitigate the risk.


In Log4j, **message lookup** is a feature that allows log messages to 
include data from various sources, which are dynamically resolved at runtime. 


## Log File Analysis

**less** is a program similar to `more`, but which allows backward movement 
in the file as well as forward movement.
Also, `less` does not have to read the entire input file before starting, 
so with large input files it starts up faster than text editors like VS Code.

_Example_: Analyze a log file
```
$ less -R log/server.log
```
The option `-R` tells `less` to display "raw" control characters. 
In the context of log files, this is important because log files often contain 
color codes and other control characters. 
The `-R` option ensures that these control characters are processed and rendered 
correctly, displaying colors and formatting as intended, rather than showing them 
as plain text character sequences.

Shortcuts in `less`:
* `g`: go to the start of file
* `G`: go to the end of file
* `/pattern`: search for a pattern
* `n`: next match in forward
* `N`: next match in backward
* `&pattern`: display only the matching lines (not all)

We can open multiple files by passing the file names as arguments:
_Example_: Analyze multiple log files 
```
$ less -R file1.log file2.log
```

**egrep** searches the input files for lines containing a match to a given
regular expression. When it finds a match in a line, it copies the line
to standard output (by default).

_Example_:Search for names
```
$ egrep -n "WARN|ERROR" log/server.log
```


## References
* [Log4J Vulnerability (Log4Shell) Explained - for Java developers](https://youtu.be/uyq8yxWO1ls?si=N-A1ElYt5L3YFV_L)
* [Baeldung: Intro to Log4j2 – Appenders, Layouts and Filters](https://www.baeldung.com/log4j2-appenders-layouts-filters)
* [Baeldung: Log4j 2 Configuration Using a Properties File](https://www.baeldung.com/java-log4j2-config-with-prop-file)
* [How to Get Started with Log4j for Logging in Java](https://betterstack.com/community/guides/logging/how-to-start-logging-with-log4j/)