#include <stdlib.h>
#include<linked_queue.h>

// TODO

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
