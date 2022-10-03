# Memory Segments used in C

## Local Variables

A variable **declared in the body of a function** is said to be local to the function, thus, we call it a **local variable**.

_Example_: Local variable `result`
```C
int sum_of_integers(int n)
{
    int result;     
    result = n*(n+1)/2;
    return result;
}
```

Local variables have the following properties:
* **Automatic storage duration**. 
    Storage for a local variable is automatically allocated when the enclosing function is called an 
    deallocated when the function returns - **automatic storage duration**.
    A local variable doesn't retain its value when its enclosing function returns.
    When the function is called again, there is no guarantee that the variable will still have its 
    old value.

* **Block scope**.
The scope of a variable is the portion of the program text in which the variable can be referenced.
A local variable is visible from its point of declaration to the end of the enclosing function body - **block scope**.
Since the scope of a local variable doesn't extend beyond the function to which it belongs, other functions can use 
the same name for other purposes.

Since **C99** doesn't require variable declarations to come at the beginning of a function, it is possible for a local 
variable to have a very small scope. Even in a for loop, we can define the loop variable local in the loop body.

_Example_: Block scope
```C
    {
        int i = 7;
        assert(i == 7);
    }
    {
        int i = 3;
        assert(i==3);
    }
    for(int i=0; i<10; i++)
    {
        assert(i < 10);
    }
```

We use the term **block** to describe a compound statement:
```
{
    declarations
    statements
}
```
The body of a function is a block.
Blocks are also useful inside a function body when we need variables for temporary use.
**C99** allows variables to be declared anywhere within a block, just as it allows variables 
to be declared anywhere within a function.

In a C program, the same identifier may have several different meanings.
C's **scope rules** enable the compiler to determine which meaning is relevant at a given point in the program.

_Rule_: When a declaration inside a block names an identfier that is already visible, the new declaration 
temporarily _hides_ the old one, and the identifier takes a new meaning.


### Static Local Variables

A variable with **static storage duration** has a permanent storage location, so it retains its 
value throughout the execution of the program.

_Example_: Static storage duration
```C
int counter(void)
{
    static int value;    
    return value++;
}
```

A **static local variable still has block scope**, so it is not visible to other functions. 


### Parameters
Parameters have the **same properties as local variables** - automatic storage duration and block scope.
The only real difference between parameters and local variables is that each parameter is initialized 
automatically when a function is called.


## Global Variables
Functions can also communicate through global variables - variables that are **declared outside the 
body of any function**.

Global variables have the following properties:
* **Static storage duration**.
    A value stored in an external variable will stay there indefinitely.

* **File scope**.
    A global variable is visible from its point of declaration to the end of the enclosing file.
    As a result, a global variable **can be accessed and modified by all functions** that follow 
    its declaration.

_Example_: Global variable
```C
int counter_value = 0;  
void increment()
{
    counter_value++;
}
void decrement()
{
    counter_value--;
}
```
Global variables are convenient when many functions must share a variable or when a few functions
share a large number of variables.
In general, **it is better for functions to communicate through parameters rather than by sharing 
variables**:
* If we change a global variable during program **maintainance**, we will need to check every 
    function in the same file to see how the change affects it.
* if a global variable is assigned an incorrect value, it may be **difficult to debug** and 
    identify the guilty function.
* Functions that rely on global variables are **hard to reuse** in other programs.
    A function that depends on global variables is not self-contained: to reuse the function we 
    will have to drag along any external variables that it needs.

Many C programmers rely **far to much on global variables** - try to avoid them!
When we use global variables, at least we have to give them **meaningful names** (for local variables, in contrast, 
we often use single characters like `i`). 


_Example_: Addresses of variables and functions
```
stack segment:
        local_variable                  at 0x7fff6a763744

heap segment:
        heap_ptr                        at 0x55cd397d2260

bss segment:
        global_variable                 at 0x55cd38322058
        static_variable                 at 0x55cd38322050

data segment:
        global_variable_initialized     at 0x55cd3832204c
        static_variable_initialized     at 0x55cd38322054

code segment:
        main()                          at 0x55cd3831f165
```

Note that the format string `"%p"` does not print the leading `0`s.

Also, for every single run of this application the addresses will be different!

## Memory Leaks 

The memory leak occurs, when a piece of memory which was previously allocated by 
the programmer is not deallocated properly by programmer. 
That memory is no longer in use by the program, but that place in the heap is reserved 
for no reason.

_Example_: Using valgrind to detect memory leaks
```
$ valgrind ./memory_segments
==3382== Memcheck, a memory error detector
==3382== Copyright (C) 2002-2017, and GNU GPL'd, by Julian Seward et al.
==3382== Using Valgrind-3.13.0 and LibVEX; rerun with -h for copyright info
==3382== Command: ./memory_segments
==3382==
stack segment:
        stack_var at 0x1ffefffb04
        function.stack_var at 0x1ffefffaec
heap segment:
        heap_var at 0x520c040
bss segment:
        global_var at 0x601044
        static_var at 0x601040
data segment:
        global_initialized_var at 0x601034
        static_initialized_var at 0x601038
code segment:
        main() at 0x400588
        function() at 0x400567
==3382==
==3382== HEAP SUMMARY:
==3382==     in use at exit: 4 bytes in 1 blocks    <= !!!!!!!!!!!!!
==3382==   total heap usage: 2 allocs, 1 frees, 1,028 bytes allocated
==3382==
==3382== LEAK SUMMARY:
==3382==    definitely lost: 4 bytes in 1 blocks    <= !!!!!!!!!!!!!
==3382==    indirectly lost: 0 bytes in 0 blocks
==3382==      possibly lost: 0 bytes in 0 blocks
==3382==    still reachable: 0 bytes in 0 blocks
==3382==         suppressed: 0 bytes in 0 blocks
==3382== Rerun with --leak-check=full to see details of leaked memory
==3382==
==3382== For counts of detected and suppressed errors, rerun with: -v
==3382== ERROR SUMMARY: 0 errors from 0 contexts (suppressed: 0 from 0)
```

## References
* K. N. King. **C Programming, A Modern Approach.** W. W. Norton & Company, inc. 2nd Edition 2008. 
    Chapter 10: Program Organization
* Jon Erickson. **Hacking - The Art of Exploitation**. No Starch Press, 2nd Edition, 2008. 

* [Valgrind](https://valgrind.org/)

*Egon Teiniker, 2020-2022, GPL v3.0* 
