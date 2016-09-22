JIT Compiler Monitoring
---------------------------------------------------------------------
see Hunt2012 page 146, 565f

$ java -XX:+PrintCompilation -cp ./target/classes org.se.lab.Loop
    144    1             java.lang.String::hashCode (67 bytes)
    158    2             sun.nio.cs.UTF_8$Encoder::encode (361 bytes)
    167    3             java.lang.String::charAt (33 bytes)
    169    4             java.lang.String::indexOf (87 bytes)
    177    5             java.lang.Object::<init> (1 bytes)
    199    6             java.lang.AbstractStringBuilder::ensureCapacityInternal (16 bytes)
    202    7     n       java.lang.System::arraycopy (0 bytes)   (static)
    203    8             java.lang.String::length (5 bytes)
    204    9             java.lang.Integer::stringSize (21 bytes)
    208   10             java.lang.Integer::getChars (131 bytes)
    221   11             java.lang.Math::min (11 bytes)
    232   12             java.lang.String::getChars (66 bytes)
    234   13             java.lang.AbstractStringBuilder::append (48 bytes)
    239   14             java.lang.StringBuilder::append (8 bytes)
    240   15             java.lang.String::<init> (72 bytes)
    245   16             java.util.Arrays::copyOfRange (63 bytes)
    247   17             java.lang.AbstractStringBuilder::<init> (12 bytes)
    248   18             java.lang.StringBuilder::toString (17 bytes)
    249   19             java.lang.StringBuilder::append (8 bytes)
    250   20             java.lang.AbstractStringBuilder::append (29 bytes)
    252   21             java.lang.String::valueOf (14 bytes)
    259   22             org.se.lab.Loop::add (24 bytes)
    260   23             java.lang.String::toString (2 bytes)
    261   24             java.lang.StringBuilder::<init> (18 bytes)
    261   25             java.lang.StringBuilder::append (8 bytes)
    269   26             java.lang.AbstractStringBuilder::append (62 bytes)
   1625    1 %           org.se.lab.Loop::main @ 8 (31 bytes)

   