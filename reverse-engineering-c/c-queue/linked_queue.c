#include <stdlib.h>
#include <stdio.h>

#include"linked_queue.h"

queue_node *new_node(int value)
{
    queue_node *node_ptr = (queue_node *)malloc(sizeof(queue_node));
    node_ptr->value = value;
    node_ptr->prev_ptr = NULL;
    return node_ptr;
}


queue *queue_init()
{
    queue *queue_ptr = (queue *)malloc(sizeof(queue));
    queue_ptr->head_ptr = NULL;
    queue_ptr->tail_ptr = NULL;
    return queue_ptr;
} 

void queue_enqueue(queue *queue_ptr, int value)
{
    if(queue_ptr == NULL)
        return;

    queue_node *new_ptr = new_node(value); 
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


int queue_dequeue(queue *queue_ptr)
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
        queue_node *tmp_ptr = queue_ptr->tail_ptr;
        queue_ptr->tail_ptr = tmp_ptr->prev_ptr;
        free(tmp_ptr);
    }
    return value;
}

void queue_dest(queue *queue_ptr)
{
    if(queue_ptr == NULL)
        return;

    while(queue_ptr->tail_ptr != NULL)
    {
        queue_node *tmp_ptr = queue_ptr->tail_ptr->prev_ptr;
        free(queue_ptr->tail_ptr);
        queue_ptr->tail_ptr = tmp_ptr;
    }

    free(queue_ptr);
    queue_ptr = NULL;
}
 
