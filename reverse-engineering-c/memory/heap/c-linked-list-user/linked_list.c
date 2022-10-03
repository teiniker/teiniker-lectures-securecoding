#include <stdio.h>
#include <string.h>
#include <memory.h>
#include <stdlib.h>

#include "linked_list.h"

node_t *new_node(user_t *user_ptr)
{
    node_t *node_ptr = malloc(sizeof(node_t));
    node_ptr->user_ptr = user_ptr;
    node_ptr->next_ptr = NULL;
    return node_ptr;
}

user_t *new_user(int id, char *username, char *password)
{
    user_t *user_ptr = malloc(sizeof(user_t));
    user_ptr->id = id;
    user_ptr->username = username;
    user_ptr->password = password;
    return user_ptr;
}


node_t *list_append(node_t *list_ptr, user_t *user_ptr)
{
    node_t *new_ptr = new_node(user_ptr);
    if(list_ptr == NULL)
        return new_ptr;

    node_t *tmp_ptr = list_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        tmp_ptr = tmp_ptr->next_ptr;        
    }
    tmp_ptr->next_ptr = new_ptr;
    return list_ptr;
} 


node_t *list_prepend(node_t *list_ptr, user_t *user_ptr)
{
    node_t *new_ptr = new_node(user_ptr);
    if(list_ptr == NULL)
        return new_ptr;

    new_ptr->next_ptr = list_ptr;
    return new_ptr;
}


int list_length(node_t *list_ptr)
{ 
    if(list_ptr == NULL)
        return 0;

    int length = 1;
    node_t *tmp_ptr = list_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        length++;        
        tmp_ptr = tmp_ptr->next_ptr;        
    }
    return length;
}


user_t *list_get(node_t *list_ptr, int index)
{
    node_t *tmp_ptr = list_ptr;
    for(int i=0; i<index; i++)
    {
        if(tmp_ptr != NULL)
            tmp_ptr = tmp_ptr->next_ptr; 
    }
    return tmp_ptr->user_ptr;
} 


void list_remove_all(node_t *list_ptr)
{
    if(list_ptr == NULL)
        return;

    node_t *tmp_ptr = list_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        node_t *rm_ptr = tmp_ptr;
        tmp_ptr = tmp_ptr->next_ptr;
        free(rm_ptr->user_ptr);
        free(rm_ptr);                
    }
    free(tmp_ptr->user_ptr);
    free(tmp_ptr);
}
