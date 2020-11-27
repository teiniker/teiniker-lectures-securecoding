#ifndef _LINKED_LIST_H_
#define _LINKED_LIST_H_

/*
 * Linked List API
 */

struct node
{
    int value;
    struct node *next_ptr;
};

extern struct node *list_append(struct node *list_ptr, int value);
extern struct node *list_prepend(struct node *list_ptr, int value);
extern int list_get(struct node *list_ptr, int index);
extern int list_length(struct node *list_ptr);
extern void list_remove_all(struct node *list_ptr);


#endif /*_LINKED_LIST_H_ */
