Example: C Reverse Engineering
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
secret: ELF 32-bit LSB executable, Intel 80386, version 1 (SYSV), dynamically linked (uses shared libs), for GNU/Linux 2.6.32, BuildID[sha1]=0x75f5d26ce89ecceea02b7135728a6b1618db5e5f, not stripped


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


Dynamic Analysis
----------------

Using 'strace' we can monitor the interaction between the application and the kernel:
$ strace ./secret sdsd
execve("./secret", ["./secret", "sdsd"], [/* 54 vars */]) = 0
brk(0)                                  = 0x9366000
mmap2(NULL, 4096, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_ANONYMOUS, -1, 0) = 0xb777b000
access("/etc/ld.so.preload", R_OK)      = -1 ENOENT (No such file or directory)
open("/etc/ld.so.cache", O_RDONLY|O_CLOEXEC) = 3
fstat64(3, {st_mode=S_IFREG|0644, st_size=69946, ...}) = 0
mmap2(NULL, 69946, PROT_READ, MAP_PRIVATE, 3, 0) = 0xb7769000
close(3)                                = 0
open("/lib/libc.so.6", O_RDONLY|O_CLOEXEC) = 3
read(3, "\177ELF\1\1\1\3\0\0\0\0\0\0\0\0\3\0\3\0\1\0\0\0\300\352\313F4\0\0\0"..., 512) = 512
fstat64(3, {st_mode=S_IFREG|0755, st_size=2058000, ...}) = 0
mmap2(0x46ca5000, 1821308, PROT_READ|PROT_EXEC, MAP_PRIVATE|MAP_DENYWRITE, 3, 0) = 0x46ca5000
mmap2(0x46e5c000, 12288, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x1b6000) = 0x46e5c000
mmap2(0x46e5f000, 10876, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_ANONYMOUS, -1, 0) = 0x46e5f000
close(3)                                = 0
mmap2(NULL, 4096, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_ANONYMOUS, -1, 0) = 0xb7768000
set_thread_area({entry_number:-1 -> 6, base_addr:0xb77686c0, limit:1048575, seg_32bit:1, contents:0, read_exec_only:0, limit_in_pages:1, seg_not_present:0, useable:1}) = 0
mprotect(0x46e5c000, 8192, PROT_READ)   = 0
mprotect(0x8049000, 4096, PROT_READ)    = 0
mprotect(0x46ca1000, 4096, PROT_READ)   = 0
munmap(0xb7769000, 69946)               = 0
fstat64(1, {st_mode=S_IFCHR|0620, st_rdev=makedev(136, 1), ...}) = 0
mmap2(NULL, 4096, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_ANONYMOUS, -1, 0) = 0xb777a000
write(1, "Invalid password!\n", 18Invalid password!
)     = 18
exit_group(0)                           = ?
+++ exited with 0 +++


