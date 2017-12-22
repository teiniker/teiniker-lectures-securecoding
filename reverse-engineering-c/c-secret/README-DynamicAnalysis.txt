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


Dynamic Analysis
----------------

Using 'strace' we can monitor the interaction between the application and the kernel:

$ strace ./secret xxxx

execve("./secret", ["./secret", "xxxx"], 0x7fff040a7af8 /* 55 vars */) = 0
brk(NULL)                               = 0xd7d000
mmap(NULL, 8192, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_ANONYMOUS, -1, 0) = 0x7fb0a0531000
access("/etc/ld.so.preload", R_OK)      = -1 ENOENT (No such file or directory)
open("/home/student/install/idea-IU-172.3757.52/bin/tls/x86_64/libc.so.6", O_RDONLY|O_CLOEXEC) = -1 ENOENT (No such file or directory)
stat("/home/student/install/idea-IU-172.3757.52/bin/tls/x86_64", 0x7ffdc1b4c5f0) = -1 ENOENT (No such file or directory)
open("/home/student/install/idea-IU-172.3757.52/bin/tls/libc.so.6", O_RDONLY|O_CLOEXEC) = -1 ENOENT (No such file or directory)
stat("/home/student/install/idea-IU-172.3757.52/bin/tls", 0x7ffdc1b4c5f0) = -1 ENOENT (No such file or directory)
open("/home/student/install/idea-IU-172.3757.52/bin/x86_64/libc.so.6", O_RDONLY|O_CLOEXEC) = -1 ENOENT (No such file or directory)
stat("/home/student/install/idea-IU-172.3757.52/bin/x86_64", 0x7ffdc1b4c5f0) = -1 ENOENT (No such file or directory)
open("/home/student/install/idea-IU-172.3757.52/bin/libc.so.6", O_RDONLY|O_CLOEXEC) = -1 ENOENT (No such file or directory)
stat("/home/student/install/idea-IU-172.3757.52/bin", {st_mode=S_IFDIR|0775, st_size=4096, ...}) = 0
open("tls/x86_64/libc.so.6", O_RDONLY|O_CLOEXEC) = -1 ENOENT (No such file or directory)
open("tls/libc.so.6", O_RDONLY|O_CLOEXEC) = -1 ENOENT (No such file or directory)
open("x86_64/libc.so.6", O_RDONLY|O_CLOEXEC) = -1 ENOENT (No such file or directory)
open("libc.so.6", O_RDONLY|O_CLOEXEC)   = -1 ENOENT (No such file or directory)
open("/etc/ld.so.cache", O_RDONLY|O_CLOEXEC) = 3
fstat(3, {st_mode=S_IFREG|0644, st_size=89250, ...}) = 0
mmap(NULL, 89250, PROT_READ, MAP_PRIVATE, 3, 0) = 0x7fb0a051b000
close(3)                                = 0
open("/lib64/libc.so.6", O_RDONLY|O_CLOEXEC) = 3
read(3, "\177ELF\2\1\1\3\0\0\0\0\0\0\0\0\3\0>\0\1\0\0\0 \6\2\0\0\0\0\0"..., 832) = 832
fstat(3, {st_mode=S_IFREG|0755, st_size=2163016, ...}) = 0
mmap(NULL, 4000032, PROT_READ|PROT_EXEC, MAP_PRIVATE|MAP_DENYWRITE, 3, 0) = 0x7fb09ff3c000
mprotect(0x7fb0a0103000, 2097152, PROT_NONE) = 0
mmap(0x7fb0a0303000, 24576, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x1c7000) = 0x7fb0a0303000
mmap(0x7fb0a0309000, 14624, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_ANONYMOUS, -1, 0) = 0x7fb0a0309000
close(3)                                = 0
mmap(NULL, 12288, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_ANONYMOUS, -1, 0) = 0x7fb0a0518000
arch_prctl(ARCH_SET_FS, 0x7fb0a0518700) = 0
mprotect(0x7fb0a0303000, 16384, PROT_READ) = 0
mprotect(0x600000, 4096, PROT_READ)     = 0
mprotect(0x7fb0a0533000, 4096, PROT_READ) = 0
munmap(0x7fb0a051b000, 89250)           = 0
fstat(1, {st_mode=S_IFCHR|0620, st_rdev=makedev(136, 0), ...}) = 0
brk(NULL)                               = 0xd7d000
brk(0xd9e000)                           = 0xd9e000
brk(NULL)                               = 0xd9e000
write(1, "Invalid password!\n", 18Invalid password!
)     = 18
exit_group(0)                           = ?
+++ exited with 0 +++

Because there is no file access we can not see much from system calls.


Using 'ltrace', we can trace the interaction between the application and the libraries: 

