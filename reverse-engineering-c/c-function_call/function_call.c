#include<stdio.h>


int add(int a, int b)
{
    int s;
    s = a+b;
    return s;
}


int main(int argc, char** argv)
{
    int result = add(0x22222222, 0x44444444);

    printf("result = 0x%08x\n", result);
    return 0;    
}
