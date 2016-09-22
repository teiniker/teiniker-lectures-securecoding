How to build and obfuscate the project's Java code?
---------------------------------------------------------------------

$ ant 
Buildfile: /home/teini/workspace/Obfuscator-ShoppingCart/build.xml

init:
    [mkdir] Created dir: /home/teini/workspace/Obfuscator-ShoppingCart/build

compile:
    [javac] Compiling 6 source files to /home/teini/workspace/Obfuscator-ShoppingCart/build

jar:
      [jar] Building jar: /home/teini/workspace/Obfuscator-ShoppingCart/ShoppingCart-1.0.0.jar

obfuscate:
 [proguard] ProGuard, version 4.10
 [proguard] Reading program jar [/home/teini/workspace/Obfuscator-ShoppingCart/ShoppingCart-1.0.0.jar]
 [proguard] Reading library jar [/usr/java/jdk1.7.0_25/jre/lib/rt.jar]
 [proguard] Preparing output jar [/home/teini/workspace/Obfuscator-ShoppingCart/ShoppingCart-1.0.0-out.jar]
 [proguard]   Copying resources from program jar [/home/teini/workspace/Obfuscator-ShoppingCart/ShoppingCart-1.0.0.jar]

BUILD SUCCESSFUL

Note that the generated class files are stored in the build directory
while the Eclipse generated class files are stored in bin.
This separates code generated from potentially different compilers.


How to configure ProGuard?
---------------------------------------------------------------------
All the settings are stored in the "config.pro" file.
See http://proguard.sourceforge.net/#manual/examples.html for more
details.



How to start the application?
---------------------------------------------------------------------

$ java -jar ShoppingCart-1.0.0.jar

$ java -jar ShoppingCart-1.0.0-out.jar



How to decompile the application?
---------------------------------------------------------------------
Use the jd-gui and open both jar files.

