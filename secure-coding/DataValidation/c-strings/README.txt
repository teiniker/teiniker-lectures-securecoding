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
(gdb) r
(gdb) s
(gdb) print str_a
$3 = "Hello world!\n\000\004\b\000\340\345F"

(gdb) print &str_a
$4 = (char (*)[20]) 0xbfffef1c

(gdb) x/s str_a
0xbfffef1c: "Hello world!\n"

(gdb) x/20c str_a
0xbfffef1c: 72 'H'  101 'e' 108 'l' 108 'l' 111 'o' 32 ' '  119 'w' 111 'o'
0xbfffef24: 114 'r' 108 'l' 100 'd' 33 '!'  10 '\n' 0 '\000'    4 '\004'    8 '\b'
0xbfffef2c: 0 '\000'    -32 '\340'  -27 '\345'  70 'F'

(gdb) c
Continuing.
Hello world!

Truncate the string by inserting a '\0' character:
(gdb) set *(0xbfffef1c+5)='\0'
(gdc) c
"Hello"

