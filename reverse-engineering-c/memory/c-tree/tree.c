#include <stdio.h>
#include <string.h>
#include <memory.h>
#include <stdlib.h>


struct node
{
    int value;
    struct node *left_ptr;
    struct node *right_ptr;
};


struct node *new_node(int value)
{
    struct node *node_ptr = malloc(sizeof(struct node));
    node_ptr->value = value;
    node_ptr->left_ptr = NULL;
    node_ptr->right_ptr = NULL;
    return node_ptr;
}

int main()
{
    // setup linked list
    struct node *tree_ptr;
    tree_ptr = new_node(13);
    tree_ptr->left_ptr = new_node(7);
    tree_ptr->right_ptr = new_node(17);
    tree_ptr->left_ptr->left_ptr = new_node(3);

    // navigate
    printf("%d\n", tree_ptr->left_ptr->left_ptr->value);
    printf("%d\n", tree_ptr->left_ptr->value);
    printf("%d\n", tree_ptr->value);
    printf("%d\n", tree_ptr->right_ptr->value);
    
    free(tree_ptr->left_ptr->left_ptr);
    free(tree_ptr->left_ptr);
    free(tree_ptr->right_ptr);
    free(tree_ptr);

    return 0;
}

