#include <unity.h>
#include <stdio.h>
#include "stack.h"

node_t *stack_ptr = NULL;

void setUp(void)
{
    stack_push(&stack_ptr, 1);
    stack_push(&stack_ptr, 2);
    stack_push(&stack_ptr, 3);
    stack_push(&stack_ptr, 4);
}

void tearDown(void)
{
}


void test_size(void)
{
    // Exercise
    int size = stack_size(&stack_ptr);

    // Verify
    TEST_ASSERT_EQUAL(4, size);

    // Teardown
    stack_pop(&stack_ptr);
    stack_pop(&stack_ptr);
    stack_pop(&stack_ptr);
    stack_pop(&stack_ptr);
}

void test_elements(void)
{
    // Exercise & Verify
    TEST_ASSERT_EQUAL(4, stack_pop(&stack_ptr));
    TEST_ASSERT_EQUAL(3, stack_pop(&stack_ptr));
    TEST_ASSERT_EQUAL(2, stack_pop(&stack_ptr));
    TEST_ASSERT_EQUAL(1, stack_pop(&stack_ptr));
}

int main(void)
{
	UNITY_BEGIN();
	RUN_TEST(test_size);
	RUN_TEST(test_elements);
 	return UNITY_END();
}