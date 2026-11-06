
OBJECTS = 
CFLAGS = -std=c17 -Wall  
LDLIBS = 
CC=gcc


all: secret 


secret: secret.c
	$(CC) $(CFLAGS) $(LDLIBS) -o secret secret.c 
	strip secret 

clean:
	rm -f secret 

