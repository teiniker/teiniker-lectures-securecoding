
OBJECTS = 
CFLAGS = -std=c17 -g -Wall
LDLIBS = 
CC=gcc
UNITY=../../../unity

all: test

init:
	mkdir -p build

unity.o: $(UNITY)/unity.c $(UNITY)/unity.h
	$(CC) $(CFLAGS) -c $(UNITY)/unity.c -o build/unity.o

stack.o: stack.c
	$(CC) $(CFLAGS) $(LDLIBS) -I $(UNITY) -c stack.c -o build/stack.o

test.o: stack_test.c
	$(CC) $(CFLAGS) $(LDLIBS) -I $(UNITY) -c stack_test.c -o build/stack_test.o

test: init unity.o stack.o test.o
	$(CC) $(CFLAGS) $(LDLIBS) build/unity.o build/stack.o build/stack_test.o -o build/stack_test
	build/stack_test

clean:
	rm -rf build/

