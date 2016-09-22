Stack Usage During a Function Call
----------------------------------------------------------------

  4 void add(int a, int b)
  5 {
  6     int s;
  7     s = a+b;
  8 }
  9 
 10 
 11 int main(int argc, char** argv)
 12 {
 13     add(0x22222222, 0x44444444);
 14  
 15     return 0;
 16 }

(gdb) disass main
Dump of assembler code for function main:
   0x08048413 <+0>: push   ebp
   0x08048414 <+1>: mov    ebp,esp
   0x08048416 <+3>: sub    esp,0x8
   0x08048419 <+6>: mov    DWORD PTR [esp+0x4],0x44444444
   0x08048421 <+14>:    mov    DWORD PTR [esp],0x22222222
   0x08048428 <+21>:    call   0x8048400 <add>
   0x0804842d <+26>:    mov    eax,0x0
   0x08048432 <+31>:    leave  
   0x08048433 <+32>:    ret    

(gdb) disass add
Dump of assembler code for function add:
   0x08048400 <+0>: push   ebp
   0x08048401 <+1>: mov    ebp,esp
   0x08048403 <+3>: sub    esp,0x4
   0x08048406 <+6>: mov    eax,DWORD PTR [ebp+0xc]
   0x08048409 <+9>: mov    edx,DWORD PTR [ebp+0x8]
   0x0804840c <+12>:    add    eax,edx
   0x0804840e <+14>:    mov    DWORD PTR [ebp-0x4],eax
   0x08048411 <+17>:    leave  
   0x08048412 <+18>:    ret  

(gdb) break 7
(gdb) break 13
(gdb) r

(gdb) disass
Dump of assembler code for function main:
   0x08048413 <+0>:     push   ebp
   0x08048414 <+1>:     mov    ebp,esp
   0x08048416 <+3>:     sub    esp,0x8
=> 0x08048419 <+6>:     mov    DWORD PTR [esp+0x4],0x44444444
   0x08048421 <+14>:    mov    DWORD PTR [esp],0x22222222
   0x08048428 <+21>:    call   0x8048400 <add>
   0x0804842d <+26>:    mov    eax,0x0
   0x08048432 <+31>:    leave  
   0x08048433 <+32>:    ret    

(gdb) x/8xw $esp
0xbfffef10: 0x08048440  0x00000000  0x00000000  0x46cbe963
0xbfffef20: 0x00000001  0xbfffefb4  0xbfffefbc  0xb7ffe6b0

(gdb) n
Breakpoint 1, add (a=572662306, b=1145324612) at function_call.c:7

(gdb) x/32xw $esp
0xbfffef04: 0x0000002f  0xbfffef18  0x0804842d  0x22222222
0xbfffef14: 0x44444444  0x00000000  0x46cbe963  0x00000001
0xbfffef24: 0xbfffefb4  0xbfffefbc  0xb7ffe6b0  0x00000001
0xbfffef34: 0x00000001  0x00000000  0x0804a010  0x0804820c
0xbfffef44: 0x46e5e000  0x00000000  0x00000000  0x00000000
0xbfffef54: 0xf7220fab  0x9f2e0a59  0x00000000  0x00000000
0xbfffef64: 0x00000000  0x00000001  0x080482f0  0x00000000
0xbfffef74: 0x46c96f10  0x46cbe879  0x46ca1fd4  0x00000001

(gdb) disass
Dump of assembler code for function add:
   0x08048400 <+0>:     push   ebp
   0x08048401 <+1>:     mov    ebp,esp
   0x08048403 <+3>:     sub    esp,0x4
=> 0x08048406 <+6>:     mov    eax,DWORD PTR [ebp+0xc]
   0x08048409 <+9>:     mov    edx,DWORD PTR [ebp+0x8]
   0x0804840c <+12>:    add    eax,edx
   0x0804840e <+14>:    mov    DWORD PTR [ebp-0x4],eax
   0x08048411 <+17>:    leave  
   0x08048412 <+18>:    ret    

(gdb) s

(gdb) disass
Dump of assembler code for function add:
   0x08048400 <+0>:     push   ebp
   0x08048401 <+1>:     mov    ebp,esp
   0x08048403 <+3>:     sub    esp,0x4
   0x08048406 <+6>:     mov    eax,DWORD PTR [ebp+0xc]
   0x08048409 <+9>:     mov    edx,DWORD PTR [ebp+0x8]
   0x0804840c <+12>:    add    eax,edx
   0x0804840e <+14>:    mov    DWORD PTR [ebp-0x4],eax
=> 0x08048411 <+17>:    leave  
   0x08048412 <+18>:    ret    

(gdb) x/32xw $esp
0xbfffef04: 0x66666666  0xbfffef18  0x0804842d  0x22222222
0xbfffef14: 0x44444444  0x00000000  0x46cbe963  0x00000001
0xbfffef24: 0xbfffefb4  0xbfffefbc  0xb7ffe6b0  0x00000001
0xbfffef34: 0x00000001  0x00000000  0x0804a010  0x0804820c
0xbfffef44: 0x46e5e000  0x00000000  0x00000000  0x00000000
0xbfffef54: 0xf7220fab  0x9f2e0a59  0x00000000  0x00000000
0xbfffef64: 0x00000000  0x00000001  0x080482f0  0x00000000
0xbfffef74: 0x46c96f10  0x46cbe879  0x46ca1fd4  0x00000001

