#include <stdio.h>
#include <stdlib.h>

#include "stack.h"

node_t *new_node(int value)
{
    node_t *node_ptr = malloc(sizeof(node_t));
    node_ptr->value = value;
    node_ptr->next_ptr = NULL;
    return node_ptr;
}

void stack_push(node_t **stack_ptr, int value)
{
    node_t *tmp_ptr = new_node(value);
    if(*stack_ptr != NULL)
    {
        tmp_ptr->next_ptr = *stack_ptr;
    }
    *stack_ptr = tmp_ptr;
}

int stack_pop(node_t **stack_ptr)
{
    if(*stack_ptr == NULL)
       return -1; // error

    node_t *tmp_ptr = *stack_ptr;
    if(tmp_ptr->next_ptr != NULL)
        *stack_ptr = tmp_ptr->next_ptr;
        
    int value = tmp_ptr->value;
    free(tmp_ptr);

    return value;
}

int stack_size(node_t **stack_ptr)
{
    int i = 0;
    if(*stack_ptr == NULL)
        return i;

    i++;
    node_t *tmp_ptr = *stack_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        tmp_ptr = tmp_ptr->next_ptr;
        i++;
    }
    return i;
}

