#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>


int main()
{
    char password[256];
    strcpy(password, "IxooVlfkd7Pl");
    printf("encrypted password: %s\n", password);


    for(int i=0; i<strlen(password); i++)
    {
       password[i] = password[i] -3; 
    }

    printf("plaintext password: %s\n", password);

	return 0;
}
