
OBJECTS = 
CFLAGS = -std=c99 -g -Wall  
LDLIBS = 
CC=gcc


all: main  

linked_list.o: linked_list.c
	$(CC) $(CFLAGS) $(LDLIBS) -c linked_list.c 

main.o: main.c
	$(CC) $(CFLAGS) $(LDLIBS) -c main.c

main: linked_list.o main.o
	$(CC) $(CFLAGS) $(LDLIBS) linked_list.o main.o -o linked_list


clean:
	rm -f *.o linked_list

