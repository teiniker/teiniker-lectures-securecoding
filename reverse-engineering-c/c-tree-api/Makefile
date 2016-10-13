
OBJECTS = 
CFLAGS = -std=c99 -g -Wall  
LDLIBS = 
CC=gcc


all: main 

tree.o: tree.c tree.h
	$(CC) $(CFLAGS) $(LDLIBS) -c tree.c 

main.o: main.c 
	$(CC) $(CFLAG) $(LDLIBS) -c main.c

main: tree.o main.o
	$(CC) $(CFLAG) $(LDLIBS) tree.o main.o -o main

clean:
	rm -f main *.o

