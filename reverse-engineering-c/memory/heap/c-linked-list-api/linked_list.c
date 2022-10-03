#include <stdlib.h>

#include "linked_list.h"

node_t *new_node(int value)
{
    node_t *node_ptr = malloc(sizeof(node_t));
    node_ptr->value = value;
    node_ptr->next_ptr = NULL;
    return node_ptr;
}


node_t *list_append(node_t *list_ptr, int value)
{
    node_t *new_ptr = new_node(value); 
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


node_t *list_prepend(node_t *list_ptr, int value)
{
    node_t *new_ptr = new_node(value); 
    if(list_ptr == NULL)
        return new_ptr;
   
    new_ptr->next_ptr = list_ptr;

    return new_ptr;
}


int list_get(node_t *list_ptr, int index)
{
    node_t* tmp_ptr = list_ptr;
    for(int i=0; i<index; i++)
    {
        if(tmp_ptr != NULL)
            tmp_ptr = tmp_ptr->next_ptr; 
    }
    return tmp_ptr->value;
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


void list_remove_all(node_t *list_ptr)
{
    if(list_ptr == NULL)
        return;

    node_t* tmp_ptr = list_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        node_t *rm_ptr = tmp_ptr;
        tmp_ptr = tmp_ptr->next_ptr;
        free(rm_ptr);                
    }
    free(tmp_ptr);
}
