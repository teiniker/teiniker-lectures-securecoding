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
		final int length = binaryData.length;
		
		if(length % 3 != 0)
			throw new IllegalArgumentException("The size of binaryData must be a multiple of 3");
		
		String base64String = "";
		for (int i = 0; i < length; i += 3)
		{
			// Convert three bytes in a 24 bit word
			int word = ((binaryData[i] & 0xff) << 16)
					+ ((binaryData[i + 1] & 0xff) << 8)
					+ (binaryData[i + 2] & 0xff);
	
			// Convert the 24 bit word into four 6 bit values
			// Note that 0x3f = 111111
			base64String = base64String + base64code.charAt((word >> 18) & 0x3f)
					+ base64code.charAt((word >> 12) & 0x3f)
					+ base64code.charAt((word >> 6) & 0x3f)
					+ base64code.charAt(word & 0x3f);
		}
		return base64String;
	}
}
