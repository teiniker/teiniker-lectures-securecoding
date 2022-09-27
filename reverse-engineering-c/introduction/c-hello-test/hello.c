#include <stdio.h>
#include "hello.h"

int say_hello(const char *name)
{
	if(name == NULL)
		return 0;
		
	return printf("Hello %s!\n", name);
}