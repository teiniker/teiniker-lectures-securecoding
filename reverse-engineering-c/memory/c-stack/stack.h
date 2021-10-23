#ifndef _STACK_H_
#define _STACK_H_


typedef struct node
{   
    int value;
    struct node *next_ptr;
}node_t;


extern void stack_push(node_t **stack_ptr, int value);
extern int stack_pop(node_t **stack_ptr);
extern int stack_size(node_t **stack_ptr);

#endif /* _STACK_H_ */ 
