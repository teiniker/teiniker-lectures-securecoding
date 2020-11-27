#include <stdio.h>
#include <stdlib.h>

int global_var;

int global_initialized_var = 5;


void function(void)
{
	int stack_var;

	printf("\tfunction.stack_var at %p\n", &stack_var);	
}


int main(void)
{
	int stack_var;
	
	static int static_var;
	static int static_initialized_var = 5;
	int *heap_var_ptr = (int *)malloc(sizeof(int));
    *heap_var_ptr = 7;

	// stack segment
	printf("stack segment:\n");
	printf("\tstack_var at %p\n", &stack_var);
	function();
	
	// heap segment
	printf("heap segment:\n");	
	printf("\theap_var_ptr at %p\n", heap_var_ptr);

	// bss segment
	printf("bss segment:\n");	
	printf("\tglobal_var at %p\n", &global_var);
	printf("\tstatic_var at %p\n", &static_var);

	// data segment
	printf("data segment:\n");
	printf("\tglobal_initialized_var at %p\n", &global_initialized_var);
	printf("\tstatic_initialized_var at %p\n", &static_initialized_var);

	// code segment
	printf("code segment:\n");
    printf("\tmain() at %p\n", &main);
	printf("\tfunction() at %p\n", &function);

    free(heap_var_ptr);

	return 0;
}

