#include <stdlib.h>

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
    queue *queue_ptr = malloc(sizeof(queue));
    queue_ptr->head_ptr = NULL;
    queue_ptr->tail_ptr = NULL;
    return queue_ptr;
} 

void queue_enqueue(queue *queue_ptr, int value)
{
    if(queue_ptr == NULL)
        return;

    queue_node *new_ptr = new_node(value); 
    if(queue_ptr->tail_ptr == NULL)
    {
         queue_ptr->tail_ptr = queue_ptr->head_ptr = new_ptr;
    }
    else
    {
        // queue_ptr->tail_ptr = the same
        queue_node *tmp_ptr = queue_ptr->tail_ptr;
        while(tmp_ptr->prev_ptr != NULL)
        {
            tmp_ptr = tmp_ptr->prev_ptr;
        }
        tmp_ptr->prev_ptr = new_ptr;
        queue_ptr->head_ptr = new_ptr;
    }
} 


int queue_dequeue(queue *queue_ptr)
{
    int value;
    if(queue_ptr == NULL || queue_ptr->tail_ptr == NULL)
    {
        value = 0;
    }
    else
    {
        //  queue->head_ptr = the same
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

    free(queue_ptr);
    queue_ptr = NULL;
}
 
