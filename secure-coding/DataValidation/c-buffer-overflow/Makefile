
OBJECTS = 
CFLAGS = -ggdb -mpreferred-stack-boundary=2 -fno-stack-protector -z execstack -Wall  
LDLIBS = 
CC=gcc


all: function_call overwrite_local_vars overwrite_return_addr 


function_call: function_call.c
	$(CC) $(CFLAGS) $(LDLIBS) -o function_call function_call.c

overwrite_local_vars: overwrite_local_vars.c
	$(CC) $(CFLAGS) $(LDLIBS) -o overwrite_local_vars overwrite_local_vars.c

overwrite_return_addr: overwrite_return_addr.c
	$(CC) $(CFLAGS) $(LDLIBS) -o overwrite_return_addr overwrite_return_addr.c

clean:
	rm function_call overwrite_local_vars overwrite_return_addr
