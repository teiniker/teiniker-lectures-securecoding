#include <stdio.h>
#include <stdlib.h>
#include <time.h>

const unsigned int SEED = 0;
const int RANGE_MAX = 0xff;
const int RANGE_MIN = 0x00;

int main(void)
{
    srand(SEED);  // Don't do that
    printf("Time: %d\n", time(NULL));
    // srand(time(NULL));  // Don't do that either

    for(int i=0; i<5; i++)
    {
        int random_number = rand();
        printf(" %d ", random_number % RANGE_MAX + RANGE_MIN);
    }

    return 0;
}