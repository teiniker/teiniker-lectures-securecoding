# C Compiler Optimization

## gcc Optimization Levels

In order to control compilation-time and compiler memory usage, and the **trade-offs between speed and space** for the resulting executable, GCC provides a range of general optimization levels, numbered from 0--3, as well as individual options for specific types of optimization.

* **-O0 or no -O option (default)**\
At this optimization level **GCC does not perform any optimization** and compiles the source code in the most straightforward way possible. Each command in the source code is converted directly to the corresponding instructions in the executable file, without rearrangement. This is the best option to use when debugging a program and is the default if no optimization level option is specified.

* **-O1 or -O**\
This level turns on the **most common forms of optimization** that do not require any speed-space tradeoffs. With this option the resulting executables should be smaller and faster than with -O0. The more expensive optimizations, such as instruction scheduling, are not used at this level. Compiling with the option -O1 can often take less time than compiling with -O0, due to the reduced amounts of data that need to be processed after simple optimizations.

* **-O2**\
This option turns on further optimizations, in addition to those used by -O1. These additional optimizations include **instruction scheduling**. Only optimizations that do not require any speed-space tradeoffs are used, so the executable should not increase in size. The compiler will take longer to compile programs and require more memory than with -O1. This option is generally the best choice for deployment of a program, because it provides maximum optimization without increasing the executable size. It is the **default optimization level for releases of GNU packages**.

* **-O3**\
This option turns on more expensive optimizations. The -O3 optimization level may increase the speed of the resulting executable, but **can also increase its size**. Under some circumstances where these optimizations are not favorable, this option might actually make a program slower.


## Method Inlining

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

### Optimization: -O0

```
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


### Optimization: -O2

```
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




## References:
* [Compiler Explorer](https://godbolt.org/)

* [Optimization Levels](https://www.linuxtopia.org/online_books/an_introduction_to_gcc/gccintro_49.html)
* [GCC Optimization](https://wiki.gentoo.org/wiki/GCC_optimization#-O)

*Egon Teiniker, 2020-2021, GPL v3.0* 
