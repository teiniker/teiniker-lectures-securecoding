
OBJECTS = 
CFLAGS = -std=c11 -g -Wall
LDLIBS = 
CC=gcc


all: pointers type_sizes

pointer: pointers.c
	$(CC) $(CFLAGS) $(LDLIBS) -o pointers pointers.c 

type_sizes: type_sizes.c
	$(CC) $(CFLAGS) $(LDLIBS) -o type_sizes type_sizes.c

clean:
	rm -f pointers
	rm -f type_sizes

