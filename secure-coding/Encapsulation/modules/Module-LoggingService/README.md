# Example: Module-LoggingService

In this example we create a Java9 Module which uses another **System Module**.

## Implementing the Module
Here we create the simplest possible Module containing only one public package.

```
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       ├── module-info.java
│   │       └── org
│   │           └── se
│   │               └── lab
│   │                   ├── LoggerService.java
│   │                   └── Main.java
```

In the **Module Descriptor**, we define that the *org.se.lab* package is public and we use the *java.logging* sytem module. 
Note that the *java.base* system module is included by default (therefore it is not necessary to add this requires statement).
```
module loggingservice 
{
	exports org.se.lab;

	requires java.logging;
	requires java.base; // default
}
```

To build the Module we create a jar file using the Maven build tool.

```
$ mvn package

$ tree target/
target/
├── classes
│   ├── module-info.class
│   └── org
│       └── se
│           └── lab
│               ├── LoggerService.class
│               └── Main.class
├── Module-LoggingService-0.0.1-SNAPSHOT.jar
```

## Running the Module

We start the main class of our module from the command line:
```
    $ java -p target/Module-LoggingService-0.0.1-SNAPSHOT.jar -m loggingservice/org.se.lab.Main
```

We have used a flag to specify the **module and its main class** we want to start:
```
    -m loggingservice/org.se.lab.Main
```
together with the **module path** needed:
```
    -p target/Module-LoggingService-0.0.1-SNAPSHOT.jar
```

The classic way of specifying the **CLASSPAH** also works here, but keep in mind that the compiler is checking the 
model dependencies and visibility of packages. 
```
    $ java -cp target/classes/ org.se.lab.Main
```

## References
* [Java Platform, Standard Edition & Java Development Kit Version 17 API Specification](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
* [A Guide to Java 9 Modularity](https://www.baeldung.com/java-9-modularity)
* Sander Mak and Paul Bakker, *Java 9 Modularity: Patterns and Practices for Developing Maintainable Applications*, O'Reilly, 2017

*Egon Teiniker, 2020-2022, GPL v3.0*
