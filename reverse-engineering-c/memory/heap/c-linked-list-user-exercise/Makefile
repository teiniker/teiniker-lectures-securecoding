BJECTS =
CFLAGS = -std=c11 -g -Wall
LDLIBS =
CC=gcc
UNITY=../../unity

all: test

init:
	mkdir -p build

unity.o: $(UNITY)/unity.c $(UNITY)/unity.h
	$(CC) $(CFLAGS) -c $(UNITY)/unity.c -o build/unity.o

linked_list.o: linked_list.c linked_list.h
	$(CC) $(CFLAGS) $(LDLIBS) -c linked_list.c -o build/linked_list.o

test.o: linked_list_test.c
	$(CC) $(CFLAGS) $(LDLIBS) -I $(UNITY) -c linked_list_test.c -o build/linked_list_test.o

test: init unity.o linked_list.o test.o
	$(CC) $(CFLAGS) $(LDLIBS) build/unity.o build/linked_list.o build/linked_list_test.o -o build/linked_list_test
	build/linked_list_test

clean:
	rm -rf build/

