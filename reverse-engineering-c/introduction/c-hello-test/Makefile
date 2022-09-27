CFLAGS=-std=c11 -g -Wall
CC=gcc
UNITY=../../unity

all: test

init:
	mkdir -p build

unity.o: $(UNITY)/unity.c $(UNITY)/unity.h
	$(CC) $(CFLAGS) -c $(UNITY)/unity.c -o build/unity.o

hello.o: hello.c hello.h
	$(CC) $(CFLAGS) -I $(UNITY) -c hello.c -o build/hello.o

test.o: test.c hello.h
	$(CC) $(CFLAGS) -I $(UNITY) -c test.c -o build/test.o

test: init hello.o unity.o test.o
	$(CC) $(CFLAGS) build/hello.o build/unity.o build/test.o -o build/test
	build/test 

main.o: main.c hello.h
	$(CC) $(CFLAGS) -I $(UNITY) -c main.c -o build/main.o

main: init hello.o main.o 
	$(CC) $(CFLAGS) build/hello.o build/main.o -o build/main
	build/main 


clean:
	rm -rf build/

