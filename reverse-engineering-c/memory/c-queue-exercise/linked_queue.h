#ifndef _LINKED_QUEUE_H_
#define _LINKED_QUEUE_H_

/*
 * Linked Queue API
 */

typedef struct node
{
    int value;
    struct node *prev_ptr;
}node_t;

typedef struct queue
{
    node_t *head_ptr;
    node_t *tail_ptr;
} queue_t;

extern queue_t *queue_init();
extern void queue_enqueue(queue_t *queue_ptr, int value);
extern int queue_dequeue(queue_t *queue_ptr);
extern void queue_dest(queue_t *queue_ptr);

#endif /*_LINKED_QUEUE_H_ */
