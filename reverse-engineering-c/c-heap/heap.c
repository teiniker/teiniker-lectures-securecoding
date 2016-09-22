#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void *errorchecked_malloc(unsigned int size)
{
	void *ptr = malloc(size);
	if(ptr == NULL)
	{
		fprintf(stderr, "ERROR: Could not allocate heap memory!\n");
		exit(-1); 
	}
	return ptr;
}


int main(int argc, char *argv[])
{
	char *char_ptr;
	int *int_ptr;
	int mem_size;

	if(argc < 2)
	{
		printf("Usage: heap <size>\n");	
		exit(0);
	}
	
	mem_size = atoi(argv[1]);
    
    printf("size of %p is %d\n" , int_ptr, sizeof(int_ptr));

	printf("\t[+] allocating %d bytes for char_ptr\n", mem_size);
	char_ptr = (char *) errorchecked_malloc(mem_size);

	strcpy(char_ptr, "This is memory allocated on the heap!");
	printf("char_ptr (%p) --> '%s'\n", char_ptr, char_ptr);

	printf("\t[+] allocating %d bytes for int_ptr\n", 3*sizeof(int));
	int_ptr = (int *) errorchecked_malloc(3*sizeof(int));
	*int_ptr = 1234;
	printf("int_ptr (%p) --> %d\n", int_ptr, *int_ptr);
	
	printf("\t[-] freeing int_ptr\n");
	free(int_ptr);

	printf("\t[-] freeing char_ptr\n");
	free(char_ptr);

/*
    for(int i=0; i<10000000; i++)
    {
        errorchecked_malloc(10000000);
    }
*/
	return 0;
}
