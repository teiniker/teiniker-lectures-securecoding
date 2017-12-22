#ifndef _LINKED_QUEUE_H_
#define _LINKED_QUEUE_H_

/*
 * Linked Queue API
 */

typedef struct node
{
    int value;
    struct node *prev_ptr;
}queue_node;

typedef struct queue_
{
    queue_node *head_ptr;
    queue_node *tail_ptr;
} queue;

extern queue* queue_init();
extern void queue_enqueue(queue *queue_ptr, int value);
extern int queue_dequeue(queue *queue_ptr);
extern void queue_dest(queue *queue_ptr);

#endif /*_LINKED_QUEUE_H_ */
