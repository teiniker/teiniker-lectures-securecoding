# A Simple Java Program

## Write the Java Source Code

```Java
package org.se.lab;

public class HelloWorld
{
	public static void main(String... args)
	{
		for(int i=0; i<10; i++)
		{
			System.out.println("Hello Bremen!");
		}
	}
}
```

## Compile and run the executable

```
$ mkdir target
$ mkdir target/classes

$ javac -d target/classes src/main/java/org/se/lab/*.java

$ tree
.
├── README.txt
├── src
│    └── main
│        └── java
│             └── org
│                └── se
│                    └── lab
│                        └── HelloWorld.java
└── target
    └── classes
        └── org
            └── se
                └── lab
                    └── HelloWorld.class
```

```
$ java -cp target/classes/ org.se.lab.HelloWorld
Hello Bremen!
...
Hello Bremen!
```

## Use Maven as a Build Tool

```
$ mvn compile
```
```
<project ...>
	<modelVersion>4.0.0</modelVersion>

	<groupId>org.se.lab</groupId>
	<artifactId>Java-HelloWorld</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<build>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.1</version>
				<configuration>
					<release>21</release>
				</configuration>
			</plugin>
		</plugins>
	</build>

	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13.2</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
</project>
```

## Review the generated Bytecode
```
$ javap -cp target/classes -c org.se.lab.HelloWorld
Compiled from "HelloWorld.java"
public class org.se.lab.HelloWorld {
  public org.se.lab.HelloWorld();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String...);
    Code:
       0: iconst_0
       1: istore_1
       2: iload_1
       3: bipush        10
       5: if_icmpge     22
       8: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
      11: ldc           #13                 // String Hello Bremen!
      13: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      16: iinc          1, 1
      19: goto          2
      22: return
}
```

## Build a Java Library

A Java library (**JAR file**) is a ZIP file with a defined directory 
structure in which .class files (and other JAR files) are stored.

With the help of **Maven** you can easily build a JAR file:

```
$ mvn package
.
├── pom.xml
├── src
│    └── main
│        └── java
│            └── org
│                └── se
│                    └── lab
│                        └── HelloWorld.java
└── target
    ├── classes
    │    └── org
    │        └── se
    │            └── lab
    │                └── HelloWorld.class
    ├── Java-HelloWorld-0.0.1-SNAPSHOT.jar
```

With the command line tool **jar** we can also process JAR files.

_Example:_ List the content of a JAR file

```
$ jar -tf target/Java-HelloWorld-0.0.1-SNAPSHOT.jar
  META-INF/
  META-INF/MANIFEST.MF
  org/
  org/se/
  org/se/lab/
  org/se/lab/HelloWorld.class
  META-INF/maven/
  META-INF/maven/org.se.lab/
  META-INF/maven/org.se.lab/Java-HelloWorld/
  META-INF/maven/org.se.lab/Java-HelloWorld/pom.xml
  META-INF/maven/org.se.lab/Java-HelloWorld/pom.properties
```

_Example:_ Extract the content of a JAR file

```
$ mkdir tmp 
$ cd tmp/
$ jar -xvf ../target/Java-HelloWorld-0.0.1-SNAPSHOT.jar 
  created: META-INF/
 inflated: META-INF/MANIFEST.MF
  created: org/
  created: org/se/
  created: org/se/lab/
  created: META-INF/maven/
  created: META-INF/maven/org.se.lab/
  created: META-INF/maven/org.se.lab/Java-HelloWorld/
 inflated: org/se/lab/HelloWorld.class
 inflated: META-INF/maven/org.se.lab/Java-HelloWorld/pom.xml
 inflated: META-INF/maven/org.se.lab/Java-HelloWorld/pom.properties
```

_Example:_ Create a JAR file from a given folder

```
$ jar -cvf Java-HelloWorld.jar .
added manifest
ignoring entry META-INF/
ignoring entry META-INF/MANIFEST.MF
adding: META-INF/maven/(in = 0) (out= 0)(stored 0%)
adding: META-INF/maven/org.se.lab/(in = 0) (out= 0)(stored 0%)
adding: META-INF/maven/org.se.lab/Java-HelloWorld/(in = 0) (out= 0)(stored 0%)
adding: META-INF/maven/org.se.lab/Java-HelloWorld/pom.properties(in = 69) (out= 70)(deflated -1%)
adding: META-INF/maven/org.se.lab/Java-HelloWorld/pom.xml(in = 886) (out= 394)(deflated 55%)
adding: org/(in = 0) (out= 0)(stored 0%)
adding: org/se/(in = 0) (out= 0)(stored 0%)
adding: org/se/lab/(in = 0) (out= 0)(stored 0%)
adding: org/se/lab/HelloWorld.class(in = 628) (out= 410)(deflated 34%)
```

_Example:_ Run a class file from a JAR file

```
$ $ java -cp Java-HelloWorld.jar org.se.lab.HelloWorld 
Hello Bremen!
Hello Bremen!
Hello Bremen!
Hello Bremen!
Hello Bremen!
Hello Bremen!
Hello Bremen!
Hello Bremen!
Hello Bremen!
Hello Bremen!
```
## References
* [The Java™ Tutorials](https://docs.oracle.com/javase/tutorial/)

*Egon Teiniker, 2020-2023, GPL v3.0*