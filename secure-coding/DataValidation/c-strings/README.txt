Strings in C
----------------------------------------------------------------

Technically, a string is equivalent to a character array.
An array is simply a list of n elements of a specific data type.
Arrays are also reffered to as buffers.

The last byte of a string is a null byte '\0' which is used
as a delimiter character.


String functions (vulnerable)
-----------------------------

#include <string.h>

char *strcpy(char *dest, const char *src);
    The  strcpy()  function  copies the string pointed to by src, including
    the terminating null byte ('\0'), to the buffer  pointed  to  by  dest.

char *gets(char *s);
    gets()  reads  a  line  from  stdin into the buffer pointed to by s until 
    either a terminating newline or EOF, which it replaces with a null byte ('\0'). 

int puts(const char *s);
    puts() writes the string s and a trailing newline to stdout.


Example: string_copy.c

  1 #include <stdio.h>
  2 #include <string.h>
  3 
  4 int main()
  5 {
  6     char str_a[20];
  7 
  8     strcpy(str_a, "Hello world!\n");
  9     printf("%s", str_a);
 10     return 0;
 11 }

(gdb) break main
Breakpoint 1, main () at string_copy.c:8
8               strcpy(str_a, "Hello world!\n");

(gdb) step
9               printf("%s", str_a);

gdb) disass
Dump of assembler code for function main:
   0x00000000004004d7 <+0>:     push   rbp
   0x00000000004004d8 <+1>:     mov    rbp,rsp
   0x00000000004004db <+4>:     sub    rsp,0x20
   0x00000000004004df <+8>:     lea    rax,[rbp-0x20]
   0x00000000004004e3 <+12>:    movabs rdx,0x6f77206f6c6c6548
   0x00000000004004ed <+22>:    mov    QWORD PTR [rax],rdx
   0x00000000004004f0 <+25>:    mov    DWORD PTR [rax+0x8],0x21646c72
   0x00000000004004f7 <+32>:    mov    WORD PTR [rax+0xc],0xa
=> 0x00000000004004fd <+38>:    lea    rax,[rbp-0x20]
   0x0000000000400501 <+42>:    mov    rsi,rax
   0x0000000000400504 <+45>:    mov    edi,0x4005b0
   0x0000000000400509 <+50>:    mov    eax,0x0
   0x000000000040050e <+55>:    call   0x4003f0 <printf@plt>
   0x0000000000400513 <+60>:    mov    eax,0x0
   0x0000000000400518 <+65>:    leave
   0x0000000000400519 <+66>:    ret

(gdb) print str_a
$1 = "Hello world!\n\000\000\000\000\333\377\377"

(gdb) print &str_a
$2 = (char (*)[20]) 0x7fffffffda00

(gdb) x/s str_a
0x7fffffffda00: "Hello world!\n"

(gdb) x/20c str_a
0x7fffffffda00: 72 'H'  101 'e' 108 'l' 108 'l' 111 'o' 32 ' '  119 'w' 111 'o'
0x7fffffffda08: 114 'r' 108 'l' 100 'd' 33 '!'  10 '\n' 0 '\000'        0 '\000'        0 '\000'
0x7fffffffda10: 0 '\000'        -37 '\333'      -1 '\377'       -1 '\377'

(gdb) c
Continuing.
Hello world!

Truncate the string by inserting a '\0' character:
--------------------------------------------------

(gdb) set *(0x7fffffffda00+5)='\0'

(gdb) x/s str_a
0x7fffffffda00: "Hello"

(gdb) c
Continuing.
Hello

