# C Libraries

## Introduction 

Libraries are **collections of precompiled functions** that have been written to be used in other programs.

For example, the **standard C library** `libc.a` is automatically linked into our programs.

A library filename always starts with `lib`. The last part of the name determines the library type:
* **Static libraries (.a)**\
A static library is linked by the linker and included in the execution code. 
This leads to large executable files.

* **Dynamically linked shared libraries (.so)**\
In a shared library, the code for functions are not directly included in the resulting executable.  The code is shared between applications and loaded during execution by the **dynamic link loader**. 

## Static Libraries



## Shared libraries




## References


*Egon Teiniker, 2020-2022, GPL v3.0*