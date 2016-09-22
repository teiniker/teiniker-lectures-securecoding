#include <stdio.h>
#include <string.h>
#include <memory.h>
#include <stdlib.h>

#include "stack.h"

struct node *new_node(int value)
{
    struct node *node_ptr = malloc(sizeof(struct node));
    node_ptr->value = value;
    node_ptr->next_ptr = NULL;
    return node_ptr;
}

void stack_push(struct node **stack_ptr, int value)
{
    struct node *tmp_ptr = new_node(value);
    if(*stack_ptr != NULL)
    {
        tmp_ptr->next_ptr = *stack_ptr;
    }
    *stack_ptr = tmp_ptr;
}

int stack_pop(struct node **stack_ptr)
{
    if(*stack_ptr == NULL)
       return -1; // error

    struct node *tmp_ptr = *stack_ptr;    
    if(tmp_ptr->next_ptr != NULL)
        *stack_ptr = tmp_ptr->next_ptr;
        
    int value = tmp_ptr->value;
    free(tmp_ptr);

    return value;
}

int stack_size(struct node **stack_ptr)
{
    int i = 0;
    if(*stack_ptr == NULL)
        return i;

    i++;
    struct node *tmp_ptr = *stack_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        tmp_ptr = tmp_ptr->next_ptr;
        i++;
    }
    return i;
}

