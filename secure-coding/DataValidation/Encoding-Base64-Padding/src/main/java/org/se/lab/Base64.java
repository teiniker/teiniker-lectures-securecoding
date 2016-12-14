package org.se.lab;


public class Base64
{
	private static final String BASE_64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

	private Base64() {}
	
	public static String toBase64String(byte[] binaryData)
	{
		final int length = binaryData.length;
		
		StringBuilder base64String = new StringBuilder();
		int word = 0;
		for (int i = 0; i < length; i += 3)
		{
		    if(i+2 < length) // 3 bytes -> 4 characters
			{
		        word = ((binaryData[i] & 0xff) << 16)
	                    + ((binaryData[i + 1] & 0xff) << 8)
	                    + (binaryData[i + 2] & 0xff);
		          base64String
	                .append(BASE_64_ALPHABET.charAt((word >> 18) & 0x3f))
	                .append(BASE_64_ALPHABET.charAt((word >> 12) & 0x3f))
	                .append(BASE_64_ALPHABET.charAt((word >> 6) & 0x3f))
	                .append(BASE_64_ALPHABET.charAt(word & 0x3f));
			}
		    else if(i+1 < length) // 2 bytes -> 3 characters + "="
            {
                word = ((binaryData[i] & 0xff) << 16)
                        + ((binaryData[i + 1] & 0xff) << 8);
                base64String
                .append(BASE_64_ALPHABET.charAt((word >> 18) & 0x3f))
                .append(BASE_64_ALPHABET.charAt((word >> 12) & 0x3f))
                .append(BASE_64_ALPHABET.charAt((word >> 6) & 0x3f))
                .append('=');   // padding

            }
		    else  // 1 byte -> 2 characters + "=="
            {
                word = ((binaryData[i] & 0xff) << 16);
                base64String
                .append(BASE_64_ALPHABET.charAt((word >> 18) & 0x3f))
                .append(BASE_64_ALPHABET.charAt((word >> 12) & 0x3f))
                .append("==");  // padding
            }
		}
		return base64String.toString();
	}
}
