# Regular Expressions Using egrep 

We use the command line tools **egrep** (or `grep -E`) to select strings from 
a given file `InputData.txt`:


## Validating Numbers

_Example:_ Matching integer numbers

```bash
$ egrep -n "^[-+]?[0-9]+$" InputData.txt 
1:255
2:-127
```

_Example:_ Matching hex numbers

```bash
$ egrep -n "^0[xX][a-fA-F0-9]+$" InputData.txt
3:0xffd2
4:0X12
5:0xCF76

$ egrep -n "^0[xX][a-fA-F0-9]{2}$" InputData.txt
4:0X12
```

_Example:_ Matching binary numbers

```bash
$ egrep -n "^0[bB][01]+$" InputData.txt
6:0b11110000
7:0B10101010
```

_Example:_ Matching floating point numbers

```bash
$ egrep -n "^[-+]?[0-9]+\.[0-9]+$" InputData.txt
8:3.1415
9:-1.41

$ egrep -n "^[-+]?[0-9]+\.[0-9]+([eE][-+]?[0-9]+)?$" InputData.txt
8:3.1415
9:-1.41
10:1.23e-6
```

## Validating Strings 

_Example:_ Matching string literals

```bash
$ egrep -n "Homer" InputData.txt 
14:Homer
15:HomerSimpson

$ egrep -n "Homer|homer" InputData.txt 
13:homer
14:Homer
15:HomerSimpson
24:homer.simpson@power-plant.com

$ egrep -n "[Hh]omer" InputData.txt
13:homer
14:Homer
15:HomerSimpson
24:homer.simpson@power-plant.com

$ egrep -n "^[Hh]omer$" InputData.txt 
13:homer
14:Homer
```

_Example:_ Matching a username

```bash
$ egrep -n "^[a-zA-Z_-]+$" InputData.txt
12:hs
13:homer
14:Homer
15:HomerSimpson
16:bart_simpson
17:lisa-simpson

$ egrep -n "^[a-zA-Z_-]{8,32}$" InputData.txt
15:HomerSimpson
16:bart_simpson
17:lisa-simpson
```

_Example:_ Matching a filename

```bash
$ egrep -n "^[a-zA-Z0-9_]{1,255}\.[a-zA-Z0-9]{0,3}$" InputData.txt
19:readme.txt
20:TODO.txt
22:stack.c
```

_Example:_ Matching email address

```bash
$ egrep -n "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" InputData.txt
27:homer.simpson@power-plant.com
28:lisa.simpson@springfield.com
```

_Example:_ Matching time and date

```bash
$ egrep -n "^[0-9]{2}:[0-9]{2}$" InputData.txt 
27:14:57   	# Note: 27: is the line number!!

$ egrep -n "^[0-9]{2}:[0-9]{2}:[0-9]{2}$" InputData.txt 
28:14:57:23	# Note: 28: is the line number!

$ egrep -n "^([0-9]{2}:){2}[0-9]{2}$" InputData.txt
28:14:57:23

$ egrep -n "^[0-9]{2}.[0-9]{2}.[0-9]{4}$" InputData.txt 
30:09.12.2016
31:09-12-2016
# Note: . matches any character!

$ egrep -n "^[0-9]{2}\.[0-9]{2}\.[0-9]{4}$" InputData.txt 
30:09.12.2016

$ egrep -n "^[0-9]{2}-[0-9]{2}-[0-9]{4}$" InputData.txt
31:09-12-2016
```


_Example:_ Matching IP address

```bash
$ egrep -n "^([0-9]{1,3}\.){3}[0-9]{1,3}$" InputData.txt
35:127.0.0.1
36:172.217.21.78
```

_Egon Teiniker, 2025, GPL v3.0_