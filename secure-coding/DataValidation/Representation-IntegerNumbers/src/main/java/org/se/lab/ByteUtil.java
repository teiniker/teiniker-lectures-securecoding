package org.se.lab;

public final class ByteUtil
{
	private ByteUtil() {}
	
	/*
	 * Casting an int value to a byte takes the lower 8 bits
	 * of the int and interprets them as a signed 8 bit value
	 * in the range of [-128,127]. 
	 */
	public static  byte toByte(int i)
	{
		return (byte)i;
	}
	
	
	/*
	 * Casting byte to int puts the 8 bits of the byte value into the  
	 * lower 8 bits of the integer value. 
	 * By cutting of the other bytes we ensure that only these 8 bits 
	 * are interpreted as a positive value.
	 */
	public static  int toInt(byte b)
	{
		return (int)b & 0xff;
	}

	
	/*
	 * Convert a byte into a 8 bit unsigned int string.
	 */
	public static String toHexString(byte b)
	{
		int i = toInt(b);
		return String.format("%02x", i);
	}
	
	public static String toHexString(byte[] bytes)
	{
		StringBuilder buffer = new StringBuilder();
		for(byte b : bytes)
			buffer.append(toHexString(b));
		return buffer.toString();
	}
	
}
