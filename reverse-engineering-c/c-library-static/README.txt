How to create a static library?
-------------------------------------------------------------------------------
First, we compile the c files into object files (*.o files). These object files
are then packaged into a static library file (lib*.a file):
    
    $ gcc -std=c99 -g -Wall -c linked_list_user.c
    
    $ ar -cvq liblist.a *.o
    
Using the -t flag, we can review the content of a given static library:

    $ ar -t liblist.a

Usually, we put many *.o files into a library to be useful.
        
Second, we install the library to a location in the file system:

    $ mkdir lib
    $ mv liblist.a lib/

    $ mkdir include
    $ cp linked_list_user.h include/



How to use a static library?
-------------------------------------------------------------------------------

    $ gcc -std=c99 -o main main.c -I./include -L./lib -llist
    $ ./main


