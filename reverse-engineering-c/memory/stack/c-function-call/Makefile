OBJECTS = 
CFLAGS = -g -std=c17 -Wall  
LDLIBS = 
CC=gcc


all: function_call 

init:
	mkdir -p build

function_call: init function_call.c
	$(CC) $(CFLAGS) $(LDLIBS) -o build/function_call function_call.c
	build/function_call

clean:
	rm -rf build/
