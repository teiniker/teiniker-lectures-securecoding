package org.se.lab;


/*
 * Example: 3 Bytes -> 4 Characters
 * 
 * Bytes:
 * 	0x1A       0xCF       0xD2
 *  0001 1010  1100 1111  1101 0010
 *   
 * 6 bit Values:
 *  000110  101100  111111  010010
 *  0x06    0x2C    0x3F    0x12
 *  G       s       /       S 
 */

public class Base64
{
	private static final String base64code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

	private Base64() {}
	
	public static String toBase64String(byte[] binaryData)
	{
		// TODO
	}
}
