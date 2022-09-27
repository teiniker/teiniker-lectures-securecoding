#include <stdio.h>
#include <unity.h>
#include "hello.h"

void setUp(void)
{
	printf("Setup\n");
}

void tearDown(void)
{
	printf("Teardown\n");
}

void test_hello(void)
{
	// Setup 
	char *name = "KBerg";
	// Exercise 
	int size = say_hello(name);
	// verfy 
	TEST_ASSERT_EQUAL(13, size); 
}

void test_hello_name_is_null(void)
{
	// Setup 
	char *name = NULL;
	// Exercise 
	int size = say_hello(name);
	// verfy 
	TEST_ASSERT_EQUAL(0, size); 
}

int main(void)
{
	UNITY_BEGIN();
	RUN_TEST(test_hello);
	RUN_TEST(test_hello_name_is_null);
	return UNITY_END();
}
