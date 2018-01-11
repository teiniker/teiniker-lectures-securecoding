
OBJECTS = 
CFLAGS = -ggdb -fno-stack-protector -z execstack -Wall
LDLIBS = 
CC=gcc


all: fmt_string


fmt_string: fmt_string.c
	$(CC) $(CFLAGS) $(LDLIBS) -o fmt_string fmt_string.c


clean:
	rm fmt_string
