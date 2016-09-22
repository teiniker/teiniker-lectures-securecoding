
OBJECTS =
CFLAGS = -g -Wall -I/usr/include/glib-2.0 -I/usr/lib/glib-2.0/include  
LDLIBS = -lglib-2.0
CC=c99

all: agile

agile: agile.c
	$(CC) $(CFLAGS) $(LDLIBS) -o agile agile.c


clean:
	rm agile

