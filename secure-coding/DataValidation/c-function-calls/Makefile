
OBJECTS = 
CFLAGS = -ggdb -fno-stack-protector -z execstack -Wall
LDLIBS = 
CC=gcc


all: function_call 


function_call: function_call.c
	$(CC) $(CFLAGS) $(LDLIBS) -o function_call function_call.c

clean:
	rm function_call
