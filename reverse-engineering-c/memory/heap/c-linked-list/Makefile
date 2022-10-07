
OBJECTS = 
CFLAGS = -std=c17 -g -Wall
LDLIBS = 
CC=gcc


all: linked_list 

init:
	mkdir -p build

linked_list: init linked_list.c
	$(CC) $(CFLAGS) $(LDLIBS) -o build/linked_list linked_list.c 
	build/linked_list

clean:
	rm -rf build/

