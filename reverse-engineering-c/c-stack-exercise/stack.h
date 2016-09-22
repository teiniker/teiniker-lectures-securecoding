#ifndef _STACK_H_
#define _STACK_H_


struct node
{   
    int value;
    struct node *next_ptr;
};


extern void stack_push(struct node **stack_ptr, int value);
extern int stack_pop(struct node **stack_ptr);
extern int stack_size(struct node **stack_ptr);

#endif /* _STACK_H_ */ 
