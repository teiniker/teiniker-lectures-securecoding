#include <stdlib.h>

#include "search_tree.h"

node_t *node_new(int value)
{
    node_t *node = malloc(sizeof(node_t));
    node->value = value;
    node->left_ptr = NULL;
    node->right_ptr = NULL;
    return node;
}

// TODO: Implement missing functions

void tree_print(node_t *node_ptr)
{
    if(node_ptr == NULL)
        return;

    tree_print(node_ptr->left_ptr);
    printf("%d ", node_ptr->value);
    tree_print(node_ptr->right_ptr);
}
