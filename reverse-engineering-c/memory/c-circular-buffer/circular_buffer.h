#ifndef _CIRCULAR_BUFFER_H_
#define _CIRCULAR_BUFFER_H_

/*
 * Circular Buffer API
 */

typedef struct node_
{
    int value;
    struct node_ *next_ptr;
}node;

typedef struct buffer_
{
    int size;
    node *start_ptr;
    node *end_ptr;
} buffer;

extern buffer* buffer_init(int size);
extern void buffer_write(buffer *buffer_ptr, int value);
extern int buffer_read(buffer *buffer_ptr);
extern void buffer_dump(buffer *buffer_ptr);
extern void buffer_dest(buffer *buffer_ptr);

#endif /*_CIRCULAR_BUFFER_H_ */
