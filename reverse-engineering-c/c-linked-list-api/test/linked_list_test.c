#include <unity.h>
#include <stdio.h>
#include <linked_list.h>

void setUp(void)
{
	// Setup
}

void tearDown(void)
{
	// tear down code
}

void test_LinkedList(void)
 {
    // setup linked list
    struct node *list_ptr = NULL;
    list_ptr = list_append(list_ptr, 1);
    list_ptr = list_append(list_ptr, 2);
    list_ptr = list_append(list_ptr, 3);
    list_ptr = list_prepend(list_ptr, 4);
 
     // navigate
     int length = list_length(list_ptr);
     printf("list.length = %d\n", length);
     for(int i=0; i<length;i++)
     {
         printf("list.get(%d) = %d\n",i,list_get(list_ptr,i));
     }
 
     list_remove_all(list_ptr);
    list_ptr = NULL;  //!!!
    printf("list.length = %d\n", list_length(list_ptr));
 
}

int main(void)
{
	UNITY_BEGIN();
	RUN_TEST(test_LinkedList);

	return UNITY_END();
}
