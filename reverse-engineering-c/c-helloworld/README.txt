Compiling and Running a Simple C Program
-------------------------------------------------------------------------------

Write the source code
---------------------

$ vi hello.c

 #include <stdio.h>
 
int main()
{
    for(int i=0; i<10; i++)
    {
       printf("Hello world!\n");
    }
    return 0;
}


Compile and run the executable  
------------------------------

$ gcc -std=c99 -g -Wall -o hello hello.c
$ ./hello

Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!


Review all the steps from source code to the executable
-------------------------------------------------------

Run the C pre-processor
$ cpp hello.c _hello.c 

Generate the assembly code
$ gcc -std=c99 -S _hello.c

Run the assembler
$ as -o hello.o _hello.s

Link the object file into an executable
$ gcc -o hello hello.o

Run the executable
$ ./hello 


Use a build tool 
----------------

$ vi Makefile

OBJECTS = 
CFLAGS = -std=c99 -g -Wall  
LDLIBS = 
CC=gcc

all: hello 

hello: hello.c
    $(CC) $(CFLAGS) $(LDLIBS) -o hello hello.c 

clean:
    rm hello 

$ make
$ make clean


Start the executable in the debugger
------------------------------------

$ gdb ./hello
(gdb) list 
1   #include <stdio.h>
2   
3   int main()
4   {
5       for(int i=0; i<10; i++)
6       {
7           printf("Hello world!\n");
8       }   
9       return 0;
10  }

(gdb) disass main
Dump of assembler code for function main:
   0x08048430 <+0>:     push   %ebp
   0x08048431 <+1>:     mov    %esp,%ebp
   0x08048433 <+3>:     and    $0xfffffff0,%esp
   0x08048436 <+6>:     sub    $0x20,%esp
   0x08048439 <+9>:     movl   $0x0,0x1c(%esp)
   0x08048441 <+17>:    jmp    0x8048454 <main+36>
   0x08048443 <+19>:    movl   $0x8048504,(%esp)
   0x0804844a <+26>:    call   0x80482f0 <puts@plt>
   0x0804844f <+31>:    addl   $0x1,0x1c(%esp)
   0x08048454 <+36>:    cmpl   $0x9,0x1c(%esp)
   0x08048459 <+41>:    jle    0x8048443 <main+19>
   0x0804845b <+43>:    mov    $0x0,%eax
   0x08048460 <+48>:    leave  
   0x08048461 <+49>:    ret    
End of assembler dump.

(gdb) break main
Breakpoint 1 at 0x8048439: file hello.c, line 5.

(gdb) run
Starting program: /home/student/workspace-2014ws-ims14-SWSecurity/c-helloworld/hello 
(gdb) next
(gdb) next
(gdb) next

(gdb) print i
$1 = 1

(gdb) continue
Continuing.
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!

(gdb) quit


Check for memory leaks
----------------------

$ valgrind ./hello 
==1914== Memcheck, a memory error detector
==1914== Copyright (C) 2002-2013, and GNU GPL'd, by Julian Seward et al.
==1914== Using Valgrind-3.9.0 and LibVEX; rerun with -h for copyright info
==1914== Command: ./hello
==1914== 
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!
==1914== 
==1914== HEAP SUMMARY:
==1914==     in use at exit: 0 bytes in 0 blocks
==1914==   total heap usage: 0 allocs, 0 frees, 0 bytes allocated
==1914== 
==1914== All heap blocks were freed -- no leaks are possible
==1914== 
==1914== For counts of detected and suppressed errors, rerun with: -v
==1914== ERROR SUMMARY: 0 errors from 0 contexts (suppressed: 0 from 0)

