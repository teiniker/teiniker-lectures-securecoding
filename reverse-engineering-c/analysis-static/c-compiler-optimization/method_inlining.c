#include <stdio.h>

void empty_method(void)
{
    // do nothing
}

void print_number(int number)
{
    printf("\tnumber =%2d\n", number);
}

int main(void)
{
    for(int i=0; i < 10000; i++)
    {
        empty_method();
        print_number(i);
    }
    return 0;
}