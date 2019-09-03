package org.se.lab;

import org.junit.Assert;
import org.junit.Test;
import static org.se.lab.ByteUtil.*;

public class ByteUtilTest
{
	@Test
	public void testIntegerToByte()
	{
		byte b1 = toByte(0xff);
		Assert.assertEquals(-1, b1);
		// int:  0000 0000 1111 1111 = 0x00ff = 255
		// byte:           1111 1111 = 0xff = -1
				
		byte b2 = toByte(0x1234);
		Assert.assertEquals(52, b2);
		// int:  0001 0010 0011 0100 = 0x1234
		// byte:           0011 0100 = 0x34 = 52
	}
	
	@Test
	public void testByteToInteger()
	{
		byte b = toByte(0xce);
		System.out.println(b + " , " + toInt(b));
		Assert.assertEquals(0xce, toInt(b));
		
		// byte:           1100 1110
		// int:  1111 1111 1100 1110 = 0xffce = -52
		//       0000 0000 1111 1111 & 0xff              
		//       -----------------
		//                 1100 1110 = 0xce = 206
		
		byte b2 = toByte(0x17);
		System.out.println(b2 + " , " + toInt(b2));
		Assert.assertEquals(0x17, toInt(b2));
		
		// byte:           0001 0111 = 0x17 = 23
		// int:  0000 0000 0001 0111 = 0x17 = 23
		//       0000 0000 1111 1111 & 0xff
		//       -------------------
		//                 0001 0111 = 0x17 = 23
	}

	
	@Test
	public void testByteToHexString_Byte()
	{
		byte b = toByte(0xab);
		
		Assert.assertEquals("ab", toHexString(b));
	}
	
	@Test
	public void testByteToHexString_ByteArray()
	{
		byte[] b = {
			toByte(0xaa), toByte(0xbb), toByte(0xcc), toByte(0xdd), 
			toByte(0xee), toByte(0xff), toByte(0x11), toByte(0x22)
		};
		
		Assert.assertEquals("aabbccddeeff1122", toHexString(b));
	}
	
}
