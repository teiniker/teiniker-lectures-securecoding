#include <stdio.h>
#include "linked_queue.h"


void queue_print(queue *queue_ptr);

int main(void)
{
    // setup queue
    queue *queue_ptr =  queue_init();

    // write elements into the queue
    queue_enqueue(queue_ptr, 1);
    queue_print(queue_ptr);
    queue_enqueue(queue_ptr, 2);
    queue_print(queue_ptr);
    queue_enqueue(queue_ptr, 3);
    queue_print(queue_ptr);
    queue_enqueue(queue_ptr, 4);
    queue_print(queue_ptr);

    // read elements from the queue

    printf("%d\n", queue_dequeue(queue_ptr));
    queue_print(queue_ptr);
    printf("%d\n", queue_dequeue(queue_ptr));
    queue_print(queue_ptr);
    printf("%d\n", queue_dequeue(queue_ptr));
    queue_print(queue_ptr);
    printf("%d\n", queue_dequeue(queue_ptr));
    queue_print(queue_ptr);

    // remove queue
    queue_dest(queue_ptr);

    return 0;
}


void queue_print(queue *queue_ptr)
{
    queue_node *node_ptr;

    if(queue_ptr == NULL)
        return;
    if(queue_ptr->tail_ptr == NULL)
    {
        printf("[ ]\n");
        return;
    }

    printf("Queue: <-tail[");
    node_ptr = queue_ptr->tail_ptr;
    do
    {
        printf("%d ", node_ptr->value);
        node_ptr = node_ptr->prev_ptr;
    } while(node_ptr != NULL);
    printf("]head<-\n");
}
