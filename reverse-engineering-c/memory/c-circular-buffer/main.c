#include <stdio.h>
#include "circular_buffer.h"


int main(void)
{
    // setup queue
    buffer *buffer_ptr =  buffer_init(5);

    buffer_write(buffer_ptr, 1);
    buffer_dump(buffer_ptr);
    buffer_write(buffer_ptr, 2);

/*

    buffer_write(buffer_ptr, 2);
    buffer_write(buffer_ptr, 3);
    buffer_write(buffer_ptr, 4);
*/
    // read elements from the queue
    buffer_dump(buffer_ptr);

    // remove queue
    buffer_dest(buffer_ptr);

    return 0;
}