Using 'ltrace', we can trace the interaction between the application and the libraries: 
$ ltrace ./secret sdsd
__libc_start_main(0x80484cd, 2, 0xbf8f3254, 0x8048530 <unfinished ...>
strcmp("0815", "sdsd")                                                                                = -1
puts("Invalid password!"Invalid password!
)                                                                             = 18
+++ exited (status 0) +++

Note the strcmp() call...


Using the 'gdb' we can interactively execute the binary:
$ gdb ./secret
(gdb) disass main
Dump of assembler code for function main:
   0x080484cd <+0>:     push   ebp
   0x080484ce <+1>:     mov    ebp,esp
   0x080484d0 <+3>:     and    esp,0xfffffff0
   0x080484d3 <+6>:     sub    esp,0x10
   0x080484d6 <+9>:     cmp    DWORD PTR [ebp+0x8],0x2
   0x080484da <+13>:    je     0x80484f4 <main+39>
   0x080484dc <+15>:    mov    DWORD PTR [esp],0x80485dd
   0x080484e3 <+22>:    call   0x8048340 <puts@plt>
   0x080484e8 <+27>:    mov    DWORD PTR [esp],0x0
   0x080484ef <+34>:    call   0x8048360 <exit@plt>
   0x080484f4 <+39>:    mov    eax,DWORD PTR [ebp+0xc]
   0x080484f7 <+42>:    add    eax,0x4
   0x080484fa <+45>:    mov    eax,DWORD PTR [eax]
   0x080484fc <+47>:    mov    DWORD PTR [esp],eax
   0x080484ff <+50>:    call   0x80484a2 <is_correct_password>
   0x08048504 <+55>:    test   eax,eax
   0x08048506 <+57>:    je     0x8048517 <main+74>
   0x08048508 <+59>:    call   0x8048490 <get_secret>
   0x0804850d <+64>:    mov    DWORD PTR [esp],eax
   0x08048510 <+67>:    call   0x8048340 <puts@plt>
   0x08048515 <+72>:    jmp    0x8048523 <main+86>
   0x08048517 <+74>:    mov    DWORD PTR [esp],0x80485f6
   0x0804851e <+81>:    call   0x8048340 <puts@plt>
   0x08048523 <+86>:    mov    eax,0x0
   0x08048528 <+91>:    leave  
   0x08048529 <+92>:    ret    

(gdb) disass is_correct_password 
Dump of assembler code for function is_correct_password:
   0x080484a2 <+0>:     push   ebp
   0x080484a3 <+1>:     mov    ebp,esp
   0x080484a5 <+3>:     sub    esp,0x18
   0x080484a8 <+6>:     mov    eax,DWORD PTR [ebp+0x8]
   0x080484ab <+9>:     mov    DWORD PTR [esp+0x4],eax
   0x080484af <+13>:    mov    DWORD PTR [esp],0x80485d8
   0x080484b6 <+20>:    call   0x8048330 <strcmp@plt>
   0x080484bb <+25>:    test   eax,eax
   0x080484bd <+27>:    jne    0x80484c6 <is_correct_password+36>
   0x080484bf <+29>:    mov    eax,0x1
   0x080484c4 <+34>:    jmp    0x80484cb <is_correct_password+41>
   0x080484c6 <+36>:    mov    eax,0x0
   0x080484cb <+41>:    leave  
   0x080484cc <+42>:    ret  

(gdb) break *0x08048504

(gdb) r xxxx
Starting program: /home/student/workspace-c/c-secret/secret xxxx

Breakpoint 1, 0x08048504 in main ()
(gdb) disass
Dump of assembler code for function main:
   0x080484cd <+0>: push   ebp
   0x080484ce <+1>: mov    ebp,esp
   0x080484d0 <+3>: and    esp,0xfffffff0
   0x080484d3 <+6>: sub    esp,0x10
   0x080484d6 <+9>: cmp    DWORD PTR [ebp+0x8],0x2
   0x080484da <+13>:    je     0x80484f4 <main+39>
   0x080484dc <+15>:    mov    DWORD PTR [esp],0x80485dd
   0x080484e3 <+22>:    call   0x8048340 <puts@plt>
   0x080484e8 <+27>:    mov    DWORD PTR [esp],0x0
   0x080484ef <+34>:    call   0x8048360 <exit@plt>
   0x080484f4 <+39>:    mov    eax,DWORD PTR [ebp+0xc]
   0x080484f7 <+42>:    add    eax,0x4
   0x080484fa <+45>:    mov    eax,DWORD PTR [eax]
   0x080484fc <+47>:    mov    DWORD PTR [esp],eax
   0x080484ff <+50>:    call   0x80484a2 <is_correct_password>
=> 0x08048504 <+55>:    test   eax,eax
   0x08048506 <+57>:    je     0x8048517 <main+74>
   0x08048508 <+59>:    call   0x8048490 <get_secret>
   0x0804850d <+64>:    mov    DWORD PTR [esp],eax
   0x08048510 <+67>:    call   0x8048340 <puts@plt>
   0x08048515 <+72>:    jmp    0x8048523 <main+86>
   0x08048517 <+74>:    mov    DWORD PTR [esp],0x80485f6
   0x0804851e <+81>:    call   0x8048340 <puts@plt>
   0x08048523 <+86>:    mov    eax,0x0
   0x08048528 <+91>:    leave  
   0x08048529 <+92>:    ret    


(gdb) print $eax
$1 = 0
(gdb) c
Continuing.
Invalid password!
[Inferior 1 (process 3722) exited normally]


(gdb) print $eax
$2 = 1
(gdb) c
Continuing.
ACD0-84F1-9A56-47BC
[Inferior 1 (process 3723) exited normally]


(gdb) r xxxx
Starting program: /home/student/workspace-c/c-secret/secret xxxx
Breakpoint 1, 0x08048504 in main ()
(gdb) print $eax
$3 = 0
(gdb) set $eax = 1
(gdb) print $eax
$4 = 1
(gdb) c
Continuing.
ACD0-84F1-9A56-47BC
[Inferior 1 (process 3725) exited normally]
