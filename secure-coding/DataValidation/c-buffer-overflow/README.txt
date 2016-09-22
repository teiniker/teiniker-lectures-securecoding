Buffer Overflow
----------------------------------------------------------------------

A Buffer is a temporary space in memory used to hold data.

A Buffer Overflow happens when data written to a buffer is larger than the size of the buffer, and due to insufficient bounds checking it overflows and overwrites adjacent memory locations.


Requirements
----------------------------------------------------------------------

To show the principles of Buffer Overflow Attacks, we have to disable
all OS and compiler preventions:

gcc (>= 4.1)
    -mpreferred-stack-boundary=2 
    -fno-stack-protector 
    -z execstack


Linux (kernel >= 2.6.12)

# cat /proc/self/maps
bff06000-bff27000 rw-p 00000000 00:00 0          [stack]

# cat /proc/self/maps
bf94d000-bf96e000 rw-p 00000000 00:00 0          [stack]

Disable Address Space Layout Randomization (ASLR)
# echo 0 > /proc/sys/kernel/randomize_va_space

# cat /proc/self/maps 
bffdf000-c0000000 rw-p 00000000 00:00 0          [stack]

# cat /proc/self/maps
bffdf000-c0000000 rw-p 00000000 00:00 0          [stack]

