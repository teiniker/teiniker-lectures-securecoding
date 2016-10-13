#ifndef _BINARY_TREE_H_
#define _BINARY_TREE_H_

/*
 *  Binary Tree API
 */

typedef struct node
{
    int value;
    struct node *left_ptr;
    struct node *right_ptr;
}tree;

extern void tree_insert(tree **tree_ptr, int value);
extern int tree_print(tree **tree_ptr);
extern void tree_remove(tree **tree_ptr);


#endif /* _BINARY_TREE_H_ */

