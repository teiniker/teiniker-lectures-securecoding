#include <stdio.h>
#include <unity.h>
#include "linked_list.h"

node_t *list_ptr = NULL;

void setUp(void)
{
    list_ptr = list_append(list_ptr, new_user(1,"homer","********"));
    list_ptr = list_append(list_ptr, new_user(2,"marge","********"));
    list_ptr = list_prepend(list_ptr, new_user(3,"lisa","********"));
}

void tearDown(void)
{
    list_remove_all(list_ptr);
    list_ptr = NULL;
}

void test_length(void)
 {
    // exercise
    int length = list_length(list_ptr);

    // verify
    TEST_ASSERT_EQUAL(3, length);
}

void test_element_0(void)
{
    // exercise
    user_t *user_ptr = list_get(list_ptr, 0);

	// verify
	TEST_ASSERT_EQUAL(3, user_ptr->id);
	TEST_ASSERT_EQUAL_STRING("lisa", user_ptr->username);
	TEST_ASSERT_EQUAL_STRING("********", user_ptr->password);
}

void test_element_1(void)
{
    // exercise
    user_t *user_ptr = list_get(list_ptr, 1);

	// verify
	TEST_ASSERT_EQUAL(1, user_ptr->id);
	TEST_ASSERT_EQUAL_STRING("homer", user_ptr->username);
	TEST_ASSERT_EQUAL_STRING("********", user_ptr->password);
}

void test_element_2(void)
{
    // exercise
    user_t *user_ptr = list_get(list_ptr, 2);

	// verify
	TEST_ASSERT_EQUAL(2, user_ptr->id);
	TEST_ASSERT_EQUAL_STRING("marge", user_ptr->username);
	TEST_ASSERT_EQUAL_STRING("********", user_ptr->password);
}

int main(void)
{
	UNITY_BEGIN();
	RUN_TEST(test_length);
    RUN_TEST(test_element_0);
    RUN_TEST(test_element_1);
    RUN_TEST(test_element_2);
	return UNITY_END();
}

