#include <stdio.h>
#include <stdlib.h>
#include <time.h>

const unsigned int SEED = 0;
const int RANGE_MAX = 0xff;
const int RANGE_MIN = 0x00;

int main(void)
{
    // The srand() function sets the starting point for producing a series
    // of pseudo-random integers.
    srand(SEED);  // Don't do that
    printf("Time: %d\n", time(NULL));
    // srand(time(NULL));  // Don't do that either

    for(int i=0; i<5; i++)
    {
        // rand() function is used in C to generate random numbers.
        // It returns a pseudo-random number in the range of 0 to RAND_MAX.
        // If we generate a sequence of random number with rand() function,
        // it will create the same sequence again and again every time program runs.
        int random_number = rand();
        printf(" %d ", random_number % RANGE_MAX + RANGE_MIN);
    }

    return 0;
}