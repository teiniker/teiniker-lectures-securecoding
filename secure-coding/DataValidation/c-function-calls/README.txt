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

Disable Address Space Layout Randomization (ASLR)
Linux (kernel >= 2.6.12)

# echo 0 > /proc/sys/kernel/randomize_va_space

# cat /proc/self/maps


Stack Usage During Function Calls (x64)
----------------------------------------------------------------

$ gdb ./function_call

(gdb) disass main
Dump of assembler code for function main:
   0x0000000000400516 <+0>:     push   rbp
   0x0000000000400517 <+1>:     mov    rbp,rsp
   0x000000000040051a <+4>:     sub    rsp,0x20
   0x000000000040051e <+8>:     mov    DWORD PTR [rbp-0x14],edi
   0x0000000000400521 <+11>:    mov    QWORD PTR [rbp-0x20],rsi
   0x0000000000400525 <+15>:    mov    esi,0x44444444
   0x000000000040052a <+20>:    mov    edi,0x22222222
   0x000000000040052f <+25>:    call   0x4004f1 <add1>
   0x0000000000400534 <+30>:    mov    DWORD PTR [rbp-0x4],eax
   0x0000000000400537 <+33>:    mov    eax,DWORD PTR [rbp-0x4]
   0x000000000040053a <+36>:    mov    esi,eax
   0x000000000040053c <+38>:    mov    edi,0x4005f0
   0x0000000000400541 <+43>:    mov    eax,0x0
   0x0000000000400546 <+48>:    call   0x4003f0 <printf@plt>
   0x000000000040054b <+53>:    mov    eax,0x0
   0x0000000000400550 <+58>:    leave
   0x0000000000400551 <+59>:    ret

(gdb) disass add1
Dump of assembler code for function add1:
   0x00000000004004f1 <+0>:     push   rbp
   0x00000000004004f2 <+1>:     mov    rbp,rsp
   0x00000000004004f5 <+4>:     sub    rsp,0x18
   0x00000000004004f9 <+8>:     mov    DWORD PTR [rbp-0x14],edi
   0x00000000004004fc <+11>:    mov    DWORD PTR [rbp-0x18],esi
   0x00000000004004ff <+14>:    mov    edx,DWORD PTR [rbp-0x18]
   0x0000000000400502 <+17>:    mov    eax,DWORD PTR [rbp-0x14]
   0x0000000000400505 <+20>:    mov    esi,edx
   0x0000000000400507 <+22>:    mov    edi,eax
   0x0000000000400509 <+24>:    call   0x4004d7 <add2>
   0x000000000040050e <+29>:    mov    DWORD PTR [rbp-0x4],eax
   0x0000000000400511 <+32>:    mov    eax,DWORD PTR [rbp-0x4]
   0x0000000000400514 <+35>:    leave
   0x0000000000400515 <+36>:    ret

(gdb) disass add2
Dump of assembler code for function add2:
   0x00000000004004d7 <+0>:     push   rbp
   0x00000000004004d8 <+1>:     mov    rbp,rsp
   0x00000000004004db <+4>:     mov    DWORD PTR [rbp-0x14],edi
   0x00000000004004de <+7>:     mov    DWORD PTR [rbp-0x18],esi
   0x00000000004004e1 <+10>:    mov    edx,DWORD PTR [rbp-0x14]
   0x00000000004004e4 <+13>:    mov    eax,DWORD PTR [rbp-0x18]
   0x00000000004004e7 <+16>:    add    eax,edx
   0x00000000004004e9 <+18>:    mov    DWORD PTR [rbp-0x4],eax
   0x00000000004004ec <+21>:    mov    eax,DWORD PTR [rbp-0x4]
   0x00000000004004ef <+24>:    pop    rbp
   0x00000000004004f0 <+25>:    ret

(gdb) break main
Breakpoint 1 at 0x400525: file function_call.c, line 23.

(gdb) break add1
Breakpoint 2 at 0x4004ff: file function_call.c, line 14.

(gdb) break add2
Breakpoint 3 at 0x4004e1: file function_call.c, line 6.


(gdb) r
Breakpoint 1, main (argc=1, argv=0x7fffffffdb18) at function_call.c:23
23          result = add1(0x22222222, 0x44444444);

