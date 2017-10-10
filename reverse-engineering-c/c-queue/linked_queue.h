#ifndef _LINKED_QUEUE_H_
#define _LINKED_QUEUE_H_

/*
 * Linked Queue API
 */

typedef struct node
{
    int value;
    struct node *next_ptr;
}queue_node;

typedef struct queue_
{
    queue_node *front;
    queue_node *rear;
} queue;

extern queue* queue_init();
extern void queue_enqueue(queue *queue_ptr, int value);
extern int queu_dequeue(queue *queue_ptr);


#endif /*_LINKED_QUEUE_H_ */
