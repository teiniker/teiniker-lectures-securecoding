# Example: File Access - Tracing System Calls  

We try to guess the right password for the user `student`:
```
$ ./file_login 
username> student
password> student
Login rejected!
```

From the given source code we can see that file_login reads user 
credentials from a file.
```C
bool is_valid_user(char* username, char* password)
{
    char _username[256];
    char _password[256];
    FILE *fp;
    fp = fopen("application-users.config", "r");
    if (fp == NULL) 
    {
        fprintf(stderr, "Can't open passwords.txt file!\n");
        return false;
    }
    
    while(fscanf(fp, "%s %s", _username, _password) != EOF)
    {
        if(strcmp(username,_username) == 0
            && strcmp(password,_password) == 0)
        {
            fclose(fp);
            return true;
        }
    }
    fclose(fp);
    return false;
}
```
## Using strip to Remove Symbols

strip is a GNU utility to `strip` symbols from object files. 
This is useful for minimizing their file size, streamlining them for distribution. 
It can also be useful for making it **more difficult to reverse-engineer** the compiled code.

As part of the make build process, we invoke the strip command.
```
$ make
gcc -std=c99 -Wall    -o file_login file_login.c 
strip file_login
```

When we use file, we can see that this executable is recognized as being stripped.
```
$ file file_login
file_login: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=690f7f16d2d09caa8d81775a1e471d67c8416bd2, for GNU/Linux 3.2.0, stripped
```


## Using strace and ltrace

Both strace and ltrace will work as before because the name library functions and system calls stay intact.

```
$ strace ./file_login 
execve("./file_login", ["./file_login"], 0x7ffd10526780 /* 53 vars */) = 0
...
openat(AT_FDCWD, "application-users.config", O_RDONLY) = 3
fstat(3, {st_mode=S_IFREG|0644, st_size=39, ...}) = 0
read(3, "student de1d9228df\nteacher 96c2d"..., 4096) = 39
read(3, "", 4096)                       = 0
close(3)                                = 0
write(1, "Login rejected!\n", 16Login rejected!
)       = 16
lseek(0, -1, SEEK_CUR)                  = -1 ESPIPE (Illegal seek)
exit_group(0)                           = ?
+++ exited with 0 +++
```

```
$ ltrace ./file_login 
...
fopen("application-users.config", "r")                                         = 0x55ba1ff9dac0
__isoc99_fscanf(0x55ba1ff9dac0, 0x55ba1e5d7053, 0x7ffee77c2410, 0x7ffee77c2310) = 2
strcmp("student", "student")                                                   = 0
strcmp("student", "de1d9228df")                                                = 15
__isoc99_fscanf(0x55ba1ff9dac0, 0x55ba1e5d7053, 0x7ffee77c2410, 0x7ffee77c2310) = 2
strcmp("student", "teacher")                                                   = -1
__isoc99_fscanf(0x55ba1ff9dac0, 0x55ba1e5d7053, 0x7ffee77c2410, 0x7ffee77c2310) = 0xffffffff
fclose(0x55ba1ff9dac0)                                                         = 0
puts("Login rejected!"Login rejected!
)                                                        = 16
+++ exited (status 0) +++
```

## Using gdb

Disassembling `main()` and setting a breakpoint after the call to `is_valid_user()`
is not possible anymore because these names have been removed.

```
(gdb) disass main
No symbol table is loaded.  Use the "file" command.
```

Now it is much harder to analyze the assembly code to find the right locations for using breakpoints.

## References:
* [Linux strip command](https://www.computerhope.com/unix/strip.htm)

*Egon Teiniker, 2020-2021, GPL v3.0* 
