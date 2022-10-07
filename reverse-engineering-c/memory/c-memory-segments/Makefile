OBJECTS = 
CFLAGS = -std=c17 -g -Wall
LDLIBS = 
CC=gcc


all: memory_segments 

init:
	mkdir -p build

memory_segments: init memory_segments.c
	$(CC) $(CFLAGS) $(LDLIBS) -o build/memory_segments memory_segments.c 
	build/memory_segments

clean:
	rm -rf build/

