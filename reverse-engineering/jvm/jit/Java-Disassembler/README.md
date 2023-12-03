# Java Disassembler

A Java disassembler like **javap** is a tool that reverses the process of
compilation for Java classes, converting compiled bytecode back into a
**human-readable form**.

It's used to inspect the contents of Java class files, including their
methods, constructors, and fields.

`javap` provides insights into the bytecode, helping developers understand
the low-level instructions executed by the Java Virtual Machine (JVM).

This tool is especially useful for debugging, analyzing the efficiency
of compiled code, and understanding how high-level Java constructs are
transformed into JVM bytecode.

_Example_: Disassemble DataTypes.java (classes and method signatures)
```
$ javap target/classes/org/se/lab/DataTypes.class
Compiled from "DataTypes.java"

public class org.se.lab.DataTypes {
  public org.se.lab.DataTypes();
  public void primitiveTypes();
}
```

_Example_: Disassemble DataTypes.java (bytecode instructions)
```
$ javap -c target/classes/org/se/lab/DataTypes.class

Compiled from "DataTypes.java"
public class org.se.lab.DataTypes {
  public org.se.lab.DataTypes();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void primitiveTypes();
    Code:
       0: bipush        100
       2: istore_1
       3: ldc           #7                  // int 1000000
       5: istore_2
       6: lconst_1
       7: lstore_3
       8: ldc2_w        #8                  // long -1l
      11: lstore        5
      13: ldc2_w        #10                 // double 3.14d
      16: dstore        7
      18: return
```

_Example_: Disassemble DataTypes.java (constant pool, stack sizes, bytecode instructions, and more metadata)
```
$ javap -v target/classes/org/se/lab/DataTypes.class

Classfile org/se/lab/DataTypes.class
  Last modified Dec 3, 2023; size 493 bytes
  SHA-256 checksum 277967b78ee844c457061c1189101569b74df0df8f87f60fb2f19162b6684a4b
  Compiled from "DataTypes.java"
public class org.se.lab.DataTypes
  minor version: 0
  major version: 65
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #12                         // org/se/lab/DataTypes
  super_class: #2                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
   #2 = Class              #4             // java/lang/Object
   #3 = NameAndType        #5:#6          // "<init>":()V
   #4 = Utf8               java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Integer            1000000
   #8 = Long               -1l
  #10 = Double             3.14d
  #12 = Class              #13            // org/se/lab/DataTypes
  #13 = Utf8               org/se/lab/DataTypes
  #14 = Utf8               Code
  #15 = Utf8               LineNumberTable
  #16 = Utf8               LocalVariableTable
  #17 = Utf8               this
  #18 = Utf8               Lorg/se/lab/DataTypes;
  #19 = Utf8               primitiveTypes
  #20 = Utf8               i
  #21 = Utf8               I
  #22 = Utf8               j
  #23 = Utf8               l1
  #24 = Utf8               J
  #25 = Utf8               l2
  #26 = Utf8               d
  #27 = Utf8               D
  #28 = Utf8               SourceFile
  #29 = Utf8               DataTypes.java
{
  public org.se.lab.DataTypes();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 3: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lorg/se/lab/DataTypes;

  public void primitiveTypes();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=2, locals=9, args_size=1
         0: bipush        100
         2: istore_1
         3: ldc           #7                  // int 1000000
         5: istore_2
         6: lconst_1
         7: lstore_3
         8: ldc2_w        #8                  // long -1l
        11: lstore        5
        13: ldc2_w        #10                 // double 3.14d
        16: dstore        7
        18: return
      LineNumberTable:
        line 9: 0
        line 10: 3
        line 11: 6
        line 12: 8
        line 13: 13
        line 16: 18
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      19     0  this   Lorg/se/lab/DataTypes;
            3      16     1     i   I
            6      13     2     j   I
            8      11     3    l1   J
           13       6     5    l2   J
           18       1     7     d   D
}
SourceFile: "DataTypes.java"
```

## References

* [Oracle Java Documentation: javap](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javap.html)

* [Baeldung: View Bytecode of a Class File in Java](https://www.baeldung.com/java-class-view-bytecode)

*Egon Teiniker, 2016-2023, GPL v3.0*