$ ltrace ./secret sdsd

strcmp("0815", "xxxx") = -72                <= !!!!
puts("Invalid password!"Invalid password!
) = 18
+++ exited (status 0) +++


Using the 'gdb' we can interactively execute the binary.
Note that we can not use the C source code because we did not use the
-g compiler flag.

$ gdb ./secret
(gdb) disass main
Dump of assembler code for function main:
   0x00000000004005a8 <+0>:	push   rbp
   0x00000000004005a9 <+1>:	mov    rbp,rsp
   0x00000000004005ac <+4>:	sub    rsp,0x10
   0x00000000004005b0 <+8>:	mov    DWORD PTR [rbp-0x4],edi
   0x00000000004005b3 <+11>:	mov    QWORD PTR [rbp-0x10],rsi
   0x00000000004005b7 <+15>:	cmp    DWORD PTR [rbp-0x4],0x2
   0x00000000004005bb <+19>:	je     0x4005d1 <main+41>
   0x00000000004005bd <+21>:	mov    edi,0x4006b9
   0x00000000004005c2 <+26>:	call   0x400460 <puts@plt>
   0x00000000004005c7 <+31>:	mov    edi,0x0
   0x00000000004005cc <+36>:	call   0x400480 <exit@plt>
   0x00000000004005d1 <+41>:	mov    rax,QWORD PTR [rbp-0x10]
   0x00000000004005d5 <+45>:	add    rax,0x8
   0x00000000004005d9 <+49>:	mov    rax,QWORD PTR [rax]
   0x00000000004005dc <+52>:	mov    rdi,rax
   0x00000000004005df <+55>:	call   0x400579 <is_correct_password>
=> 0x00000000004005e4 <+60>:	test   eax,eax                          <= !!!!
   0x00000000004005e6 <+62>:	je     0x4005f7 <main+79>
   0x00000000004005e8 <+64>:	call   0x400567 <get_secret>
   0x00000000004005ed <+69>:	mov    rdi,rax
   0x00000000004005f0 <+72>:	call   0x400460 <puts@plt>
   0x00000000004005f5 <+77>:	jmp    0x400601 <main+89>
   0x00000000004005f7 <+79>:	mov    edi,0x4006d2
   0x00000000004005fc <+84>:	call   0x400460 <puts@plt>
   0x0000000000400601 <+89>:	mov    eax,0x0
   0x0000000000400606 <+94>:	leave
   0x0000000000400607 <+95>:	ret

(gdb) disass is_correct_password
Dump of assembler code for function is_correct_password:
   0x0000000000400579 <+0>:	    push   rbp
   0x000000000040057a <+1>:	    mov    rbp,rsp
   0x000000000040057d <+4>:	    sub    rsp,0x10
   0x0000000000400581 <+8>:	    mov    QWORD PTR [rbp-0x8],rdi
   0x0000000000400585 <+12>:	mov    rax,QWORD PTR [rbp-0x8]
   0x0000000000400589 <+16>:	mov    rsi,rax
   0x000000000040058c <+19>:	mov    edi,0x4006b4
   0x0000000000400591 <+24>:	call   0x400470 <strcmp@plt>
   0x0000000000400596 <+29>:	test   eax,eax
   0x0000000000400598 <+31>:	jne    0x4005a1 <is_correct_password+40>
   0x000000000040059a <+33>:	mov    eax,0x1
   0x000000000040059f <+38>:	jmp    0x4005a6 <is_correct_password+45>
   0x00000000004005a1 <+40>:	mov    eax,0x0
   0x00000000004005a6 <+45>:	leave
   0x00000000004005a7 <+46>:	ret
End of assembler dump.

(gdb) break *0x00000000004005e4

(gdb) r xxxx
Starting program: /home/student/sandbox/teiniker-lectures-securecoding/reverse-engineering-c/c-secret/secret xxxx
Missing separate debuginfos, use: dnf debuginfo-install glibc-2.25-8.fc26.x86_64

Breakpoint 1, 0x00000000004005e4 in main ()
(gdb) disass
Dump of assembler code for function main:
   0x00000000004005a8 <+0>:	push   rbp
   0x00000000004005a9 <+1>:	mov    rbp,rsp
   0x00000000004005ac <+4>:	sub    rsp,0x10
   0x00000000004005b0 <+8>:	mov    DWORD PTR [rbp-0x4],edi
   0x00000000004005b3 <+11>:	mov    QWORD PTR [rbp-0x10],rsi
   0x00000000004005b7 <+15>:	cmp    DWORD PTR [rbp-0x4],0x2
   0x00000000004005bb <+19>:	je     0x4005d1 <main+41>
   0x00000000004005bd <+21>:	mov    edi,0x4006b9
   0x00000000004005c2 <+26>:	call   0x400460 <puts@plt>
   0x00000000004005c7 <+31>:	mov    edi,0x0
   0x00000000004005cc <+36>:	call   0x400480 <exit@plt>
   0x00000000004005d1 <+41>:	mov    rax,QWORD PTR [rbp-0x10]
   0x00000000004005d5 <+45>:	add    rax,0x8
   0x00000000004005d9 <+49>:	mov    rax,QWORD PTR [rax]
   0x00000000004005dc <+52>:	mov    rdi,rax
   0x00000000004005df <+55>:	call   0x400579 <is_correct_password>
