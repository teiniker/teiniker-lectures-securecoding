#include <stdlib.h>
#include <stdio.h>
#include"linked_queue.h"

node_t *new_node(int value)
{
    node_t *node_ptr = (node_t *)malloc(sizeof(node_t));
    node_ptr->value = value;
    node_ptr->prev_ptr = NULL;
    return node_ptr;
}


queue_t *queue_init()
{
    queue_t *queue_ptr = (queue_t *)malloc(sizeof(queue_t));
    queue_ptr->head_ptr = NULL;
    queue_ptr->tail_ptr = NULL;
    return queue_ptr;
} 

void queue_enqueue(queue_t *queue_ptr, int value)
{
    if(queue_ptr == NULL)
        return;

    node_t *new_ptr = new_node(value); 
    if(queue_ptr->tail_ptr == NULL && queue_ptr->head_ptr == NULL)
    {   // empty queue
         queue_ptr->tail_ptr = queue_ptr->head_ptr = new_ptr;
    }
    else
    {
        // insert on the head's side
        queue_ptr->head_ptr->prev_ptr = new_ptr;
        queue_ptr->head_ptr = new_ptr;
    }
} 


int queue_dequeue(queue_t *queue_ptr)
{
    int value;
    if(queue_ptr == NULL || queue_ptr->tail_ptr == NULL)
    {
        printf("Can't dequeue an empty queue!");
        exit(-1);
    }
    else
    {
        value = queue_ptr->tail_ptr->value;
        node_t *tmp_ptr = queue_ptr->tail_ptr;
        queue_ptr->tail_ptr = tmp_ptr->prev_ptr;
        free(tmp_ptr);
    }
    return value;
}

void queue_dest(queue_t *queue_ptr)
{
    if(queue_ptr == NULL)
        return;

    while(queue_ptr->tail_ptr != NULL)
    {
        node_t *tmp_ptr = queue_ptr->tail_ptr->prev_ptr;
        free(queue_ptr->tail_ptr);
        queue_ptr->tail_ptr = tmp_ptr;
    }

    free(queue_ptr);
    queue_ptr = NULL;
}
 
