#include <stdlib.h>

#include"linked_queue.h"

struct queue_node *new_node(int value)
{
    queue_node *node_ptr = malloc(sizeof(queue_node));
    node_ptr->value = value;
    node_ptr->next_ptr = NULL;
    return node_ptr;
}


queue *queue_init()
{
    queue *queue_ptr = malloc(sizeof(queue));
    queue_ptr->front = NULL;
    queue_ptr->rear = NULL;
    return queue;
} 

void queue_enqueue(queue *queue_ptr, int value)
{
    queue_node *new_ptr = new_node(value); 
    if(queue_ptr->front == NULL && queue_ptr->rear == NULL)
    {
         queue_ptr->front = queue_ptr->rear = new_ptr;
    }
    else
    {
        new_ptr->next_ptr = queue_ptr->front;
    }
} 


int queue_dequeue(queue **queue_ptr)
{
    int value = 0;
    

    return value;
}
 
