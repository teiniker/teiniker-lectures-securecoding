#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool check_password(char* password)
{
    // valid: "!m)s*x24sP0" 
   
    if(strlen(password) >= 10 && password[0] == '!' && password[4] == '*')
    {
        return true;    
    }    
    else
        return false;
}


int main()
{
    char password[256];

    printf("password> ");
    scanf("%s", password);

    if(check_password(password))
    {
        printf("Welcome, you have entered a valid password!\n");
    }
    else
    {
        printf("Login rejected, invalid password!\n");
    }
	return 0;
}
