Example: Error Handling in C
-------------------------------------------------------------------------------

Error return values are there for a very good reason: to indicate a potential
failure condition so that your code can react accordingly.
Some errors are not serious errors, they are informal and often optional.


Examples: File IO standard library functions
-------------------------------------------------------------------------------
If we call a function like fopen(), and it fails (access denied, file locked, 
or no file), and we don't handle the error, subsequent calls to fwrite() or fread()
fail too. And if we read some data and dereference the data, the application will
probably crash.

Tipp: Use the man pages to find out details about return codes: $ man fopen

fopen()
Upon successful completion fopen() return a FILE pointer.  
Otherwise, NULL is returned and errno is set to indicate the error.

fclose()
Upon  successful  completion  0  is  returned.   
Otherwise,  EOF is returned and errno is set to indicate the error.  
In either case any further access (including another call to fclose()) 
to the stream results in undefined behavior.

fscanf()
These function returns the number of input items successfully matched 
and assigned, which can be fewer than provided for, or even zero in 
the event of an early matching failure.

The value EOF is returned if the end of input is reached before either 
the first successful conversion or a matching failure occurs.  
EOF is also returned if a read error occurs, in which case the error 
indicator for the stream (see ferror(3)) is set, and errno is set 
indicate the error.

Note thaf for many system library functions the integer expression
"errno" (declared in <errno.h> may contain an error number that gives
further information about the most recent error.


How to run the read_file example?
-------------------------------------------------------------------------------
$ make
gcc -std=c99 -g -Wall      read_file.c   -o read_file

$ ./read_file
Usage: read_file <filename>

$ ./read_file unknown
ERROR: Can't open file: unknown

$ ./read_file xxx
ERROR: Illegal argument filename: xxx

$ ./read_file application-users.config 
> homer
> marge
> bart
> lisa
> maggie


