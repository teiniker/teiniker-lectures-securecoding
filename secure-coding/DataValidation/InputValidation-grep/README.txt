#
# Regular Expressions: egrep examples 
#

We use egrep to select strings from the file InputData:


Example: Integer Numbers
-------------------------------------------------------------------------------
$ egrep -n "^[-+]?[0-9]+$" InputData.txt 
1:255
2:-127

Example: Hex Numbers
-------------------------------------------------------------------------------
$ egrep -n "^0[xX][a-fA-F0-9]+$" InputData.txt
3:0xffd2
4:0X12
5:0xCF76

$ egrep -n "^0[xX][a-fA-F0-9]{2}$" InputData.txt
4:0X12


Example: Binary Numbers
-------------------------------------------------------------------------------
$ egrep -n "^0[bB][01]+$" InputData.txt
6:0b11110000
7:0B10101010


Example: Floating Point Numbers
-------------------------------------------------------------------------------
$ egrep -n "^[-+]?[0-9]+\.[0-9]+$" InputData.txt
8:3.1415
9:-1.41

$ egrep -n "^[-+]?[0-9]+\.[0-9]+([eE][-+]?[0-9]+)?$" InputData.txt
8:3.1415
9:-1.41
10:1.23e-6


Example: Username
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


Example: Email Address
-------------------------------------------------------------------------------
$ egrep -n "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" InputData.txt
27:homer.simpson@power-plant.com
28:lisa.simpson@springfield.com




