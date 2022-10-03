# Using the Stack

## Introduction

The stack is a data structure that has the quality of a **first in, last out (FILO)** queue. The task of putting items on the stack is called a push. The task of taking an item from the stack is called a pop.

Each process maintains its own stack within the **stack segment of memory**. 
The stack **grows backward from the highest memory addresses to the lowest**.

Two important registers deal with the stack: 
* **base pointer (rbp)**: The base pointer is conventionally used to mark the **start of a function's stack frame**, or the area of the stack managed by that function. 

* **stack pointer (rsp)**: Points to the last value pushed onto the stack.


## x86 Calling Conventions

### Function calling procedure

* The program places the **first six integer or pointer parameters** in the registers **rdi, rsi, rdx, rcx, r8, and r9**. Subsequent parameters are pushed onto the stack.

* The program then executes the **call** instruction, which will **push the return address** onto the stack and **jump to** the start of the **specified function**.

* If the function has a **return value**, it will be stored in the rax register after the function call.

![Stack Layout](../figures/StackLayout.png)


### Function prolog
The called function’s responsibilities are first to save the calling program’s `rbp` register on the stack, then to save the current `rsp` register to the `rbp` register (setting the current stack frame).
After that, the function gets an opportunity to execute its statements.


### Function epilogue

The last thing a called function does before returning to the calling program is to clean up the stack by removing the `rbp`. Then the saved return address is popped off the stack and saved to the `rip` register as part of the return process.

_Example_: [Function calls in C](c-function-call/)
```C
$ gdb ./function_call
(gdb) list 
1	#include<stdio.h>
2	
3	
4	int add(int a, int b)
5	{
6	    int s;
7	    s = a+b;
8	    return s;
9	}
10	
11	
12	int main(int argc, char** argv)
13	{
14	    int result = add(0x22222222, 0x44444444);
15	
16	    printf("result = 0x%08x\n", result);
17	    return 0;    
18	}
```

In the **main() prolog** you can see that the `rbp` register is saved onto the stack, then loaded with the current value of the `rsp` register (beginning of the new stack frame) and the stack pointer is decreased by `0x20` bytes to make room for local variables.

In the **epilogue of main()**, the stack frame is released again with the instruction `leave` which copies the frame pointer (in the `rbp` register) into the stack pointer register `rsp`, which releases the stack space allocated to the stack frame.

```
(gdb) disass main
Dump of assembler code for function main:
   0x00000000004004f1 <+0>:	    push   rbp
   0x00000000004004f2 <+1>:	    mov    rbp,rsp
   0x00000000004004f5 <+4>:	    sub    rsp,0x20

   ...

   0x000000000040052b <+58>:	leave
   0x000000000040052c <+59>:	ret  
```

Since the `add()` function makes no further function calls, the **prolog** does not need to allocate a full stack frame (`rsp` is not reduced).

This also makes cleaning up in the **epilogue** easier, only the `rbp` has to be popped off the stack.

```
(gdb) disass add
Dump of assembler code for function add:
   0x00000000004004d7 <+0>:	    push   rbp
   0x00000000004004d8 <+1>:	    mov    rbp,rsp

   ...
   
   0x00000000004004ef <+24>:	pop    rbp
   0x00000000004004f0 <+25>:	ret    
```



## Recursion

Recursion is a powerful principle that allows something to be defined in terms of smaller instances of itself.

In computing, recursion is supported via recursive functions.
A recursive function is a function that calls itself. 
Each successive call worls on a more refined set of inputs, bringing us closer and closer to the solution of a problem.

_Example_: [Factorial](c-factorial/)
```C
int fact(int n)
{
    if(n < 0)
        return 0;
    else if(n == 0 || n == 1)
        return 1;
    else
    {
        return n * fact(n-1);
    }
}
```
The **factoral of n**, written **n!**, is the product of all numbers from `n` down to `1`.
Another way to look at this problem is to define n! as the product of smaller factorials. 
To do this, we define `n!` as n times the factorial of `(n-1)`.

There are two basic phases in a recursive process:
* In the **winding phase**, each recursive call preserve the recursion by making an additional recursive call itself.
    The winding phase terminates when one of the calls reaches a **terminating condition**.
    A terminating condition defines the state at which a recursive function sgould return instead of making another 
    recursive call.
    Every recursive funstion must have at least one terminating condition, otherwise, the winding phase never terminates.

* Once the winding phase is complete, the process enters the **unwinding phase**, in which previous instances of the 
    function are revisited in reverse order.
    This phase continues until the original call returns, at which point the recursive process is complete.


_Example_: [Linked List](c-linked-list-recursion/)


However, stack usage does have a few **drawbacks**:
* Maintaining information about every function call until it returns takes a considerable amount of **memory space**.
* Generating and destroying stack frames takes **CPU time**. Thus, if the overhead associated with these concerns becomes 
too great, we may need to consider an iterative approach (loops).




## References
* [A brief introduction to x86 calling conventions](https://codearcana.com/posts/2013/05/21/a-brief-introduction-to-x86-calling-conventions.html)

* [Youtube: CS50 - Call Stacks](https://youtu.be/aCPkszeKRa4)

* [Youtube: CS50 - Recursion](https://youtu.be/mz6tAJMVmfM)

* Kyle Loudon. Mastering Algorithms with C. O'Reilly,1999
    * Chapter 3: Recursion

*Egon Teiniker, 2020-2022, GPL v3.0*
