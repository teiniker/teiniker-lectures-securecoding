# Example: Module-TranslatorService

In this example, we implement a Java 9 Module which can be used as a library.

## Implementing a Module
When we create a module, we organize the code internally in packages just like we previously did with any other project.

```
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       ├── module-info.java
│   │       └── org
│   │           └── se
│   │               └── lab
│   │                   ├── api
│   │                   │   └── TranslatorService.java
│   │                   └── impl
│   │                       └── German2EnglishTranslator.java
```

In the **Module Descriptor**, we need to list all packages we want to be public because by default all packages are 
module private.

```
module translatorService
{
    exports org.se.lab.api;
}
```

To build the Module we create a jar file and install it into the Maven repository.

```
$ mvn install

$ tree target/
target/
├── classes
│   ├── module-info.class
│   └── org
│       └── se
│           └── lab
│               ├── api
│               │   └── TranslatorService.class
│               └── impl
│                   └── German2EnglishTranslator.class
├── Module-TranslatorService-0.0.1-SNAPSHOT.jar

```

This Module can be used like a regular library but a client can only access the exported package **org.se.lab.api**-

## References

* [A Guide to Java 9 Modularity](https://www.baeldung.com/java-9-modularity)
* Sander Mak and Paul Bakker, *Java 9 Modularity: Patterns and Practices for Developing Maintainable Applications*, O'Reilly, 2017

*Egon Teiniker, 2020-2022, GPL v3.0*
