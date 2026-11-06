# C/C++ Compiler Optimization

## Optimization Levels

In order to control compilation-time and compiler memory usage, and the **trade-offs between speed and space** for the resulting executable, GCC provides a range of general optimization levels, numbered from 0--3, as well as individual options for specific types of optimization.

* **-O0 or no -O option (default)**\
At this optimization level **GCC does not perform any optimization** and compiles the source code in the most straightforward way possible.
Each command in the source code is converted directly to the corresponding instructions in the executable file, without rearrangement.
This is the **best option to use when debugging a program** and is the default if no optimization level option is specified.

* **-O1 or -O**\
This level turns on the **most common forms of optimization** that do not require any speed-space tradeoffs.
With this option the resulting executables should be smaller and faster than with -O0.
The more expensive optimizations, such as instruction scheduling, are not used at this level.
Compiling with the option -O1 can often take less time than compiling with -O0, due to the reduced amounts
of data that need to be processed after simple optimizations.

* **-O2**\
This option turns on further optimizations, in addition to those used by -O1.
These additional optimizations include **instruction scheduling**. Only optimizations that do not require
any speed-space tradeoffs are used, so the executable should not increase in size. The compiler will take
longer to compile programs and require more memory than with -O1.
This option is generally the best choice for deployment of a program, because it provides maximum optimization
without increasing the executable size. It is the **default optimization level for releases of GNU packages**.

* **-O3**\
This option turns on more expensive optimizations.
The -O3 optimization level may increase the speed of the resulting executable, but **can also increase its size**.
Under some circumstances where these optimizations are not favorable, this option might actually make a program slower.

* **-Os**\
**Optimizes code for size**. It activates all `-O2` options that do not increase the size of the generated code.
It can be useful for machines that have extremely limited disk storage space and/or CPUs with small cache sizes.


## Dead Code Elimination (DCE)

Removes code that never affects program output.

```C
int foo(int x) {
    int y = x * 10;
    return x; // `y` is never used → compiler removes it
}
```

_Example:_ Assembly code without optimization -O0

```assembly
push    rbp
mov     rbp, rsp
mov     DWORD PTR [rbp-20], edi
mov     edx, DWORD PTR [rbp-20]
mov     eax, edx
sal     eax, 2
add     eax, edx
add     eax, eax
mov     DWORD PTR [rbp-4], eax
mov     eax, DWORD PTR [rbp-20]
pop     rbp
ret
```

_Example:_ Assembly code with optimization -O2

```assembly
mov     eax, edi
ret
```

## Constant Folding & Propagation

Computes constant expressions at compile-time instead of run-time.

```C
int a = 5 * 10;  // compiler turns this into: int a = 50;
```


## Inlining

Small functions may be replaced with their code body to reduce function call overhead.

```C
#include <stdio.h>

void empty_method(void)
{
    // do nothing
}

void print_number(int number)
{
    printf("\tnumber =%2d\n", number);
}

int main(void)
{
    for(int i=0; i < 10000; i++)
    {
        empty_method();
        print_number(i);
    }
    return 0;
}
```

_Example:_ Assembly code without optimization -O0

```assembly
empty_method:
        push    rbp
        mov     rbp, rsp
        nop
        pop     rbp
        ret
.LC0:
        .string "\tnumber =%2d\n"
print_number:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     DWORD PTR [rbp-4], edi
        mov     eax, DWORD PTR [rbp-4]
        mov     esi, eax
        mov     edi, OFFSET FLAT:.LC0
        mov     eax, 0
        call    printf
        nop
        leave
        ret
main:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     DWORD PTR [rbp-4], 0
        jmp     .L4
.L5:
        call    empty_method
        mov     eax, DWORD PTR [rbp-4]
        mov     edi, eax
        call    print_number
        add     DWORD PTR [rbp-4], 1
.L4:
        cmp     DWORD PTR [rbp-4], 9999
        jle     .L5
        mov     eax, 0
        leave
        ret
```


_Example:_ Assembly code with optimization -O2

```assembly
empty_method:
        ret
.LC0:
        .string "\tnumber =%2d\n"
print_number:
        mov     esi, edi
        xor     eax, eax
        mov     edi, OFFSET FLAT:.LC0
        jmp     printf
main:
        push    rbx
        xor     ebx, ebx
.L5:
        mov     esi, ebx
        mov     edi, OFFSET FLAT:.LC0
        xor     eax, eax
        add     ebx, 1
        call    printf
        cmp     ebx, 10000
        jne     .L5
        xor     eax, eax
        pop     rbx
        ret
```
In C++, the `inline` keyword can be used with functions and methods to suggest 
to the compiler that it should attempt to expand the function's code at each 
call site, rather than generating a regular function call. 

This can reduce function call overhead for small, frequently called functions. 
However, the compiler may ignore the `inline` suggestion if it determines that 
inlining is not beneficial.


## Inlining of Standard Library Calls

Replaces calls like `memcpy`, `strlen` with optimized built-in machine instructions.


## Loop Optimizations

* **Loop unrolling**: Expands loop iterations to reduce branch overhead.
* **Loop fusion**: Combines multiple loops into one to reduce passes.
* **Loop invariant code motion**: Moves calculations outside the loop 
if they don’t change.

```C
// (a+b) can be computed once outside the loop
for (int i=0; i<n; i++)
{
    y[i] = x[i] * (a+b);  
} 
```

## Register Allocation

Places frequently used **variables in CPU registers** instead of memory for speed.


## Instruction Scheduling

**Reorders instructions** to reduce CPU pipeline stalls while preserving correctness.


## Vectorization (SIMD)

**Single Instruction, Multiple Data (SIMD)** is a parallel computing model where 
one CPU instruction operates on multiple data elements simultaneously.
Instead of processing one integer or float at a time, SIMD instructions let the 
CPU process vectors of data in parallel.

SIMD needs **special CPU registers and instructions**. 
On x86/x86-64 CPUs, the major families are:

**1. Streaming SIMD Extensions (SSE)**
* Introduced by Intel (Pentium III, ~1999).
* 128-bit registers (XMM0–XMM15).
* Can operate on:
    - 4 × 32-bit floats
    - 2 × 64-bit doubles
    - 16 × 8-bit integers
* Instructions like:
    - addps: Add Packed Single-precision floats
    - mulps: Multiply Packed Single-precision floats
    - movaps: Move Aligned Packed Single-precision

**2. AVX (Advanced Vector Extensions)**
* Introduced with Intel Sandy Bridge (~2011).
* 256-bit registers (YMM0–YMM15).
* Can operate on:
    - 8 × 32-bit floats
    - 4 × 64-bit doubles


## Tail Call Optimization (TCO)

**Optimizes recursive calls** to avoid growing the call stack.


## Trade-offs

* **Higher optimizations (-O3)** may increase binary size, cause longer 
compile times, or introduce non-standard behavior.

* **Debugging** optimized code is harder (variables may be optimized away, 
reordering may confuse step-through debugging).

* `-O2` is usually the best balance for **production builds**.



## References:
* [Compiler Explorer](https://godbolt.org/)

* [Optimization Levels](https://www.linuxtopia.org/online_books/an_introduction_to_gcc/gccintro_49.html)
* [GCC Optimization](https://wiki.gentoo.org/wiki/GCC_optimization#-O)

*Egon Teiniker, 2025, GPL v3.0* 
