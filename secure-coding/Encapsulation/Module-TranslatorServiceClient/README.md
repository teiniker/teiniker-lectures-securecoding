## Example: Module-TranslatorServiceClient

This example implements a Module and uses another Module as a library.

### Implementing the Module

We define a package named *org.se.lab.client* and implement simple client within that package.

```
├── pom.xml
├── src
│   └── main
│       └── java
│           ├── module-info.java
│           └── org
│               └── se
│                   └── lab
│                       └── client
│                           └── TranslatorClient.java

```

The *Module Descriptor* specifies a dependency to the Module **translatorservice**: 

```
module translatorservice.client
{
    requires translatorservice;

    exports org.se.lab.client;
}
```

To build our Module, we have to specify a dependency to the required module's JAR file in the pom.xml:
```
    <dependency>
        <groupId>org.se.lab</groupId>
        <artifactId>Module-TranslatorService</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <scope>compile</scope>
    </dependency>
```

In the case of an application Module, we can skip the packaging step:
```
$ mvn compile

$ tree target/
target/
├── classes
│   ├── module-info.class
│   └── org
│       └── se
│           └── lab
│               └── client
│                   └── TranslatorClient.class
```

### Running the Module

We can start the main class of a module from the command line:
```
    $ java -p target:../Module-TranslatorService/target/Module-TranslatorService-0.0.1-SNAPSHOT.jar -m translatorservice.client/org.se.lab.client.TranslatorClient
```

Note that we have used additional parameters to specify the **module and its main class** we want to start:
```
    -m translatorservice.client/org.se.lab.client.TranslatorClient
```
together with the **module path** needed:
```
    -p target:../Module-TranslatorService/target/Module-TranslatorService-0.0.1-SNAPSHOT.jar
```

A parameter description can be found using the help page: 
```
$ java -help
    java [options] -m <module>[/<mainclass>] [args...]
       
    java [options] --module <module>[/<mainclass>] [args...] (to execute the main class in a module)

    -p <module path>
    --module-path <module path>...
                  A : separated list of directories, each directory is a directory of modules.
```
   
We can also use the well known CLASSPATH notation to run the example as well:
```
$ java -cp target/classes:../Module-TranslatorService/target/classes  org.se.lab.client.TranslatorClient
```
But remember, without a proper definition of module dependencies and package visibility the Java compiler
would not even compile the client Module.   
    
### References

* [A Guide to Java 9 Modularity](https://www.baeldung.com/java-9-modularity)
* Sander Mak and Paul Bakker, *Java 9 Modularity: Patterns and Practices for Developing Maintainable Applications*, O'Reilly, 2017

*Egon Teiniker, 2020, GPL v3.0*
