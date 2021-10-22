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

queue.o: src/linked_queue.c include/linked_queue.h
	$(CC) $(CFLAGS) $(LDLIBS) -I include -c src/linked_queue.c -o build/linked_queue.o

test.o: test/linked_queue_test.c
	$(CC) $(CFLAGS) $(LDLIBS) -I $(UNITY) -I include -c test/linked_queue_test.c -o build/linked_queue_test.o

test: init unity.o queue.o test.o
	$(CC) $(CFLAGS) $(LDLIBS) build/unity.o build/linked_queue.o build/linked_queue_test.o -o build/linked_queue_test
	build/linked_queue_test


clean:
	rm -rf build/

