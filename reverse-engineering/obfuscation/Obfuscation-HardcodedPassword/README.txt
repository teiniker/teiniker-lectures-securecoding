Exercise: Obfuscation - Hardcoded Password
-------------------------------------------------------------------------------

We can run the given example like:
$ java -cp HardcodedPassword.jar org.se.lab.Main
password> xxxx
Login rejected, invalid password!

A) Obfuscate the given JAR file
$ proguard.sh @config.pro

B) Decompile the generated Release File
- Use https://www.decompiler.com/ for JDK21 code
- CheckPassword.main() is not obfuscated, because it is the entry point
    of the application.
- String literals are also not obfuscated (bad news for hardcoded passwords
    and keys).