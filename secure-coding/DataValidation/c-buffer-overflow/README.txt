Buffer Overflow
----------------------------------------------------------------------

A Buffer is a temporary space in memory used to hold data.

A Buffer Overflow happens when data written to a buffer is larger than
the size of the buffer, and due to insufficient bounds checking it
overflows and overwrites adjacent memory locations.


Requirements
----------------------------------------------------------------------
To analyze the stack usage, we have to disable all OS and compiler
preventions:

gcc
(>= 4.1)
    -fno-stack-protector
    -z execstack

If -mpreferred-stack-boundary is not specified, the default is 4
(16 bytes or 128 bits).

GCC Stack Protector Options
---------------------------
https://mudongliang.github.io/2016/05/24/stack-protector.html

-fstack-protector
Emit extra code to check for buffer overflows, such as stack smashing
attacks. This is done by adding a guard variable to functions with
vulnerable objects.
This includes functions that call alloca, and functions with buffers
larger than 8 bytes.
The guards are initialized when a function is entered and then checked
when the function exits.
If a guard check fails, an error message is printed and the program exits.

-fno-stack-protector
Disable Stack Protector Check

-z execstack
execstack is a program which sets, clears, or queries executable stack
flag of ELF binaries and shared libraries.


Disable Address Space Layout Randomization (ASLR)
-------------------------------------------------
Linux (kernel >= 2.6.12)

Address space randomization hinders some types of security attacks by making
it more difficult for an attacker to predict target addresses.
For example, attackers trying to execute return-to-libc attacks must locate
the code to be executed, while other attackers trying to execute shellcode
injected on the stack have to find the stack first.
In both cases, the system obscures related memory-addresses from the attackers.
These values have to be guessed, and a mistaken guess is not usually recoverable
due to the application crashing.
(see: https://en.wikipedia.org/wiki/Address_space_layout_randomization)

How to turn off ASLR?
---------------------
# echo 0 > /proc/sys/kernel/randomize_va_space
# cat /proc/self/maps
