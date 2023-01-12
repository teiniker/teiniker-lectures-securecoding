How to inspect the binary file?
-------------------------------------------------------------------------------

$ hexdump -C product.bin 
00000000  ac ed 00 05 73 72 00 12  6f 72 67 2e 73 65 2e 6c  |....sr..org.se.l|
00000010  61 62 2e 50 72 6f 64 75  63 74 f8 08 10 14 0b 92  |ab.Product......|
00000020  18 5f 02 00 02 4a 00 08  71 75 61 6e 74 69 74 79  |._...J..quantity|
00000030  4c 00 04 6e 61 6d 65 74  00 12 4c 6a 61 76 61 2f  |L..namet..Ljava/|
00000040  6c 61 6e 67 2f 53 74 72  69 6e 67 3b 78 70 00 00  |lang/String;xp..|
00000050  00 00 11 22 33 44 74 00  14 41 70 70 6c 69 65 64  |..."3Dt..Applied|
00000060  20 43 72 79 70 74 6f 67  72 61 70 68 79           | Cryptography|


How to use hexedit?
-------------------------------------------------------------------------------
$ hexedit product.bin

[tab]               toggle hex/ASCII
[ctrl][shift][x]    save and exit
[ctrl][shift][c]    exit without saving


References:
-------------------------------------------------------------------------------
https://docs.oracle.com/javase/8/docs/platform/serialization/spec/protocol.html
https://linux.die.net/man/1/hexedit
