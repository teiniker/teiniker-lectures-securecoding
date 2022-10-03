#include <stdlib.h>
#include <stdio.h>

#include"circular_buffer.h"

node *new_node(int value)
{
    node *node_ptr = (node *)malloc(sizeof(node));
    node_ptr->value = value;
    node_ptr->next_ptr = NULL;
    return node_ptr;
}


buffer *buffer_init(int size)
{
    if(size < 1)
    {
        printf("Minimal size is 1!");
        return NULL;
    }

    buffer *buffer_ptr = (buffer *)malloc(sizeof(buffer));
    buffer_ptr->size = size;
    node *tmp_ptr = new_node(0);
    buffer_ptr->start_ptr = tmp_ptr;
    for(int i=1; i<size; i++)
    {
        tmp_ptr->next_ptr = new_node(0);
        tmp_ptr = tmp_ptr->next_ptr;
    }
    tmp_ptr->next_ptr = buffer_ptr->start_ptr;
    buffer_ptr->end_ptr = tmp_ptr;
    return buffer_ptr;
} 

void buffer_dump(buffer *buffer_ptr)
{
    printf("Buffer %p of site %d:\n", buffer_ptr, buffer_ptr->size);
    node *iterator_ptr = buffer_ptr->start_ptr;
    printf("[ ");
    for(int i=0; i<buffer_ptr->size; i++)
    {
        printf("%d ", iterator_ptr->value);
        iterator_ptr = iterator_ptr->next_ptr;
    }
    printf("]\n");
}

void buffer_write(buffer *buffer_ptr, int value)
{
    if(buffer_ptr == NULL)
    {
        printf("Error: Buffer is not initialized!");
        return;
    }


    if(buffer_ptr->start_ptr->next_ptr != buffer_ptr->end_ptr)
    {
        buffer_ptr->start_ptr->value = value;
        buffer_ptr->start_ptr = buffer_ptr->start_ptr->next_ptr;
    }
    else
    {
        printf("Error: Buffer is full!");
    }
} 


int buffer_read(buffer *buffer_ptr)
{
    int value;


    return value;
}

void buffer_dest(buffer *buffer_ptr)
{
    if(buffer_ptr == NULL)
        return;

    node *iterator_ptr = buffer_ptr->start_ptr;
    while(iterator_ptr != buffer_ptr->end_ptr)
    {
        node *tmp_ptr = iterator_ptr;
        iterator_ptr = tmp_ptr->next_ptr;
        free(tmp_ptr);
    }
    free(buffer_ptr->end_ptr);
    free(buffer_ptr);
    buffer_ptr = NULL;
}
 
