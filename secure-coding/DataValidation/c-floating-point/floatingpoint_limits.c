#include <stdio.h>
#include <float.h>

int main(void)
{
    printf("FLT_MAX     :   %g\n", (float) FLT_MAX);
    printf("FLT_MIN     :   %g\n", (float) FLT_MIN);
    printf("DBL_MAX     :   %g\n", (double) DBL_MAX);
    printf("DBL_MIN     :   %g\n", (double) DBL_MIN);
    printf("LDBL_MIN     :  %g\n", (double) LDBL_MIN);
    printf("LDBL_MAX     :  %g\n", (double) LDBL_MAX);
    
    return 0;
}
