#include<stdio.h>

int add2(int a, int b)
{
    int s;
    s = a+b;
    return s;
}


int add1(int a, int b)
{
    int s;
    s = add2(a,b);
    return s;
}


int main(int argc, char** argv)
{
    int result;

    result = add1(0x22222222, 0x44444444);

    printf("result = 0x%08x\n", result);
    return 0;    
}
