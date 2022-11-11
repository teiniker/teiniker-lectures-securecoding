# Example: Static Analysis - secret - Stripped

Given a simple C program that reads an input string and compares it to
a password. If the strings match, a secret (product key) is shown.
```
$ ./secret xxxxx
Invalid password!

$ ./secret 6LJ53vc6kFtwY_
ACD0-84F1-9A56-47BC
```

In addition to the regular build, we use `strip` which is a GNU utility to **remove symbols from binary files**. 
This is useful for minimizing their file size, streamlining them for distribution. 
It can also be useful for making it **more difficult to reverse-engineer** the compiled code.

As part of the make build process, we invoke the strip command.
```
$ make
gcc -std=c17 -Wall    -o secret secret.c 
strip secret 
```

When we use `file`, we can see that this executable is recognized as being stripped.
```
$ file secret
secret: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=9f7a058487ffae13f20a2a85ac0567ebb8d23ecd, for GNU/Linux 3.2.0, stripped
```

## Using the gdb

Disassembling `main()` and setting breakpoints is not possible anymore because function names 
have been removed.

```
(gdb) disass main
No symbol table is loaded.  Use the "file" command.
```

Only function from the standard library can be listed by their names:

```
(gdb) info functions
All defined functions:

Non-debugging symbols:
0x0000000000001030  puts@plt
0x0000000000001040  strcmp@plt
0x0000000000001050  exit@plt
0x0000000000001060  __cxa_finalize@plt
```

Using strip makes the static analysis a lot more tedious...


## References
* [Linux strip command](https://www.computerhope.com/unix/strip.htm)


*Egon Teiniker, 2020-2022, GPL v3.0* 
