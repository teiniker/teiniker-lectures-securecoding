package org.se.lab.synchronization;

public class UnsafeSequence
{
	private int value;
	
	public int getNext()
	{
		return value++;
	}
}
 
/*  Bytecode instructions for getNext()
 
    public getNext()I
    ALOAD 0
    DUP
    GETFIELD org/se/lab/synchronization/UnsafeSequence.value : I
    DUP_X1
    ICONST_1
    IADD
    PUTFIELD org/se/lab/synchronization/UnsafeSequence.value : I
    IRETURN
    MAXSTACK = 4
    MAXLOCALS = 1
 */

