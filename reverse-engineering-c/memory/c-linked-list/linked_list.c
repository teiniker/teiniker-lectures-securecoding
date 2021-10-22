#include <stdio.h>
#include <string.h>
#include <memory.h>
#include <stdlib.h>


struct node
{
    int value;
    struct node *next_ptr;
};

struct node *new_node(int value)
{
    struct node *node_ptr = malloc(sizeof(struct node));
    node_ptr->value = value;
    node_ptr->next_ptr = NULL;
    return node_ptr;
}

int main()
{
    // setup linked list
    struct node *list_ptr;
    list_ptr = new_node(1);
    list_ptr->next_ptr = new_node(2);
    list_ptr->next_ptr->next_ptr = new_node(3);

    // navigate
    printf("1st node = %d\n", list_ptr->value);
    printf("2nd node = %d\n", list_ptr->next_ptr->value);
    printf("3th node = %d\n", list_ptr->next_ptr->next_ptr->value);
    
    free(list_ptr->next_ptr->next_ptr);
    free(list_ptr->next_ptr);
    free(list_ptr);

    return 0;
}

