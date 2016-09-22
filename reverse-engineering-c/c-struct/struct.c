#include <stdio.h>
#include <string.h>
#include <memory.h>
#include <stdlib.h>

/*
 * Structs are variables that contain many other variables.
 * In a struct, each element or field is named and has its own
 * data type.
 */

struct complex_number
{
    double re;
    double im;
};


struct complex_number complex_add(struct complex_number a,
                                    struct complex_number b)
{
    struct complex_number c;
    c.re = a.re + b.re;
    c.im = a.im + b.im;
    return c;
}


struct time
{
    int hh;
    int mm;
    int ss;
};


// There is no type information stored in a struct.
void time_dump(struct time *t_ptr)
{
    int size = sizeof(struct time);

    printf("%p:\n", t_ptr);
    for(int i=0; i<size; i++)
    {
        unsigned char *raw_ptr = (unsigned char *)t_ptr;
        printf("%02x ", *(raw_ptr+i));
    }
    printf("\n");
}


// We can set all data of a struct to 0 at once.
void time_init(struct time *t_ptr)
{
    memset(t_ptr, 0, sizeof(struct time));
}


int main()
{
    // Structures may be initialized at declaration time by putting
    // the list of elements in curly braces.
    struct complex_number c1 = {1.0, 1.0};
    struct complex_number c2;
    c2.re = 2.0;
    c2.im = 4.0;

    printf("c1 = (%f,%f)\n", c1.re, c1.im);
    printf("c2 = (%f,%f)\n", c2.re, c2.im);

    struct complex_number result = complex_add(c1,c2);
    printf("c1 + c2 = (%f,%f)\n", result.re, result.im);

    struct complex_number *c_ptr;
    c_ptr = (struct complex_number*)malloc(sizeof(struct complex_number)); 
    c_ptr->re = 7.0;
    c_ptr->im = -13.0;
    printf("*c_ptr = (%f,%f)\n", c_ptr->re, c_ptr->im);    
    free(c_ptr);
    
    struct time t = {12,15,3};
    time_dump(&t);
    time_init(&t);
    time_dump(&t);

	return 0;
}
