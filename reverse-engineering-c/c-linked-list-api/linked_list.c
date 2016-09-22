#include <string.h>
#include <memory.h>
#include <stdlib.h>

#include"linked_list.h"


struct node *new_node(int value)
{
    struct node *node_ptr = malloc(sizeof(struct node));
    node_ptr->value = value;
    node_ptr->next_ptr = NULL;
    return node_ptr;
}

struct node *list_append(struct node *list_ptr, int value)
{
    struct node *new_ptr = new_node(value); 
    if(list_ptr == NULL)
        return new_ptr;
   
    struct node *tmp_ptr = list_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        tmp_ptr = tmp_ptr->next_ptr;
    }
    tmp_ptr->next_ptr = new_ptr;

    return list_ptr;
} 


struct node *list_prepend(struct node *list_ptr, int value)
{
    struct node *new_ptr = new_node(value); 
    if(list_ptr == NULL)
        return new_ptr;
   
    new_ptr->next_ptr = list_ptr;

    return new_ptr;
}


int list_get(struct node *list_ptr, int index)
{
    struct node* tmp_ptr = list_ptr;
    for(int i=0; i<index; i++)
    {
        if(tmp_ptr != NULL)
            tmp_ptr = tmp_ptr->next_ptr; 
    }
    return tmp_ptr->value;
} 



int list_length(struct node *list_ptr)
{ 
    if(list_ptr == NULL)
        return 0;
    
    int length = 1;
    struct node *tmp_ptr = list_ptr;
    while(tmp_ptr->next_ptr != NULL)    
    {   
        length++;
        tmp_ptr = tmp_ptr->next_ptr;
    }
  
    return length;
}


void list_remove_all(struct node *list_ptr)
{
    if(list_ptr == NULL)
        return;

    struct node* tmp_ptr = list_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        struct node *rm_ptr = tmp_ptr;
        tmp_ptr = tmp_ptr->next_ptr;
        free(rm_ptr);                
    }
    free(tmp_ptr);
}
 
