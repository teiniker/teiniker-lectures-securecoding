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
   0x00000000004004f1 <+0>:		push   %rbp
   0x00000000004004f2 <+1>:		mov    %rsp,%rbp
   0x00000000004004f5 <+4>:		sub    $0x20,%rsp
   0x00000000004004f9 <+8>:		mov    %edi,-0x14(%rbp)
   0x00000000004004fc <+11>:	mov    %rsi,-0x20(%rbp)

   0x0000000000400500 <+15>:	mov    $0x44444444,%esi
   0x0000000000400505 <+20>:	mov    $0x22222222,%edi
   0x000000000040050a <+25>:	callq  0x4004d7 <add>

   0x000000000040050f <+30>:	mov    %eax,-0x4(%rbp)
   0x0000000000400512 <+33>:	mov    -0x4(%rbp),%eax
   0x0000000000400515 <+36>:	mov    %eax,%esi
   0x0000000000400517 <+38>:	mov    $0x4005c0,%edi
   0x000000000040051c <+43>:	mov    $0x0,%eax
   0x0000000000400521 <+48>:	callq  0x4003f0 <printf@plt>
   0x0000000000400526 <+53>:	mov    $0x0,%eax
   0x000000000040052b <+58>:	leaveq 
   0x000000000040052c <+59>:	retq   


(gdb) disass add
Dump of assembler code for function add:
   0x00000000004004d7 <+0>:		push   %rbp
   0x00000000004004d8 <+1>:		mov    %rsp,%rbp
   0x00000000004004db <+4>:		mov    %edi,-0x14(%rbp)
   0x00000000004004de <+7>:		mov    %esi,-0x18(%rbp)

   0x00000000004004e1 <+10>:	mov    -0x14(%rbp),%edx
   0x00000000004004e4 <+13>:	mov    -0x18(%rbp),%eax
   0x00000000004004e7 <+16>:	add    %edx,%eax
   0x00000000004004e9 <+18>:	mov    %eax,-0x4(%rbp)
   0x00000000004004ec <+21>:	mov    -0x4(%rbp),%eax

   0x00000000004004ef <+24>:	pop    %rbp
   0x00000000004004f0 <+25>:	retq   
   

(gdb) break 7
Breakpoint 1 at 0x8048431: file function_call.c, line 7.

(gdb) break 14
Breakpoint 2 at 0x8048452: file function_call.c, line 14.

(gdb) r

(gdb) disass
Dump of assembler code for function main:
   0x00000000004004f1 <+0>:		push   %rbp
   0x00000000004004f2 <+1>:		mov    %rsp,%rbp
   0x00000000004004f5 <+4>:		sub    $0x20,%rsp
   0x00000000004004f9 <+8>:		mov    %edi,-0x14(%rbp)
   0x00000000004004fc <+11>:	mov    %rsi,-0x20(%rbp)

=> 0x0000000000400500 <+15>:	mov    $0x44444444,%esi
   0x0000000000400505 <+20>:	mov    $0x22222222,%edi
   0x000000000040050a <+25>:	callq  0x4004d7 <add>

   0x000000000040050f <+30>:	mov    %eax,-0x4(%rbp)
   0x0000000000400512 <+33>:	mov    -0x4(%rbp),%eax
   0x0000000000400515 <+36>:	mov    %eax,%esi
   0x0000000000400517 <+38>:	mov    $0x4005c0,%edi
   0x000000000040051c <+43>:	mov    $0x0,%eax
   0x0000000000400521 <+48>:	callq  0x4003f0 <printf@plt>
   0x0000000000400526 <+53>:	mov    $0x0,%eax
   0x000000000040052b <+58>:	leaveq 
   0x000000000040052c <+59>:	retq 
   
   
(gdb) n
Breakpoint 1, add (a=572662306, b=1145324612) at function_call.c:7
7	    s = a+b;


(gdb) disass 
Dump of assembler code for function add:
   0x00000000004004d7 <+0>:		push   %rbp
   0x00000000004004d8 <+1>:		mov    %rsp,%rbp
   0x00000000004004db <+4>:		mov    %edi,-0x14(%rbp)
   0x00000000004004de <+7>:		mov    %esi,-0x18(%rbp)

=> 0x00000000004004e1 <+10>:	mov    -0x14(%rbp),%edx
   0x00000000004004e4 <+13>:	mov    -0x18(%rbp),%eax
   0x00000000004004e7 <+16>:	add    %edx,%eax
   0x00000000004004e9 <+18>:	mov    %eax,-0x4(%rbp)
   0x00000000004004ec <+21>:	mov    -0x4(%rbp),%eax

   0x00000000004004ef <+24>:	pop    %rbp
   0x00000000004004f0 <+25>:	retq   


(gdb) n
8	    return s;


(gdb) disass
Dump of assembler code for function add:
   0x00000000004004d7 <+0>:		push   %rbp
   0x00000000004004d8 <+1>:		mov    %rsp,%rbp
   0x00000000004004db <+4>:		mov    %edi,-0x14(%rbp)
   0x00000000004004de <+7>:		mov    %esi,-0x18(%rbp)

   0x00000000004004e1 <+10>:	mov    -0x14(%rbp),%edx
   0x00000000004004e4 <+13>:	mov    -0x18(%rbp),%eax
   0x00000000004004e7 <+16>:	add    %edx,%eax
   0x00000000004004e9 <+18>:	mov    %eax,-0x4(%rbp)
=> 0x00000000004004ec <+21>:	mov    -0x4(%rbp),%eax

   0x00000000004004ef <+24>:	pop    %rbp
   0x00000000004004f0 <+25>:	retq   
