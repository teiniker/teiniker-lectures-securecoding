
OBJECTS = 
CFLAGS = -ggdb -fno-stack-protector -z execstack -Wall
LDLIBS = 
CC=gcc


all: overwrite_local_vars overwrite_return_addr

overwrite_local_vars: overwrite_local_vars.c
	$(CC) $(CFLAGS) $(LDLIBS) -o overwrite_local_vars overwrite_local_vars.c

overwrite_return_addr: overwrite_return_addr.c
	$(CC) $(CFLAGS) $(LDLIBS) -o overwrite_return_addr overwrite_return_addr.c

clean:
	rm overwrite_local_vars overwrite_return_addr