=> 0x00000000004005e4 <+60>:	test   eax,eax
   0x00000000004005e6 <+62>:	je     0x4005f7 <main+79>
   0x00000000004005e8 <+64>:	call   0x400567 <get_secret>
   0x00000000004005ed <+69>:	mov    rdi,rax
   0x00000000004005f0 <+72>:	call   0x400460 <puts@plt>
   0x00000000004005f5 <+77>:	jmp    0x400601 <main+89>
   0x00000000004005f7 <+79>:	mov    edi,0x4006d2
   0x00000000004005fc <+84>:	call   0x400460 <puts@plt>
   0x0000000000400601 <+89>:	mov    eax,0x0
   0x0000000000400606 <+94>:	leave
   0x0000000000400607 <+95>:	ret
End of assembler dump.


(gdb) print $eax
$1 = 0

(gdb) c
Continuing.
Invalid password!
[Inferior 1 (process 3722) exited normally]


(gdb) r 0815

(gdb) print $eax
$2 = 1

(gdb) c
Continuing.
ACD0-84F1-9A56-47BC
[Inferior 1 (process 3723) exited normally]

Ok, let's hack the program execution...

(gdb) r xxxx

(gdb) print $eax
$3 = 0

(gdb) set $eax = 1

(gdb) print $eax
$4 = 1

(gdb) c
Continuing.
ACD0-84F1-9A56-47BC
[Inferior 1 (process 3725) exited normally]

Note that we have changed the control flow of the application by setting
register values.


Alternative approach
--------------------
(gdb) r xxxx
Breakpoint 1, 0x00000000004005e4 in main ()

(gdb) disass
Dump of assembler code for function main:
   0x00000000004005a8 <+0>:	push   rbp
   0x00000000004005a9 <+1>:	mov    rbp,rsp
   0x00000000004005ac <+4>:	sub    rsp,0x10
   0x00000000004005b0 <+8>:	mov    DWORD PTR [rbp-0x4],edi
   0x00000000004005b3 <+11>:	mov    QWORD PTR [rbp-0x10],rsi
   0x00000000004005b7 <+15>:	cmp    DWORD PTR [rbp-0x4],0x2
   0x00000000004005bb <+19>:	je     0x4005d1 <main+41>
   0x00000000004005bd <+21>:	mov    edi,0x4006b9
   0x00000000004005c2 <+26>:	call   0x400460 <puts@plt>
   0x00000000004005c7 <+31>:	mov    edi,0x0
   0x00000000004005cc <+36>:	call   0x400480 <exit@plt>
   0x00000000004005d1 <+41>:	mov    rax,QWORD PTR [rbp-0x10]
   0x00000000004005d5 <+45>:	add    rax,0x8
   0x00000000004005d9 <+49>:	mov    rax,QWORD PTR [rax]
   0x00000000004005dc <+52>:	mov    rdi,rax
   0x00000000004005df <+55>:	call   0x400579 <is_correct_password>
=> 0x00000000004005e4 <+60>:	test   eax,eax
   0x00000000004005e6 <+62>:	je     0x4005f7 <main+79>
   0x00000000004005e8 <+64>:	call   0x400567 <get_secret>    <= !!!!
   0x00000000004005ed <+69>:	mov    rdi,rax
   0x00000000004005f0 <+72>:	call   0x400460 <puts@plt>
   0x00000000004005f5 <+77>:	jmp    0x400601 <main+89>
   0x00000000004005f7 <+79>:	mov    edi,0x4006d2
   0x00000000004005fc <+84>:	call   0x400460 <puts@plt>
   0x0000000000400601 <+89>:	mov    eax,0x0
   0x0000000000400606 <+94>:	leave
   0x0000000000400607 <+95>:	ret
End of assembler dump.

(gdb) set ($rip)=0x00000000004005e8

(gdb) p $rip
$6 = (void (*)()) 0x4005e8 <main+64>

(gdb) c
Continuing.
ACD0-84F1-9A56-47BC
[Inferior 1 (process 3072) exited normally]

