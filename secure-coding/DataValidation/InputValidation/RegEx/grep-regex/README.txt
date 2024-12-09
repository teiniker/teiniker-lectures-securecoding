Regular Expressions: egrep Examples 
-------------------------------------------------------------------------------

We use egrep to select strings from the file InputData.txt
$ grep -E
$ egrep

Examples: String Literals
-------------------------------------------------------------------------------
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


Examples: Username
-------------------------------------------------------------------------------
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


Examples: Filename
-------------------------------------------------------------------------------
$ egrep -n "^[a-zA-Z0-9_]{1,255}\.[a-zA-Z0-9]{0,3}$" InputData.txt
19:readme.txt
20:TODO.txt
22:stack.c


Examples: Time & Date
-------------------------------------------------------------------------------
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


Examples: IP Address
-------------------------------------------------------------------------------
$ egrep -n "^([0-9]{1,3}\.){3}[0-9]{1,3}$" InputData.txt
35:127.0.0.1
36:172.217.21.78


Examples: Integer Numbers
-------------------------------------------------------------------------------
$ egrep -n "^[-+]?[0-9]+$" InputData.txt 
1:255
2:-127

Examples: Hex Numbers
-------------------------------------------------------------------------------
$ egrep -n "^0[xX][a-fA-F0-9]+$" InputData.txt
3:0xffd2
4:0X12
5:0xCF76

$ egrep -n "^0[xX][a-fA-F0-9]{2}$" InputData.txt
4:0X12


Examples: Binary Numbers
-------------------------------------------------------------------------------
$ egrep -n "^0[bB][01]+$" InputData.txt
6:0b11110000
7:0B10101010


Examples: Floating Point Numbers
-------------------------------------------------------------------------------
$ egrep -n "^[-+]?[0-9]+\.[0-9]+$" InputData.txt
8:3.1415
9:-1.41

$ egrep -n "^[-+]?[0-9]+\.[0-9]+([eE][-+]?[0-9]+)?$" InputData.txt
8:3.1415
9:-1.41
10:1.23e-6


Examples: Email Address
-------------------------------------------------------------------------------
$ egrep -n "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" InputData.txt
27:homer.simpson@power-plant.com
28:lisa.simpson@springfield.com


Examples: Whitelisting vs. Blacklisting
-------------------------------------------------------------------------------
$ egrep -n "^[<>]" InputData.txt
38:<script>
39:<ScRiPt>
40:<SCRIPT>

$ egrep -n "^[^<>]" InputData.txt
1:255
2:-127
3:0xffd2
4:0X12
5:0xCF76
6:0b11110000
7:0B10101010
8:3.1415
9:-1.41
10:1.23e-6
12:hs
13:homer
14:Homer
15:HomerSimpson
16:bart_simpson
17:lisa-simpson
19:readme.txt
20:TODO.txt
21:HelloWorld.java
22:stack.c
24:homer.simpson@power-plant.com
25:lisa.simpson@springfield.com
27:14:57
28:14:57:23
30:09.12.2016
31:09-12-2016
32:9.12.2016
33:9.12.16
35:127.0.0.1
36:172.217.21.78

