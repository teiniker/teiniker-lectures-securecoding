Example: C Reverse Engineering (Static Analysis)
--------------------------------------------------------------------------

Given a simple C program that reads an input string and compares it to
a password. If the strings match, a secret code is shown.

$ make
gcc -std=c99 -Wall -o secret secret.c

Note that we use the compiler without debug flag.

$ ./secret xxxxx
Invalid password!

$ ./secret 0815
ACD0-84F1-9A56-47BC

Now, let's reverse engineer that binary file to find out the hidden
secret :-)


Static Analysis
---------------

Using 'file' we can determine the file type:

$ file secret
secret: ELF 64-bit LSB executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, for GNU/Linux 2.6.32, BuildID[sha1]=b5dfc30bffe9c6bddb31a61aa8ba5e75759e323b, not stripped


Using 'hexdump' we can display the binary content of the executable
(including ASCII text).
$ hexdump -C secret


To extract only strings used in the binary, we can use 'strings':
$ strings secret
/lib/ld-linux.so.2
libc.so.6
_IO_stdin_used
exit
puts
strcmp
__libc_start_main
__gmon_start__
GLIBC_2.0
PTRh
[^_]
ACD0-84F1-9A56-47BC
0815
Usage: secret <password>
Invalid password!
;*2$"

These strings could be used as possible passwords...


Finally, we can disassemble the binary using 'objdump'
$ objdump -d ./secret | less
080484cd <main>:
 80484cd:       55                      push   %ebp
 80484ce:       89 e5                   mov    %esp,%ebp
 80484d0:       83 e4 f0                and    $0xfffffff0,%esp
 80484d3:       83 ec 10                sub    $0x10,%esp
 80484d6:       83 7d 08 02             cmpl   $0x2,0x8(%ebp)
 80484da:       74 18                   je     80484f4 <main+0x27>
 80484dc:       c7 04 24 dd 85 04 08    movl   $0x80485dd,(%esp)
 80484e3:       e8 58 fe ff ff          call   8048340 <puts@plt>
 80484e8:       c7 04 24 00 00 00 00    movl   $0x0,(%esp)
 80484ef:       e8 6c fe ff ff          call   8048360 <exit@plt>
 80484f4:       8b 45 0c                mov    0xc(%ebp),%eax
 80484f7:       83 c0 04                add    $0x4,%eax
 80484fa:       8b 00                   mov    (%eax),%eax
 80484fc:       89 04 24                mov    %eax,(%esp)
 80484ff:       e8 9e ff ff ff          call   80484a2 <is_correct_password>
 8048504:       85 c0                   test   %eax,%eax
 8048506:       74 0f                   je     8048517 <main+0x4a>
 8048508:       e8 83 ff ff ff          call   8048490 <get_secret>
 804850d:       89 04 24                mov    %eax,(%esp)
 8048510:       e8 2b fe ff ff          call   8048340 <puts@plt>
 8048515:       eb 0c                   jmp    8048523 <main+0x56>
 8048517:       c7 04 24 f6 85 04 08    movl   $0x80485f6,(%esp)
 804851e:       e8 1d fe ff ff          call   8048340 <puts@plt>
 8048523:       b8 00 00 00 00          mov    $0x0,%eax
 8048528:       c9                      leave  
 8048529:       c3                      ret    
 804852a:       66 90                   xchg   %ax,%ax
 804852c:       66 90                   xchg   %ax,%ax
 804852e:       66 90                   xchg   %ax,%ax
