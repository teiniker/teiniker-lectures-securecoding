#include <stdio.h>
#include <string.h>
#include <memory.h>
#include <stdlib.h>

#include "linked_list_user.h"


node *new_node(user *user_ptr)
{
    node *node_ptr = malloc(sizeof(node));
    node_ptr->user_ptr = user_ptr;
    node_ptr->next_ptr = NULL;
    return node_ptr;
}

user *new_user(int id, char *username, char *password)
{
    user *user_ptr = malloc(sizeof(user));
    user_ptr->id = id;
    user_ptr->username = username;
    user_ptr->password = password;
    return user_ptr;
}


node *list_append(node *list_ptr, user *user_ptr)
{
    node *new_ptr = new_node(user_ptr);
    if(list_ptr == NULL)
        return new_ptr;

    node *tmp_ptr = list_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        tmp_ptr = tmp_ptr->next_ptr;        
    }
    tmp_ptr->next_ptr = new_ptr;
    return list_ptr;
} 


node *list_prepend(node *list_ptr, user *user_ptr)
{
    node *new_ptr = new_node(user_ptr);
    if(list_ptr == NULL)
        return new_ptr;

    new_ptr->next_ptr = list_ptr;
    return new_ptr;
}


int list_length(node *list_ptr)
{ 
    if(list_ptr == NULL)
        return 0;

    int length = 1;
    node *tmp_ptr = list_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        length++;        
        tmp_ptr = tmp_ptr->next_ptr;        
    }
    return length;
}


user *list_get(node *list_ptr, int index)
{
    node *tmp_ptr = list_ptr;
    for(int i=0; i<index; i++)
    {
        if(tmp_ptr != NULL)
            tmp_ptr = tmp_ptr->next_ptr; 
    }
    return tmp_ptr->user_ptr;
} 



void list_remove_all(node *list_ptr)
{
    if(list_ptr == NULL)
        return;

    node *tmp_ptr = list_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        node *rm_ptr = tmp_ptr;
        tmp_ptr = tmp_ptr->next_ptr;
        free(rm_ptr->user_ptr);
        free(rm_ptr);                
    }
    free(tmp_ptr->user_ptr);
    free(tmp_ptr);
} 

