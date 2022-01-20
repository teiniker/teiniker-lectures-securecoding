package org.se.lab;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

/*
 * The class Hex converts hexadecimal Strings.
 */

public class HexTest
{
	@Test
	public void testBinaryDataToHexString()
	{
		byte[] binaryData = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15	};
	
		String hexString = Hex.encodeHexString(binaryData);
		Assert.assertEquals("000102030405060708090a0b0c0d0e0f", hexString);
	}

	@Test
	public void testHexStringToBinaryData() throws DecoderException
	{
		String hexString = "000102030405060708090a0b0c0d0e0f";
		
				
		byte [] binaryData = Hex.decodeHex(hexString.toCharArray());
		
		final byte[] EXPECTED = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15	};
		Assert.assertArrayEquals(EXPECTED, binaryData);
	}
}
