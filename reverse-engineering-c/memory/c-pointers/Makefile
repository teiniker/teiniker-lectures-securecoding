OBJECTS = 
CFLAGS = -std=c17 -g -Wall
LDLIBS = 
CC=gcc


all: pointers 

init:
	mkdir -p build

pointers: init pointers.c
	$(CC) $(CFLAGS) $(LDLIBS) -o build/pointers pointers.c 
	build/pointers

type_sizes: init type_sizes.c
	$(CC) $(CFLAGS) $(LDLIBS) -o build/type_sizes type_sizes.c

clean:
	rm -rf build/

