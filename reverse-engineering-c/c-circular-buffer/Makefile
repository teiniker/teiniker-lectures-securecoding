
OBJECTS = 
CFLAGS = -std=c99 -g -Wall  
LDLIBS = 
CC=gcc


all: main  

circular_buffer.o: circular_buffer.c
	$(CC) $(CFLAGS) $(LDLIBS) -c circular_buffer.c

main.o: main.c
	$(CC) $(CFLAGS) $(LDLIBS) -c main.c

main: circular_buffer.o main.o
	$(CC) $(CFLAGS) $(LDLIBS) circular_buffer.o main.o -o circular_buffer


clean:
	rm -f *.o circular_buffer

