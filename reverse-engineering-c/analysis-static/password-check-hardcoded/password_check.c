#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

int constant(void)
{
    return 2;
}

int len(void)
{
    return 6*constant();
}

char *secret(void)
{
    return "VvnoWnioi8hjHGzu&56nm;:mkhjghfg";
}

bool validate(char* password)
{
    if(strlen(password) != len())
        return false;
        
    if(strncmp(secret()+10, password, len()) == 0)
        return true;
    else 
        return false;    
}


int main()
{
    char password[256];

    printf("password> ");
    scanf("%s", password);

    if(validate(password))
    {
        printf("Welcome, you have entered a valid password!\n");
    }
    else
    {
        printf("Login rejected, invalid password!\n");
    }
	return 0;
}
