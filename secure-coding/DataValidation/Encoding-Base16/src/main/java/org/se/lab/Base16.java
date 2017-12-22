package org.se.lab;


/*
 * Example: 8 Bits -> 2 Characters
 * 
 * Bytes:
 * 	0x1A       0xCF       0xD2
 *  00011010  11001111  1101 0010
 *    
 *  00000001
 *  AND
 *  00001111
 *  -------- 
 *      0001 --> '1'
 *      
 *  00011010    
 *  AND
 *  00001111
 *  -------- 
 *  00001010 --> 'A'
 *   
 * 4 bit Values (left to right):
 *  0001 1010 1100 1111 1101 0010
 *  0x01 0x0A 0xC  0x0F 0x0D 0x02
 *  "1"  "A"  "C"  "F"  "D"  "2"
 */

public class Base16
{
	private static final String BASE_16_ALPHABET = "0123456789ABCDEF";

	private Base16() {}
	
	public static String toBase16String(byte[] binaryData)
	{
		final int length = binaryData.length;
				
		StringBuilder base16String = new StringBuilder();
		for (int i = 0; i < length; i++)
		{
			// Convert one byte into an int value
			int word = (binaryData[i] & 0xff);
	
			// Convert the 8 bit word into two 4 bit values
			base16String.append(BASE_16_ALPHABET.charAt((word >> 4) & 0x0f))
			            .append(BASE_16_ALPHABET.charAt(word & 0x0f));
		}
		return base16String.toString();
	}
}
