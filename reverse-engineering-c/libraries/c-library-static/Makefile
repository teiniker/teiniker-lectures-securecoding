
OBJECTS = 
CFLAGS = -std=c99 -g -Wall  
LDLIBS = 
CC=gcc


all: main 

linked_list_user.o: linked_list_user.c linked_list_user.h 
	$(CC) $(CFLAGS) $(LDLIBS) -c linked_list_user.c 

lib: linked_list_user.o
	ar -cvq liblist.a *.o

install: lib
	mkdir lib
	mv liblist.a lib/
	mkdir include
	cp linked_list_user.h include/

main: main.c install 
	$(CC) $(CFLAGS) $(LDLIBS) -o main main.c -I./include -L./lib -llist 

clean:
	rm -rf *.o main lib/ include/

