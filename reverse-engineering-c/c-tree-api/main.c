#include <stdio.h>
#include <string.h>

#include<stdlib.h>

#include "tree.h"

int main()
{
    // setup linked list
    tree *tree_ptr = NULL;
    tree_insert(&tree_ptr, 13);
    tree_insert(&tree_ptr, 7);
    tree_insert(&tree_ptr, 17);
    tree_insert(&tree_ptr, 3);

    // navigate
    tree_print(&tree_ptr);  
 
    // remove whole tree
    tree_remove(&tree_ptr); 
    return 0;
}

