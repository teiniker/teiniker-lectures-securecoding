#ifndef _LINKED_LIST_USER_H_
#define _LINKED_LIST_USER_H_

/*
 *  Linked List User API
 */


typedef struct user_
{
    int id;
    char *username;
    char *password;
} user;

typedef struct node_
{
    user *user_ptr;
    struct node_ *next_ptr;
} node;

extern user *new_user(int id, char *username, char *password);

extern node *list_append(node *list_ptr, user *user_ptr);
extern node *list_prepend(node *list_ptr, user *user_ptr);
extern int list_length(node *list_ptr);
extern user *list_get(node *list_ptr, int index);
extern void list_remove_all(node *list_ptr);


#endif /*_LINKED_LIST_USER_H_ */
