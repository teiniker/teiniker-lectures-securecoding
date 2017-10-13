#include <stdio.h>
#include <string.h>
#include <memory.h>

int main()
{
    printf("sizeof(char) = %lu\n", sizeof(char));
    printf("\n");
    printf("sizeof(short) = %lu\n", sizeof(short));
    printf("sizeof(int) = %lu\n", sizeof(int));
    printf("sizeof(long) = %lu\n", sizeof(long));
    printf("sizeof(long long) = %lu\n", sizeof(long long));
    printf("\n");
    printf("sizeof(float) = %lu\n", sizeof(float));
    printf("sizeof(double) = %lu\n", sizeof(double));
    printf("sizeof(long double) = %lu\n", sizeof(long double));
    printf("\n");
    printf("sizeof(void*) = %lu\n", sizeof(void*));
    printf("sizeof(char*) = %lu\n", sizeof(char*));
    printf("sizeof(int*) = %lu\n", sizeof(int*));
    //...
    printf("sizeof(long double*) = %lu\n", sizeof(long double*));
	return 0;
}