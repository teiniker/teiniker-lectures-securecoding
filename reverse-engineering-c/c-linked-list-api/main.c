#include <stdio.h>
#include "linked_list.h"

int main()
{
    // setup linked list
    struct node *list_ptr = NULL;
    list_ptr = list_append(list_ptr, 1);
    list_ptr = list_append(list_ptr, 2);
    list_ptr = list_append(list_ptr, 3);
    list_ptr = list_prepend(list_ptr, 4);
 
     // navigate
     int length = list_length(list_ptr);
     printf("list.length = %d\n", length);
     for(int i=0; i<length;i++)
     {
         printf("list.get(%d) = %d\n",i,list_get(list_ptr,i));
     }
 
     list_remove_all(list_ptr);
 
     return 0;
}

