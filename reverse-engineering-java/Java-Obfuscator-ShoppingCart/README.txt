How to build and obfuscate the project's Java code?
---------------------------------------------------------------------
We can download ProGuard from:
https://github.com/Guardsquare/proguard/releases

Given a ProGuard installation : ~/local/proguard-7.0.1/
We can run ProGuard in standalone mode by typing:

$ ~/local/proguard-7.0.1/bin/proguard.sh @config.pro


How to configure ProGuard?
---------------------------------------------------------------------
All the settings are stored in the "config.pro" file.
See https://www.guardsquare.com/manual/configuration/usage for more
details.


How to start the application?
---------------------------------------------------------------------

$ java -jar ShoppingCart-1.0.0.jar

$ java -jar ShoppingCart-1.0.0-out.jar


How to decompile the application?
---------------------------------------------------------------------
Use the jd-gui and open both jar files.

