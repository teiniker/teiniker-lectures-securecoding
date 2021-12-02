## Anti Debug

Debuggers like gdb and strace utilize the ptrace() function to attach to a 
process at runtime. But there is **only one process** allowed to do this at a 
time and therefore having a call to ptrace() in your code can be used to detect 
debuggers.

The **ptrace()** system call provides a means by which one process (the "tracer") 
may observe and control the execution of another process (the "tracee"), and 
examine and change the tracee's memory and registers.  
It is primarily used to implement breakpoint debugging and system call tracing.
```C
#include <sys/ptrace.h>

long ptrace(enum __ptrace_request request, pid_t pid, void *addr, void *data);
```

A tracee first needs to be attached to the tracer.  Attachment and subsequent 
commands are per thread: in a multi-threaded process, every thread can be 
individually attached to a  (potentially  different)  tracer,  or  left  not
attached  and  thus  not  debugged.   
Therefore,  "tracee"  always means "(one) thread", never "a (possibly multi‐
threaded) process".  

```C
#include <stdio.h>
#include <sys/ptrace.h>

int main()
{
    if (ptrace(PTRACE_TRACEME, 0, 1, 0) == -1) 
    {
        printf("don't trace me !!\n");
        return 1;
    }
    
    printf("normal execution\n");
    return 0;
}
```

**PTRACE_TRACEME** indicate  that  this process is to be traced by its parent.  
A process probably shouldn't make this request if its parent isn't expecting to 
trace it.  (pid, addr, and data are ignored.)

### Example: Using gdb
```
$ gdb ./secret
(gdb) run xxxx
Starting program: /home/student/github/teiniker-lectures-securecoding/reverse-engineering-c/c-secret-anti-debug/secret xxxx
don't trace me !!
[Inferior 1 (process 2645) exited with code 01]
(gdb) 
```

### Example: Using strace or ltrace
```
$ ltrace ./secret 
ptrace(0, 0, 1, 0)                                   = -1
puts("don't trace me !!"don't trace me !!
)                                                    = 18
+++ exited (status 1) +++
```


## References
* [Linux Anti Debugging](https://seblau.github.io/posts/linux-anti-debugging)

* [Linux Programmer's Manual](http://man7.org/linux/man-pages/man2/ptrace.2.html)

*Egon Teiniker, 2019, GPL v3.0*