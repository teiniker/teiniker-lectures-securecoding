Stack Usage During a Function Call
----------------------------------------------------------------

(gdb) list 1
1	#include<stdio.h>
2	
3	
4	int add(int a, int b)
5	{
6	    int s;
7	    s = a+b;
8	    return s;
9	}
10	
(gdb) l
11	
12	int main(int argc, char** argv)
13	{
14	    int result = add(0x22222222, 0x44444444);
15	
16	    printf("result = 0x%08x\n", result);
17	    return 0;    
18	}


(gdb) disass main
Dump of assembler code for function main:
   0x08048441 <+0>:		lea    ecx,[esp+0x4]
   0x08048445 <+4>:		and    esp,0xfffffff0
   0x08048448 <+7>:		push   DWORD PTR [ecx-0x4]
   0x0804844b <+10>:	push   ebp
   0x0804844c <+11>:	mov    ebp,esp
   0x0804844e <+13>:	push   ecx
   0x0804844f <+14>:	sub    esp,0x14
   0x08048452 <+17>:	push   0x44444444
   0x08048457 <+22>:	push   0x22222222
   0x0804845c <+27>:	call   0x804842b <add>
   0x08048461 <+32>:	add    esp,0x8
   0x08048464 <+35>:	mov    DWORD PTR [ebp-0xc],eax
   0x08048467 <+38>:	sub    esp,0x8
   0x0804846a <+41>:	push   DWORD PTR [ebp-0xc]
   0x0804846d <+44>:	push   0x8048514
   0x08048472 <+49>:	call   0x80482f0 <printf@plt>
   0x08048477 <+54>:	add    esp,0x10
   0x0804847a <+57>:	mov    eax,0x0
   0x0804847f <+62>:	mov    ecx,DWORD PTR [ebp-0x4]
   0x08048482 <+65>:	leave  
   0x08048483 <+66>:	lea    esp,[ecx-0x4]
   0x08048486 <+69>:	ret    

(gdb) disass add
Dump of assembler code for function add:
   0x0804842b <+0>:		push   ebp
   0x0804842c <+1>:		mov    ebp,esp
   0x0804842e <+3>:		sub    esp,0x10
   0x08048431 <+6>:		mov    edx,DWORD PTR [ebp+0x8]
   0x08048434 <+9>:		mov    eax,DWORD PTR [ebp+0xc]
   0x08048437 <+12>:	add    eax,edx
   0x08048439 <+14>:	mov    DWORD PTR [ebp-0x4],eax
   0x0804843c <+17>:	mov    eax,DWORD PTR [ebp-0x4]
   0x0804843f <+20>:	leave  
   0x08048440 <+21>:	ret  
   

(gdb) break 7
Breakpoint 1 at 0x8048431: file function_call.c, line 7.

(gdb) break 14
Breakpoint 2 at 0x8048452: file function_call.c, line 14.

(gdb) r

(gdb) disass
Dump of assembler code for function main:
   0x08048441 <+0>:		lea    ecx,[esp+0x4]
   0x08048445 <+4>:		and    esp,0xfffffff0
   0x08048448 <+7>:		push   DWORD PTR [ecx-0x4]
   0x0804844b <+10>:	push   ebp
   0x0804844c <+11>:	mov    ebp,esp
   0x0804844e <+13>:	push   ecx
   0x0804844f <+14>:	sub    esp,0x14
=> 0x08048452 <+17>:	push   0x44444444
   0x08048457 <+22>:	push   0x22222222
   0x0804845c <+27>:	call   0x804842b <add>
   0x08048461 <+32>:	add    esp,0x8
   0x08048464 <+35>:	mov    DWORD PTR [ebp-0xc],eax
   0x08048467 <+38>:	sub    esp,0x8
   0x0804846a <+41>:	push   DWORD PTR [ebp-0xc]
   0x0804846d <+44>:	push   0x8048514
   0x08048472 <+49>:	call   0x80482f0 <printf@plt>
   0x08048477 <+54>:	add    esp,0x10
   0x0804847a <+57>:	mov    eax,0x0
   0x0804847f <+62>:	mov    ecx,DWORD PTR [ebp-0x4]
   0x08048482 <+65>:	leave  
   0x08048483 <+66>:	lea    esp,[ecx-0x4]
   0x08048486 <+69>:	ret    
