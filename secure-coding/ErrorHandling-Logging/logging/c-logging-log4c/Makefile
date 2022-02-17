
OBJECTS =
CFLAGS = -g -Wall -I /home/student/install/log4c-1.2.4/include -L /home/student/install/log4c-1.2.4/lib   
LDLIBS = -llog4c
CC=c99

all: main

main: main.c
	$(CC) $(CFLAGS) $(LDLIBS) -o main main.c


clean:
	rm main

