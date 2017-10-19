Stack Usage During a Function Call
----------------------------------------------------------------

$ gdb ./function_call

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
   0x00000000004004f1 <+0>:		push   rbp
   0x00000000004004f2 <+1>:		mov    rbp,rsp
   0x00000000004004f5 <+4>:		sub    rsp,0x20
   0x00000000004004f9 <+8>:		mov    DWORD PTR [rbp-0x14],edi
   0x00000000004004fc <+11>:	mov    QWORD PTR [rbp-0x20],rsi

   0x0000000000400500 <+15>:	mov    esi,0x44444444
   0x0000000000400505 <+20>:	mov    edi,0x22222222
   0x000000000040050a <+25>:	call   0x4004d7 <add>

   0x000000000040050f <+30>:	mov    DWORD PTR [rbp-0x4],eax
   0x0000000000400512 <+33>:	mov    eax,DWORD PTR [rbp-0x4]
   0x0000000000400515 <+36>:	mov    esi,eax
   0x0000000000400517 <+38>:	mov    edi,0x4005c0
   0x000000000040051c <+43>:	mov    eax,0x0
   0x0000000000400521 <+48>:	call   0x4003f0 <printf@plt>
   0x0000000000400526 <+53>:	mov    eax,0x0
   0x000000000040052b <+58>:	leave  
   0x000000000040052c <+59>:	ret  
   
Note that Intel disassembly flavor means: mov dest,src 

(gdb) disass add
Dump of assembler code for function add:
   0x00000000004004d7 <+0>:		push   rbp
   0x00000000004004d8 <+1>:		mov    rbp,rsp
   0x00000000004004db <+4>:		mov    DWORD PTR [rbp-0x14],edi
   0x00000000004004de <+7>:		mov    DWORD PTR [rbp-0x18],esi

   0x00000000004004e1 <+10>:	mov    edx,DWORD PTR [rbp-0x14]
   0x00000000004004e4 <+13>:	mov    eax,DWORD PTR [rbp-0x18]
   0x00000000004004e7 <+16>:	add    eax,edx
   0x00000000004004e9 <+18>:	mov    DWORD PTR [rbp-0x4],eax
   
   0x00000000004004ec <+21>:	mov    eax,DWORD PTR [rbp-0x4]
   0x00000000004004ef <+24>:	pop    rbp
   0x00000000004004f0 <+25>:	ret    
   

(gdb) break 7
Breakpoint 1 at 0x8048431: file function_call.c, line 7.

(gdb) break 14
Breakpoint 2 at 0x8048452: file function_call.c, line 14.

(gdb) r

(gdb) disass
Dump of assembler code for function main:
   0x00000000004004f1 <+0>:		push   rbp
   0x00000000004004f2 <+1>:		mov    rbp,rsp
   0x00000000004004f5 <+4>:		sub    rsp,0x20
   0x00000000004004f9 <+8>:		mov    DWORD PTR [rbp-0x14],edi
   0x00000000004004fc <+11>:	mov    QWORD PTR [rbp-0x20],rsi

=> 0x0000000000400500 <+15>:	mov    esi,0x44444444
   0x0000000000400505 <+20>:	mov    edi,0x22222222
   0x000000000040050a <+25>:	call   0x4004d7 <add>

   0x000000000040050f <+30>:	mov    DWORD PTR [rbp-0x4],eax
   0x0000000000400512 <+33>:	mov    eax,DWORD PTR [rbp-0x4]
   0x0000000000400515 <+36>:	mov    esi,eax
   0x0000000000400517 <+38>:	mov    edi,0x4005c0
   0x000000000040051c <+43>:	mov    eax,0x0
   0x0000000000400521 <+48>:	call   0x4003f0 <printf@plt>
   0x0000000000400526 <+53>:	mov    eax,0x0
   0x000000000040052b <+58>:	leave  
   0x000000000040052c <+59>:	ret      
   
   
(gdb) n
Breakpoint 1, add (a=572662306, b=1145324612) at function_call.c:7
7	    s = a+b;


(gdb) disass
Dump of assembler code for function add:
   0x00000000004004d7 <+0>:		push   rbp
   0x00000000004004d8 <+1>:		mov    rbp,rsp
   0x00000000004004db <+4>:		mov    DWORD PTR [rbp-0x14],edi
   0x00000000004004de <+7>:		mov    DWORD PTR [rbp-0x18],esi

=> 0x00000000004004e1 <+10>:	mov    edx,DWORD PTR [rbp-0x14]
   0x00000000004004e4 <+13>:	mov    eax,DWORD PTR [rbp-0x18]
   0x00000000004004e7 <+16>:	add    eax,edx
   0x00000000004004e9 <+18>:	mov    DWORD PTR [rbp-0x4],eax

   0x00000000004004ec <+21>:	mov    eax,DWORD PTR [rbp-0x4]   
   0x00000000004004ef <+24>:	pop    rbp
   0x00000000004004f0 <+25>:	ret    


(gdb) n
8	    return s;


(gdb) disass
Dump of assembler code for function add:
   0x00000000004004d7 <+0>:		push   rbp
   0x00000000004004d8 <+1>:		mov    rbp,rsp
   0x00000000004004db <+4>:		mov    DWORD PTR [rbp-0x14],edi
   0x00000000004004de <+7>:		mov    DWORD PTR [rbp-0x18],esi

   0x00000000004004e1 <+10>:	mov    edx,DWORD PTR [rbp-0x14]
   0x00000000004004e4 <+13>:	mov    eax,DWORD PTR [rbp-0x18]
   0x00000000004004e7 <+16>:	add    eax,edx
   0x00000000004004e9 <+18>:	mov    DWORD PTR [rbp-0x4],eax

=> 0x00000000004004ec <+21>:	mov    eax,DWORD PTR [rbp-0x4]
   0x00000000004004ef <+24>:	pop    rbp
   0x00000000004004f0 <+25>:	ret    