(gdb) stepi
(gdb) stepi

(gdb) disass
Dump of assembler code for function main:
   0x0000000000400516 <+0>:     push   rbp
   0x0000000000400517 <+1>:     mov    rbp,rsp
   0x000000000040051a <+4>:     sub    rsp,0x20
   0x000000000040051e <+8>:     mov    DWORD PTR [rbp-0x14],edi
   0x0000000000400521 <+11>:    mov    QWORD PTR [rbp-0x20],rsi
   0x0000000000400525 <+15>:    mov    esi,0x44444444
   0x000000000040052a <+20>:    mov    edi,0x22222222
=> 0x000000000040052f <+25>:    call   0x4004f1 <add1>
>  0x0000000000400534 <+30>:    mov    DWORD PTR [rbp-0x4],eax
   0x0000000000400537 <+33>:    mov    eax,DWORD PTR [rbp-0x4]
   0x000000000040053a <+36>:    mov    esi,eax
   0x000000000040053c <+38>:    mov    edi,0x4005f0
   0x0000000000400541 <+43>:    mov    eax,0x0
   0x0000000000400546 <+48>:    call   0x4003f0 <printf@plt>
   0x000000000040054b <+53>:    mov    eax,0x0
   0x0000000000400550 <+58>:    leave
   0x0000000000400551 <+59>:    ret

(gdb) info register
rax            0x400516 4195606
rbx            0x0      0
rcx            0x0      0
rdx            0x7fffffffdb28   140737488345896
rsi            0x44444444       1145324612          <=
rdi            0x22222222       572662306           <=
rbp            0x7fffffffda30   0x7fffffffda30
rsp            0x7fffffffda10   0x7fffffffda10

(gdb) s

Breakpoint 2, add1 (a=572662306, b=1145324612) at function_call.c:14
14          s = add2(a,b);

(gdb) stepi
(gdb) stepi
(gdb) stepi
(gdb) stepi

(gdb) disass
Dump of assembler code for function add1:
   0x00000000004004f1 <+0>:     push   rbp
   0x00000000004004f2 <+1>:     mov    rbp,rsp
   0x00000000004004f5 <+4>:     sub    rsp,0x18
   0x00000000004004f9 <+8>:     mov    DWORD PTR [rbp-0x14],edi
   0x00000000004004fc <+11>:    mov    DWORD PTR [rbp-0x18],esi
   0x00000000004004ff <+14>:    mov    edx,DWORD PTR [rbp-0x18]
   0x0000000000400502 <+17>:    mov    eax,DWORD PTR [rbp-0x14]
   0x0000000000400505 <+20>:    mov    esi,edx
   0x0000000000400507 <+22>:    mov    edi,eax
=> 0x0000000000400509 <+24>:    call   0x4004d7 <add2>
>  0x000000000040050e <+29>:    mov    DWORD PTR [rbp-0x4],eax
   0x0000000000400511 <+32>:    mov    eax,DWORD PTR [rbp-0x4]
   0x0000000000400514 <+35>:    leave
   0x0000000000400515 <+36>:    ret

(gdb) info register
rax            0x22222222       572662306
rdx            0x44444444       1145324612
rsi            0x44444444       1145324612
rdi            0x22222222       572662306
rbp            0x7fffffffda00   0x7fffffffda00
rsp            0x7fffffffd9e8   0x7fffffffd9e8
rip            0x400509 0x400509 <add1+24>

(gdb) x/16xg $rsp
0x7fffffffd9e8: 0x2222222244444444      0x0000000000000001
0x7fffffffd9f8: 0x00000000004005ad      0x00007fffffffda30
0x7fffffffda08: 0x0000000000400534      0x00007fffffffdb18
0x7fffffffda18: 0x0000000100400400      0x00007fffffffdb10
0x7fffffffda28: 0x0000000000000000      0x0000000000400560
0x7fffffffda38: 0x00007f7c450be50a      0x0000000000000001
0x7fffffffda48: 0x00007fffffffdb18      0x0000000100040000

(gdb) s

Breakpoint 3, add2 (a=572662306, b=1145324612) at function_call.c:6
6           s = a+b;

