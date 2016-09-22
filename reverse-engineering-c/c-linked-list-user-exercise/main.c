#include <stdio.h>
#include "linked_list_user.h"

int main()
{
    // setup linked list
    node *list_ptr = NULL;
    list_ptr = list_append(list_ptr, new_user(1,"homer","********"));
    list_ptr = list_append(list_ptr, new_user(2,"marge","********"));
    list_ptr = list_append(list_ptr, new_user(3,"lisa","********"));
    list_ptr = list_prepend(list_ptr, new_user(4,"bart","********"));
    list_ptr = list_prepend(list_ptr, new_user(5,"maggi","********"));

    // navigate
    int length = list_length(list_ptr);
    printf("list.length = %d\n", length);
    for(int i=0; i<length;i++)
    {
        user *user_ptr = list_get(list_ptr, i);
        printf("list.get(%d) = %d\t%s\t%s\n",i,user_ptr->id,user_ptr->username,user_ptr->password);
    }

    list_remove_all(list_ptr);

    return 0;
}

