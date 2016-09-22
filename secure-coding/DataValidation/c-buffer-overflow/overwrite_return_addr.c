#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void attack()
{
    printf("attacker's code is executed!!\n");
    exit(0);
}


void get_input()
{   
    char buffer[8];
 
//    strcpy(buffer, "AAAAAAAAAAAA\x60\x84\x04\x08");  
    gets(buffer);
    puts(buffer);
}


int main(int argc, char** argv)
{
    get_input();

    return 0;
}
