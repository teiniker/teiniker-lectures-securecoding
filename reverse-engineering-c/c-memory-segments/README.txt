Memory Segmentation of this C Programm
-------------------------------------------------------------------------------

stack segment:
    stack_var                   0x 0000 7ffc f744 ea54
    function.stack_var          0x 0000 7ffc f744 ea3c

heap segment:
    heap_var                    0x 0000 0000 00e4 c010

bss segment:
    global_var                  0x 0000 0000 0060 1044
    static_var                  0x 0000 0000 0060 1040

data segment:
    global_initialized_var      0x 0000 0000 0060 1034
    static_initialized_var      0x 0000 0000 0060 1038

code segment:
    main()                      0x 0000 0000 0040 0588
    function()                  0x 0000 0000 0040 0567


Note that the format string "%p" does not print the leading 0s.

Also, for every single run of this application the addresses will be different!


How to use Valgring to ckeck for memory leaks?
-------------------------------------------------------------------------------
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
