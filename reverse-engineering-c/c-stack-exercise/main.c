#include <stdio.h>

#include "stack.h"

int main()
{
    // setup stack
    struct node *stack_ptr = NULL;
    stack_push(&stack_ptr, 1);
    stack_push(&stack_ptr, 2);
    stack_push(&stack_ptr, 3);
    stack_push(&stack_ptr, 4);

    // navigate
    int size = stack_size(&stack_ptr);
    printf("stack size = %d\n", size);
    for(int i=0; i<size; i++)
    {
        printf("%d\n", stack_pop(&stack_ptr));
    }

    return 0;
}

