
OBJECTS = 
CFLAGS = -std=c99 -g -Wall  
LDLIBS = 
CC=gcc


all: main 

linked_list_user.o: linked_list_user.c linked_list_user.h 
	$(CC) $(CFLAGS) $(LDLIBS) -c linked_list_user.c 

main.o: main.c 
	$(CC) $(CFLAGS) $(LDLIBS) -c main.c 

main: linked_list_user.o main.o 
	$(CC) $(CFLAGS) $(LDLIBS) linked_list_user.o main.o -o linked_list_user 

clean:
	rm -f *.o linked_list_user