End of assembler dump.

(gdb) x/8xw $esp
0xbfffee30:	0x00000001	0xbfffeef4	0xbfffeefc	0x080484b1
0xbfffee40:	0xb7fc23dc	0xbfffee60	0x00000000	0xb7e12715

(gdb) n
Breakpoint 1, add (a=572662306, b=1145324612) at function_call.c:7
7	    s = a+b;

(gdb) disass
Dump of assembler code for function add:
   0x0804842b <+0>:		push   ebp
   0x0804842c <+1>:		mov    ebp,esp
   0x0804842e <+3>:		sub    esp,0x10
=> 0x08048431 <+6>:		mov    edx,DWORD PTR [ebp+0x8]
   0x08048434 <+9>:		mov    eax,DWORD PTR [ebp+0xc]
   0x08048437 <+12>:	add    eax,edx
   0x08048439 <+14>:	mov    DWORD PTR [ebp-0x4],eax
   0x0804843c <+17>:	mov    eax,DWORD PTR [ebp-0x4]
   0x0804843f <+20>:	leave  
   0x08048440 <+21>:	ret    

(gdb) x/32xw $esp
0xbfffee10:	0xb7fc2000	0x00000001	0x00002000	0x00000002
0xbfffee20:	0xbfffee48	0x08048461	0x22222222	0x44444444
0xbfffee30:	0x00000001	0xbfffeef4	0xbfffeefc	0x080484b1
0xbfffee40:	0xb7fc23dc	0xbfffee60	0x00000000	0xb7e12715
0xbfffee50:	0x00000001	0xb7fc2000	0x00000000	0xb7e12715
0xbfffee60:	0x00000001	0xbfffeef4	0xbfffeefc	0x00000000
0xbfffee70:	0x00000000	0x00000000	0xb7fc2000	0xb7fffbe4
0xbfffee80:	0x0804821c	0x00000000	0x00000001	0xb7fc2000


(gdb) s
8	    return s;

(gdb) disass
Dump of assembler code for function add:
   0x0804842b <+0>:		push   ebp
   0x0804842c <+1>:		mov    ebp,esp
   0x0804842e <+3>:		sub    esp,0x10
   0x08048431 <+6>:		mov    edx,DWORD PTR [ebp+0x8]
   0x08048434 <+9>:		mov    eax,DWORD PTR [ebp+0xc]
   0x08048437 <+12>:	add    eax,edx
   0x08048439 <+14>:	mov    DWORD PTR [ebp-0x4],eax
=> 0x0804843c <+17>:	mov    eax,DWORD PTR [ebp-0x4]
   0x0804843f <+20>:	leave  
   0x08048440 <+21>:	ret    


(gdb) x/32xw $esp
0xbfffee10:	0xb7fc2000	0x00000001	0x00002000	0x66666666
0xbfffee20:	0xbfffee48	0x08048461	0x22222222	0x44444444
0xbfffee30:	0x00000001	0xbfffeef4	0xbfffeefc	0x080484b1
0xbfffee40:	0xb7fc23dc	0xbfffee60	0x00000000	0xb7e12715
0xbfffee50:	0x00000001	0xb7fc2000	0x00000000	0xb7e12715
0xbfffee60:	0x00000001	0xbfffeef4	0xbfffeefc	0x00000000
0xbfffee70:	0x00000000	0x00000000	0xb7fc2000	0xb7fffbe4
0xbfffee80:	0x0804821c	0x00000000	0x00000001	0xb7fc2000

