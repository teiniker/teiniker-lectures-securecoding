#include <stdio.h>
#include <string.h>
#include <memory.h>

/*
 * Pointers are called address variables because they contain the 
 * addresses of other variables.
 * A pointer is declared by putting an asterisk '*' in front of
 * the variable name.
 * The operator ampersand '&' returns the address of a variable.
 * The operator asterisk '*' resturns the value of a variable to 
 * which a pointer points.
 */

void print_integer(int i)
{
    int *i_ptr = &i;
    
    printf("i = %d and is stored at %p\n", *i_ptr, i_ptr);
}


/*
 * Usually, C passes parameters using "call by value".
 * Pointers can be used to get around this restriction.
 */
void inc_integer(int *value)
{
    (*value)++;
}


/*
 * C allows pointer arithmetic (addition and subtraction)
 * Note that *(array_ptr+1) is the same as array[1]
 */
void print_string(char *s)
{
	char *ptr_a;
	char *ptr_b;

    ptr_a = s; 
	printf("%s\n", ptr_a);

	ptr_b = ptr_a + 6;
	printf("%s\n", ptr_b);

	strcpy(ptr_b, "Kberg!\n");
	printf("%s\n", ptr_a);
}


/*
 * Pointers can also be used for functions (function pointers)
 */
int function_one()
{
    printf("This is function_one()\n");
    return 1;
}

int function_two()
{
    printf("This is function_two()\n");
    return 2;
}


int main()
{
	int i = 7;
    print_integer(i);
    inc_integer(&i);
    printf("inc_integer(i) => i = %d\n", i);

    char str_a[20];
	strcpy(str_a, "Hello world!");
    print_string(str_a);
	
    int (*function_ptr)();
    function_ptr = function_one;
    int value1 = function_ptr();
    printf("function_ptr() => %d\n", value1);
    
    function_ptr = function_two;
    int value2 = function_ptr();
    printf("function_ptr() => %d\n", value2);

    return 0;
}
