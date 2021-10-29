#ifndef _LINKED_LIST_USER_H_
#define _LINKED_LIST_USER_H_

/*
 *  Linked List User API
 */

typedef struct user
{
    int id;
    char *username;
    char *password;
} user_t;

typedef struct node
{
    user_t *user_ptr;
    struct node *next_ptr;
} node_t;

extern user_t *new_user(int id, char *username, char *password);

extern node_t *list_append(node_t *list_ptr, user_t *user_ptr);
extern node_t *list_prepend(node_t *list_ptr, user_t *user_ptr);
extern int list_length(node_t *list_ptr);
extern user_t *list_get(node_t *list_ptr, int index);
extern void list_remove_all(node_t *list_ptr);

#endif /*_LINKED_LIST_USER_H_ */
