#include<stdio.h>
#include<stdlib.h>

void read_line()
{
    int flag = 0x0;
    char buffer[8];
    
    gets(buffer);

    if(flag == 0x0)
    {
        printf("Access rejected!!\n");
    }
    else
    {
        printf("Access permited!!\n");
    }
}


int main(int argc, char** argv)
{
    read_line();

    return 0;
}
