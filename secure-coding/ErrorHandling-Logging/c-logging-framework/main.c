#include <stdio.h>
#include <string.h>

#include <log4c.h>

int main(int argc, char** argv)
{
	log4c_category_t* mycat = NULL;
	
	log4c_init();
	mycat = log4c_category_get("org.se.lab");

	log4c_category_log(mycat, LOG4C_PRIORITY_DEBUG, "Debugging XXX");
	
	
	return 0;
}

