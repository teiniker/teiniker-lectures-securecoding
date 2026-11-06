# Using Compiler Flags

g++ (GNU C++ Compiler) compiler flags are used to specify options and settings that 
**control the behavior of the GCC compiler during the compilation process**. 
These flags can influence various stages of the compilation process, including preprocessing, compiling, linking, and debugging. Here are some examples of what g++ compiler flags can do:

* **Standard**: The `-std` flag is used to specify the version of the C++ standard that the code should conform to. For example, `-std=c++17` would set the C++ standard to C++17.

* **Warning Messages**: Flags like `-Wall`, `-Wextra`, and `-Werror` are used to control the generation of warning messages. These flags can help identify potential issues in the source code that are not necessarily syntax errors.

* **Debugging**: The `-g` flag is used to include debugging information in the compiled program. This information is useful when debugging the program with a tool like GDB (GNU Debugger).

* **Compiling Only**: The `-c` flag is used to tell the compiler to compile and assemble the code, but not to link it. The output is an object file (`.o`file) for each source file we are compiling. These object files can then be linked together to create the final executable.

* **Output File**: The `-o` flag is used to specify the name of the output file. For example, `g++ -o myprogram myprogram.cpp` would compile `myprogram.cpp` and output a binary file named `myprogram`.

* **Include Paths**: The `-I` flag is used to add additional directories to the list of directories that GCC will search for header files.

* **Linking**: Flags like `-l` (lowercase L) and `-L` are used to control the linking process. For example, `-lmylib` would link against the library `libmylib.a` or `libmylib.so`, and `-L/my/path` would add `/my/path` to the list of paths that the linker searches for libraries.

* **Optimization**: Flags like `-O1`, `-O2`, and `-O3` are used to control the optimization level of the compilation. These flags can help improve the performance
and/or reduce the size of the compiled code.

* **Defining Macros**: The `-D` flag is used to define macros. For example, `-DDEBUG` would have the same effect as adding `#define DEBUG` at the top of your source files.

There are many more GCC compiler flags that can be used to control various aspects 
of the compilation process. The appropriate flags to use depend on the specific 
requirements of your project.

## Supported C++ Versions  

The **g++ 12.2.0** compiler, released in August 2020, supports various versions of the 
C++ programming language. 

Here is a breakdown of the supported C versions by g++ 12.2.0:
* **C++89/C++03**: Fully supported.
    These are the original standards of C++, introducing fundamental features 
    like classes, inheritance, templates, and the Standard Template Library (STL).
* **C++11**: Fully supported with the `-std=c++11` flag.
     C++11 introduced significant enhancements, including auto type declarations, 
     range-based for loops, lambda expressions, smart pointers, and concurrency 
     support.
* **C++14**: Fully supported with the `-std=c++14` flag.
    C++14 provided minor improvements and bug fixes, such 
    as generic lambdas, relaxed constexpr restrictions, and variable templates.

* **C++17**: Fully supported with the `-std=c++17` flag (**default**). 
     C++17 introduced features like structured bindings, if/switch with initializer, 
     inline variables, fold expressions, and the Filesystem library.

* **C++20**: Fully supported with the `-std=c++20` flag.
    C++20 is one of the most feature-rich updates, adding concepts, ranges, 
    coroutines, modules, and enhanced constexpr capabilities.

* **C++23**: Partially supported with the `-std=c++23` flag.
    C++23 introduces further enhancements like deducing this, pattern matching 
    (proposed), and additional library features. However, support is still partial, 
    meaning some features may not be fully implemented or may require specific flags.

## References

* [Linux manual page: g++](https://man7.org/linux/man-pages/man1/g++.1.html)


*Egon Teiniker, 2025, GPL v3.0*    



