#include <unity.h>
#include <stdio.h>
#include "linked_queue.h"

void queue_print(queue_t *queue_ptr);

queue_t *queue_ptr = NULL;

void setUp(void)
{
    queue_ptr = queue_init();
    queue_enqueue(queue_ptr, 1);
    queue_print(queue_ptr);
    queue_enqueue(queue_ptr, 2);
    queue_print(queue_ptr);
    queue_enqueue(queue_ptr, 3);
    queue_print(queue_ptr);
    queue_enqueue(queue_ptr, 4);
    queue_print(queue_ptr);
}

void tearDown(void)
{
    queue_dest(queue_ptr);
}

void test_elements(void)
{
    TEST_ASSERT_EQUAL(1, queue_dequeue(queue_ptr));
    TEST_ASSERT_EQUAL(2, queue_dequeue(queue_ptr));
    TEST_ASSERT_EQUAL(3, queue_dequeue(queue_ptr));
    TEST_ASSERT_EQUAL(4, queue_dequeue(queue_ptr));
}

void queue_print(queue_t *queue_ptr)
{
    node_t *node_ptr;

    if(queue_ptr == NULL)
        return;
    if(queue_ptr->tail_ptr == NULL)
    {
        printf("[ ]\n");
        return;
    }

    printf("Queue: tail->[");
    node_ptr = queue_ptr->tail_ptr;
    do
    {
        printf("%d ", node_ptr->value);
        node_ptr = node_ptr->prev_ptr;
    } while(node_ptr != NULL);
    printf("]<-head\n");
}


int main(void)
{
	UNITY_BEGIN();
	RUN_TEST(test_elements);
 	return UNITY_END();
}