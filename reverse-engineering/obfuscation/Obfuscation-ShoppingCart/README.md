# Example: Obfuscation - Shopping Cart

## Obfuscate Existing JAR File 

We use ProGuard from the command line:
```
$ cp  target/Obfuscation-ShoppingCart-0.0.1-SNAPSHOT.jar ShoppingCard-Dev.jar
$ proguard.sh @config.pro
```

The output of this obfuscation is stored in a new JAR file called
`ShoppingCard-Release.jar`.


## ProGuard Configuration

_Example:_ ProGuard configuration file `config.pro`
```
-injars       ShoppingCart-Dev.jar
-outjars      ShoppingCart-Release.jar
-libraryjars  <java.home>/jmods/java.base.jmod

-keep public class org.se.lab.Main
{
    public static void main(java.lang.String[]);
}

-optimizationpasses 3
-overloadaggressively
-repackageclasses ''
-allowaccessmodification
-printmapping obfuscation.map
```

### Configuration Details:

1.**`-injars`**:
    - Specifies the input JAR file to be obfuscated.
    - `ShoppingCart-Dev.jar` is the input file, containing the original, unobfuscated code.

2. **`-outjars`**:
    - Specifies the output JAR file where the obfuscated and optimized code will be written.
    - `ShoppingCart-Release.jar` is the obfuscated output.

3. **`-libraryjars`**:
    - Specifies the library JARs or modules required by the program, typically part of the Java runtime.
    - `<java.home>/jmods/java.base.jmod` includes the core Java base module from the Java platform.

4. **`-keep public class org.se.lab.Main`**:
    - Ensures that the `Main` class and its `main` method are not obfuscated, as they are entry points for the application.
    - This prevents issues with entry-point recognition and enables the program to run as expected after obfuscation.

5. **`-optimizationpasses 3`**:
    - Sets the number of optimization passes ProGuard should perform.
    - A higher number of passes can potentially yield more optimized code but increases processing time.

6. **`-overloadaggressively`**:
    - Enables ProGuard to reuse short obfuscated names aggressively, potentially improving obfuscation but possibly making debugging harder.

7. **`-repackageclasses ''`**:
    - Repackages classes into the default package (root package), effectively removing original package names.
    - This can make reverse engineering more difficult.

8. **`-allowaccessmodification`**:
    - Permits ProGuard to modify access modifiers (e.g., making private methods or fields public) to enable further optimizations or obfuscations.

9. **`-printmapping obfuscation.map`**:
    - Generates a mapping file (`obfuscation.map`) that links original class, method, and field names to their obfuscated counterparts.
    - This file is critical for debugging and understanding stack traces in the obfuscated program.

### Purpose of the Configuration:
- The configuration obfuscates `ShoppingCart-Dev.jar` to produce a smaller, harder-to-reverse-engineer version in `ShoppingCart-Release.jar`.
- The `Main` class and its `main` method are kept intact to ensure the application remains functional.
- Other classes, methods, and fields are aggressively obfuscated and optimized to enhance code security and reduce the JAR size.

### Potential Considerations:
- Ensure the mapping file (`obfuscation.map`) is securely stored because losing it makes debugging nearly impossible.
- Use `-libraryjars` cautiously to include all dependencies; missing libraries can cause runtime errors.
- Aggressive options like `-overloadaggressively` and `-allowaccessmodification` might introduce compatibility issues; test thoroughly after obfuscation.

*Egon Teiniker, 2016-2024, GPL v3.0*