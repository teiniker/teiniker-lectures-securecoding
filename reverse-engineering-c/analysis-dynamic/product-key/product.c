#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>


bool validate_key(char* key)
{
    if(strcmp("ABCD-EFGH-IJKL-MNOP", key) == 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}

bool validate_username(char* username)
{
    if(strcmp("student", username) == 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}


int main(int argc, char* argv[])
{
    if(argc != 3)
    {
        printf("Usage: product <username> <kex>\n");
        exit(0);
    }

    if(validate_username(argv[1]) && validate_key(argv[2]))
    {
        printf("Welcome to your product.\n");    
    }
    else
    {
        printf("Invalid product key or username!\n");
    }
	return 0;
}
