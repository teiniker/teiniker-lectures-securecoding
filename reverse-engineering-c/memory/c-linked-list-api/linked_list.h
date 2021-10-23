#ifndef _LINKED_LIST_H_
#define _LINKED_LIST_H_

/*
 * Linked List API
 */

typedef struct node
{
    int value;
    struct node *next_ptr;
} node_t;

extern struct node *list_append(node_t *list_ptr, int value);
extern struct node *list_prepend(node_t *list_ptr, int value);
extern int list_get(node_t *list_ptr, int index);
extern int list_length(node_t *list_ptr);
extern void list_remove_all(node_t *list_ptr);


#endif /*_LINKED_LIST_H_ */
