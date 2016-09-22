Example: Tracing System Calls
---------------------------------------------------------------------

1. Start the MySQL server

$ su
Password: root66
# systemctl start mariadb.service


2. Start the mysql client console

$ mysql -u student -p
Enter password: student

MariaDB [(none)]> use testdb;
MariaDB [testdb]> source createTable.sql


3. Attach strace to the mysql process

$ ps -a
 PID TTY          TIME CMD
 2194 pts/2    00:00:00 su
 2202 pts/2    00:00:00 bash
 2691 pts/0    00:00:00 vim
 2694 pts/3    00:00:00 mysql   <=
 2737 pts/1    00:00:00 ps

$ strace -p 2694 -s 1024

switch to the mysql console and type:
MariaDB [testdb]> select * from User;

read(0, "s", 1)                         = 1
write(1, "s", 1)                        = 1
read(0, "e", 1)                         = 1
write(1, "e", 1)                        = 1
read(0, "l", 1)                         = 1
write(1, "l", 1)                        = 1
read(0, "e", 1)                         = 1
write(1, "e", 1)                        = 1
read(0, "c", 1)                         = 1
write(1, "c", 1)                        = 1
read(0, "t", 1)                         = 1
write(1, "t", 1)                        = 1
read(0, " ", 1)                         = 1
write(1, " ", 1)                        = 1
read(0, "*", 1)                         = 1
write(1, "*", 1)                        = 1
read(0, " ", 1)                         = 1
write(1, " ", 1)                        = 1
read(0, "f", 1)                         = 1
write(1, "f", 1)                        = 1
read(0, "r", 1)                         = 1
write(1, "r", 1)                        = 1
read(0, "o", 1)                         = 1
write(1, "o", 1)                        = 1
read(0, "m", 1)                         = 1
write(1, "m", 1)                        = 1
read(0, " ", 1)                         = 1
write(1, " ", 1)                        = 1
read(0, "U", 1)                         = 1
write(1, "U", 1)                        = 1
read(0, "s", 1)                         = 1
write(1, "s", 1)                        = 1
read(0, "e", 1)                         = 1
write(1, "e", 1)                        = 1
read(0, "r", 1)                         = 1
write(1, "r", 1)                        = 1
read(0, ";", 1)                         = 1
write(1, ";", 1)                        = 1
read(0, "\r", 1)                        = 1
write(1, "\n", 1)                       = 1
rt_sigprocmask(SIG_BLOCK, [INT], [], 8) = 0

...

write(3, "\23\0\0\0\3select * from User", 23) = 23
read(3, "\1\0\0\1\3(\0\0\2\3def\6testdb\4User\4User\2id\2id\f?\0\v\0\0\0\3\3B\0\0\0004\0\0\3\3def\6testdb\4User\4User\10username\10username\f!\0\300\0\0\0\375\1\20\0\0\0004\0\0\4\3def\6testdb\4User\4User\10password\10password\f!\0\0\3\0\0\375\1\20\0\0\0\5\0\0\5\376\0\0\"\0\20\0\0\6\0011\5homer\7*******\17\0\0\7\0012\4bart\7*******\17\0\0\10\0013\4lisa\7*******\5\0\0\t\376\0\0\"\0", 16384) = 237
times({tms_utime=0, tms_stime=6, tms_cutime=0, tms_cstime=0}) = 429889215
write(1, "+----+----------+----------+\n", 29) = 29
write(1, "| id | username | password |\n", 29) = 29
write(1, "+----+----------+----------+\n", 29) = 29
write(1, "|  1 | homer    | *******  |\n", 29) = 29
write(1, "|  2 | bart     | *******  |\n", 29) = 29
write(1, "|  3 | lisa     | *******  |\n", 29) = 29
write(1, "+----+----------+----------+\n", 29) = 29
write(1, "\33(B\33[0;1m3 rows in set (0.01 sec)\n", 34) = 34
write(1, "\33(B\33[m\33(B\33[0;1m\n", 16) = 16

...

to stop strace hit [Ctrl-c]