(gdb) disass
Dump of assembler code for function add2:
   0x00000000004004d7 <+0>:     push   rbp
   0x00000000004004d8 <+1>:     mov    rbp,rsp
   0x00000000004004db <+4>:     mov    DWORD PTR [rbp-0x14],edi
   0x00000000004004de <+7>:     mov    DWORD PTR [rbp-0x18],esi
   0x00000000004004e1 <+10>:    mov    edx,DWORD PTR [rbp-0x14]
   0x00000000004004e4 <+13>:    mov    eax,DWORD PTR [rbp-0x18]
=> 0x00000000004004e7 <+16>:    add    eax,edx
   0x00000000004004e9 <+18>:    mov    DWORD PTR [rbp-0x4],eax
   0x00000000004004ec <+21>:    mov    eax,DWORD PTR [rbp-0x4]
   0x00000000004004ef <+24>:    pop    rbp
   0x00000000004004f0 <+25>:    ret

(gdb) stepi
(gdb) stepi

(gdb) info register
rax            0x44444444       1145324612
rdx            0x22222222       572662306
rsi            0x44444444       1145324612
rdi            0x22222222       572662306
rbp            0x7fffffffd9d8   0x7fffffffd9d8
rsp            0x7fffffffd9d8   0x7fffffffd9d8
rip            0x4004e7 0x4004e7 <add2+16>

(gdb) x/16xg $rbp-0x18
0x7fffffffd9c0: 0x2222222244444444      0x00000000756e6547
0x7fffffffd9d0: 0x0000000000000009      0x00007fffffffda00
0x7fffffffd9e0: 0x000000000040050e      0x2222222244444444
0x7fffffffd9f0: 0x0000000000000001      0x00000000004005ad
0x7fffffffda00: 0x00007fffffffda30      0x0000000000400534
0x7fffffffda10: 0x00007fffffffdb18      0x0000000100400400
0x7fffffffda20: 0x00007fffffffdb10      0x0000000000000000

(gdb) stepi
(gdb) stepi
(gdb) stepi

gdb) disass
Dump of assembler code for function add2:
   0x00000000004004d7 <+0>:     push   rbp
   0x00000000004004d8 <+1>:     mov    rbp,rsp
   0x00000000004004db <+4>:     mov    DWORD PTR [rbp-0x14],edi
   0x00000000004004de <+7>:     mov    DWORD PTR [rbp-0x18],esi
   0x00000000004004e1 <+10>:    mov    edx,DWORD PTR [rbp-0x14]
   0x00000000004004e4 <+13>:    mov    eax,DWORD PTR [rbp-0x18]
   0x00000000004004e7 <+16>:    add    eax,edx
   0x00000000004004e9 <+18>:    mov    DWORD PTR [rbp-0x4],eax
   0x00000000004004ec <+21>:    mov    eax,DWORD PTR [rbp-0x4]
=> 0x00000000004004ef <+24>:    pop    rbp
   0x00000000004004f0 <+25>:    ret

(gdb)  x/16xg $rbp-0x18
0x7fffffffd9c0: 0x2222222244444444      0x00000000756e6547
0x7fffffffd9d0: 0x6666666600000009      0x00007fffffffda00
0x7fffffffd9e0: 0x000000000040050e      0x2222222244444444
0x7fffffffd9f0: 0x0000000000000001      0x00000000004005ad
0x7fffffffda00: 0x00007fffffffda30      0x0000000000400534
0x7fffffffda10: 0x00007fffffffdb18      0x0000000100400400
0x7fffffffda20: 0x00007fffffffdb10      0x0000000000000000
0x7fffffffda30: 0x0000000000400560      0x00007fd20ce4a50a

(gdb) s
add1 (a=572662306, b=1145324612) at function_call.c:15

(gdb) stepi

