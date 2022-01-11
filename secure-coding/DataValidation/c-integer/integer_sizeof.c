#include <stdio.h>

int main(void)
{
    printf("char : %u\n", sizeof(char)); 
    printf("short: %u\n", sizeof(short)); 
    printf("int  : %u\n", sizeof(int)); 
    printf("long : %u\n", sizeof(long)); 
    printf("long long: %u\n", sizeof(long long));
    
    printf("void* : %u\n", sizeof(void*));

    return 0;
}
