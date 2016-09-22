Exercise: Linked List User
---------------------------------------------------------------------

1. List of Users 
---------------------------------------------------------------------
Extend the given "linked_list_user.c" file to implement a list that can
handle "struct user" elements.

After compiling and starting the application you should see the
following output:

$ ./linked_list_user 
list.length = 5
list.get(0) = 5 maggi   ********
list.get(1) = 4 bart    ********
list.get(2) = 1 homer   ********
list.get(3) = 2 marge   ********
list.get(4) = 3 lisa    ********


2. Memory Management
--------------------------------------------------------------------
In the "linked_list_user.c" file, implement the following function:

    void list_remove_all(struct node *list_ptr);


You can use Valgrind to check your memory management:

$ valgrind ./linked_list_user
==5269== HEAP SUMMARY:
==5269==     in use at exit: 0 bytes in 0 blocks
==5269==   total heap usage: 10 allocs, 10 frees, 100 bytes allocated
==5269== 
==5269== All heap blocks were freed -- no leaks are possible