(gdb) disass
Dump of assembler code for function add1:
   0x00000000004004f1 <+0>:     push   rbp
   0x00000000004004f2 <+1>:     mov    rbp,rsp
   0x00000000004004f5 <+4>:     sub    rsp,0x18
   0x00000000004004f9 <+8>:     mov    DWORD PTR [rbp-0x14],edi
   0x00000000004004fc <+11>:    mov    DWORD PTR [rbp-0x18],esi
   0x00000000004004ff <+14>:    mov    edx,DWORD PTR [rbp-0x18]
   0x0000000000400502 <+17>:    mov    eax,DWORD PTR [rbp-0x14]
   0x0000000000400505 <+20>:    mov    esi,edx
   0x0000000000400507 <+22>:    mov    edi,eax
   0x0000000000400509 <+24>:    call   0x4004d7 <add2>
   0x000000000040050e <+29>:    mov    DWORD PTR [rbp-0x4],eax
   0x0000000000400511 <+32>:    mov    eax,DWORD PTR [rbp-0x4]
=> 0x0000000000400514 <+35>:    leave
   0x0000000000400515 <+36>:    ret

(gdb) info register
rax            0x66666666       1717986918
rdx            0x22222222       572662306
rsi            0x44444444       1145324612
rdi            0x22222222       572662306
rbp            0x7fffffffda00   0x7fffffffda00
rsp            0x7fffffffd9e8   0x7fffffffd9e8
rip            0x400514 0x400514 <add1+35>

(gdb) x/16xg $rsp
0x7fffffffd9e8: 0x2222222244444444      0x0000000000000001
0x7fffffffd9f8: 0x66666666004005ad      0x00007fffffffda30
0x7fffffffda08: 0x0000000000400534      0x00007fffffffdb18
0x7fffffffda18: 0x0000000100400400      0x00007fffffffdb10
0x7fffffffda28: 0x0000000000000000      0x0000000000400560
0x7fffffffda38: 0x00007fd20ce4a50a      0x0000000000000001
0x7fffffffda48: 0x00007fffffffdb18      0x0000000100040000
0x7fffffffda58: 0x0000000000400516      0x0000000000000000

(gdb) s
main (argc=1, argv=0x7fffffffdb18) at function_call.c:25

(gdb) stepi

(gdb) disass
Dump of assembler code for function main:
   0x0000000000400516 <+0>:     push   rbp
   0x0000000000400517 <+1>:     mov    rbp,rsp
   0x000000000040051a <+4>:     sub    rsp,0x20
   0x000000000040051e <+8>:     mov    DWORD PTR [rbp-0x14],edi
   0x0000000000400521 <+11>:    mov    QWORD PTR [rbp-0x20],rsi
   0x0000000000400525 <+15>:    mov    esi,0x44444444
   0x000000000040052a <+20>:    mov    edi,0x22222222
   0x000000000040052f <+25>:    call   0x4004f1 <add1>
   0x0000000000400534 <+30>:    mov    DWORD PTR [rbp-0x4],eax
   0x0000000000400537 <+33>:    mov    eax,DWORD PTR [rbp-0x4]
=> 0x000000000040053a <+36>:    mov    esi,eax
   0x000000000040053c <+38>:    mov    edi,0x4005f0
   0x0000000000400541 <+43>:    mov    eax,0x0
   0x0000000000400546 <+48>:    call   0x4003f0 <printf@plt>
   0x000000000040054b <+53>:    mov    eax,0x0
   0x0000000000400550 <+58>:    leave
   0x0000000000400551 <+59>:    ret

(gdb) info register
rax            0x66666666       1717986918
rdx            0x22222222       572662306
rsi            0x44444444       1145324612
rdi            0x22222222       572662306
rbp            0x7fffffffda30   0x7fffffffda30
rsp            0x7fffffffda10   0x7fffffffda10
rip            0x40053a 0x40053a <main+36>

(gdb) x/16xg $rsp
0x7fffffffda10: 0x00007fffffffdb18      0x0000000100400400
0x7fffffffda20: 0x00007fffffffdb10      0x6666666600000000
0x7fffffffda30: 0x0000000000400560      0x00007fd20ce4a50a
0x7fffffffda40: 0x0000000000000001      0x00007fffffffdb18
0x7fffffffda50: 0x0000000100040000      0x0000000000400516
0x7fffffffda60: 0x0000000000000000      0x3608c4628c556a7f
0x7fffffffda70: 0x0000000000400400      0x00007fffffffdb10
0x7fffffffda80: 0x0000000000000000      0x0000000000000000

(gdb) c
Continuing.
result = 0x66666666
