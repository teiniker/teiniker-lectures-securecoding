#include <stdio.h>
#include <glib.h>
#include <string.h>


void test_strcpy(void)
{
	char *s1 = "Homer Simpson";
	char s2[16];
	
	strcpy(s2, s1);

	g_assert_cmpstr("Homer Simpson" , == , s2);
}

void test_strcpy_overflow(void)
{
 	int i = 0;
	char s2[16];
	char *s1 = "0123456789012345\x20\x20\x20\x20\xdd\xcc\xbb\xaa";

    strcpy(s2, s1);

	printf("%4x \"%s\"\n",i, s2);
}


/*
 * $ gtester -k --verbose -o report.xml agile
 */

int main(int argc, char** argv)
{
   	g_test_init(&argc, &argv, NULL);
   	g_test_add_func("/string/strcpy", test_strcpy);
	g_test_add_func("/string/strcpy_overflow", test_strcpy_overflow);	
	
   	return g_test_run();
}

