# Code Obfuscation using ProGuard

## Install ProGuard 
We can **download** ProGuard from: https://github.com/Guardsquare/proguard/releases and unzip the file into a
local directory:
```
$ mkdir local
$ cd local
$ tar -xvzf ~/Downloads/proguard-7.0.1.tar.gz .
```

In order to execute `proguard.sh` in every directory, we have to extend the `~/.bashrc` file:
```
export PROGUARD=/home/student/local/proguard-7.0.1
export PATH=$JAVA_HOME/bin:$ANT_HOME/bin:$M2_HOME/bin:/opt/bin:$PROGUARD/bin:$PATH
```

## Run ProGuard in Standalone Mode
We can use ProGuard from the command line, as shown by the following example.

_Example_: Using ProGuard to obfuscate a JAR file
We change into the project directory and build the JAR file.
```
$ cd teiniker-lectures-securecoding/reverse-engineering-java/Java-Obfuscator-ShoppingCart
$ mvn package
```
As the result of the build process, we can see a JAR file in the `target` folder:
```
    target
    ├── Java-Obfuscator-ShoppingCart-0.0.1-SNAPSHOT.jar
```

To start the `Main` class in the JAR file, type:
```
$ java -cp ./target/Java-Obfuscator-ShoppingCart-0.0.1-SNAPSHOT.jar org.se.lab.Main
<category id="1" name="VmVyeSBzZWNyZXQga2V5IQ==">
<category id="2" name="English Books">
<category id="4" name="Programming Books">
<product id="5" title="Programming C" price="17.9"/>
<product id="6" title="Java Programming" price="34.5"/>
</category>
</category>
<category id="3" name="German Books">
</category>
</category>
```

Now, that we have a working JAR file, we can use **ProGuard** to create an **obfuscated version** of this JAR file.
```
$ cp target/Obfuscator-ShoppingCart-0.0.1-SNAPSHOT.jar ShoppingCart-1.0.0.jar
$ proguard.sh @config.pro
```

We put all options into a **configuration file** named `config.pro`.
```
-injars       ShoppingCart-1.0.0.jar
-outjars      ShoppingCart-1.0.0-out.jar
-libraryjars  <java.home>/jmods/java.base.jmod

-keep public class org.se.lab.Main
{
    public static void main(java.lang.String[]);
}

-optimizationpasses 3
-overloadaggressively
-repackageclasses ''
-allowaccessmodification

-printmapping ShoppingCart.map
```

We can add comments in the configuration file, starting with a `#` character and continuing until the end of the line.

Configuration details can be found in the online [manual](https://www.guardsquare.com/manual/configuration/usage).
Here some major settings:

* **-injars <class_path>** \
    Specifies the input JARs of the 
    application to be processed. The `class` files in these JARs will be processed and written to the output JARs. 
    By default, any non-class files will be copied without changes.
    
* **-outjars <class_path>** \
    Specifies the names of the output JARs. 
    The processed input of the preceding `-injars` options will be written to the named JARs. 

* **-libraryjars <class_path>** \
    Specifies the library JARs (or jmods) of the application to be processed. 
    The files in these JARs will not be included in the output JARs. 
    The specified library JARs should at least contain the class files that are extended by application class files. 
    Library class files that are only called needn't be present, although their presence can improve the results of the 
    optimization step.     

* **-keep [,modifier,...] class_specification**\
    Specifies classes and class members (fields and methods) to be preserved as entry points to your code. 

* **-optimizationpasses 3**\
    Specifies the number of optimization passes to be performed. 
    By default, a single pass is performed. Multiple passes may result in further improvements. 
    If no improvements are found after an optimization pass, the optimization is ended.
    
* **-overloadaggressively**\
    Specifies to apply aggressive overloading while obfuscating. 
    Multiple **fields and methods can then get the same names**, as long as their arguments and return types 
    are different, as required by Java bytecode (not just their arguments, as required by the Java language). 
    This option can make the processed code even smaller (and less comprehensible). 
        
* **-repackageclasses [package_name]**\
    Specifies to repackage all class files that are renamed, by moving them into the single given package. 
    Without argument or with an empty string (''), the package is removed completely. 
    
* **-allowaccessmodification**\
    Specifies that the access modifiers of classes and class members may be broadened during processing. 
    This can improve the results of the optimization step.             

* **-printmapping**\
    Specifies to print the mapping from old names to new names for classes and class members that have been renamed. 
    The mapping is printed to the standard output or to the given file.
    

## References
* [ProGuard Manual](https://www.guardsquare.com/manual/home)
* [ProGuard Download](https://github.com/Guardsquare/proguard/releases)

*Egon Teiniker, 2020 - 2021, GPL v3.0* 
