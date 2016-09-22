
OBJECTS = 
CFLAGS = -std=c99 -g -Wall  
LDLIBS = 
CC=gcc


all: main  



stack.o: stack.c
	$(CC) $(CFLAGS) $(LDLIBS) -c stack.c 

main.o: main.c
	$(CC) $(CFLAGS) $(LDLIBS) -c main.c 

main: stack.o main.o
	$(CC) $(CFLAGS) $(LDLIBS) stack.o main.o -o stack 

clean:
	rm -f *.o stack

