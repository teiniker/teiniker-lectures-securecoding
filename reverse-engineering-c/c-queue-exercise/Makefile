
OBJECTS = 
CFLAGS = -std=c99 -g -Wall  
LDLIBS = 
CC=gcc


all: main  

linked_queue.o: linked_queue.c
	$(CC) $(CFLAGS) $(LDLIBS) -c linked_queue.c 

main.o: main.c
	$(CC) $(CFLAGS) $(LDLIBS) -c main.c

main: linked_queue.o main.o
	$(CC) $(CFLAGS) $(LDLIBS) linked_queue.o main.o -o linked_queue


clean:
	rm -f *.o linked_queue

