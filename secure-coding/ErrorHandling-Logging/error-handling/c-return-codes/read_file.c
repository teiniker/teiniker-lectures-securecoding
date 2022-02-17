#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define ERROR_NONE					 0
#define ERROR_INVALID_ARGUMENT      -1
#define ERROR_CANNOT_OPEN_FILE      -2
#define ERROR_CANNOT_CLOSE_FILE     -3

int read_file(char* filename)
{
    char line[256];    
    FILE *fp;

    if(filename == NULL || strlen(filename) < 4)
        return ERROR_INVALID_ARGUMENT;

    fp = fopen(filename, "r");
    if (fp == NULL) 
    {
        return ERROR_CANNOT_OPEN_FILE;
    }
    
    while(fscanf(fp, "%s", line) != EOF)
    {
        printf("> %s\n", line);
    }

    int error_code = fclose(fp);
    if(error_code == EOF)
        return ERROR_CANNOT_CLOSE_FILE;
    else
        return ERROR_NONE;
}


int main(int argc, char *argv[])
{
    char* filename;

    if(argc != 2)
    {
        fprintf(stderr, "Usage: read_file <filename>\n");
        return EXIT_FAILURE;
    } 
    
    filename = argv[1]; 
    int error_code = read_file(filename);
    switch(error_code)
    {
        case ERROR_INVALID_ARGUMENT:
            fprintf(stderr, "ERROR: Illegal argument filename: %s\n", filename);
            return EXIT_FAILURE;
        case ERROR_CANNOT_OPEN_FILE:
            fprintf(stderr, "ERROR: Can't open file: %s\n", filename);
            return EXIT_FAILURE;
        case ERROR_CANNOT_CLOSE_FILE:
            fprintf(stderr, "ERROR: Can't close file: %s\n", filename);
            return EXIT_FAILURE;
    }
    return EXIT_SUCCESS;
}
