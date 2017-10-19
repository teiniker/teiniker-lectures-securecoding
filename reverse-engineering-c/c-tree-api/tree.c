#include <stdio.h>
#include <stdlib.h>

#include "tree.h"


tree *new_node(int value)
{
    tree *node_ptr = malloc(sizeof(tree));
    node_ptr->value = value;
    node_ptr->left_ptr = NULL;
    node_ptr->right_ptr = NULL;
    return node_ptr;
}

void tree_insert(tree **tree_ptr, int value)
{
    if(*tree_ptr == NULL)
    {
        tree *tmp_ptr = new_node(value);
        *tree_ptr = tmp_ptr;
    }
    else
    {
        if(value > (*tree_ptr)->value)
        {
            tree_insert(&(*tree_ptr)->right_ptr, value);
        }
        else
        {
            tree_insert(&(*tree_ptr)->left_ptr, value);
        }
    }
}

void tree_print(tree **tree_ptr)
{
    if(*tree_ptr != NULL)
    {
        tree_print(&(*tree_ptr)->left_ptr);
        printf("%d ", (*tree_ptr)->value);
        tree_print(&(*tree_ptr)->right_ptr);
    }
}


void tree_remove(tree **tree_ptr)
{
    if(*tree_ptr != NULL)
    {
        tree_remove(&(*tree_ptr)->left_ptr);
        tree_remove(&(*tree_ptr)->right_ptr);
        free((*tree_ptr));
    }
}


