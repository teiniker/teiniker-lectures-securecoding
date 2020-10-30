BJECTS =
CFLAGS = -std=c11 -g -Wall
LDLIBS =
CC=gcc
UNITY=../unity

all: test

init:
	mkdir -p build

unity.o: $(UNITY)/unity.c $(UNITY)/unity.h
	$(CC) $(CFLAGS) -c $(UNITY)/unity.c -o build/unity.o

linked_list.o: src/linked_list.c include/linked_list.h
	$(CC) $(CFLAGS) $(LDLIBS) -I include -c src/linked_list.c -o build/linked_list.o

test.o: test/linked_list_test.c
	$(CC) $(CFLAGS) $(LDLIBS) -I $(UNITY) -I include -c test/linked_list_test.c -o build/linked_list_test.o

test: init unity.o linked_list.o test.o
	$(CC) $(CFLAGS) $(LDLIBS) build/unity.o build/linked_list.o build/linked_list_test.o -o build/linked_list_test
	build/linked_list_test


clean:
	rm -rf build/

