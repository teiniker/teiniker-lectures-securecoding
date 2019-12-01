#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <sys/ptrace.h>

char* get_secret(void)
{
    char* secret_ptr = "ACD0-84F1-9A56-47BC";
    return secret_ptr;
}


int is_correct_password(char* password)
{
    if(strcmp("6LJ53vc6kFtwY_", password) == 0)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}


int main(int argc, char* argv[])
{
    // Stop the process if it is traced by its parent.
    if(ptrace(PTRACE_TRACEME, 0, 1, 0) == -1)
    {
        printf("Don't trace me!!\n");
        return 1;
    }

    // Regular implementation
    if(argc != 2)
    {
        printf("Usage: secret <password>\n");
        exit(0);
    }

    if(is_correct_password(argv[1]))
    {
        printf("%s\n", get_secret());    
    }
    else
    {
        printf("Invalid password!\n");
    }
	return 0;
}
