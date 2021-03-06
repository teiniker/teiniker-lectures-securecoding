#ifndef _STACK_H_
#define _STACK_H_


typedef struct node_
{   
    int value;
    struct node_ *next_ptr;
}node;


extern void stack_push(node **stack_ptr, int value);
extern int stack_pop(node **stack_ptr);
extern int stack_size(node **stack_ptr);

#endif /* _STACK_H_ */ 
