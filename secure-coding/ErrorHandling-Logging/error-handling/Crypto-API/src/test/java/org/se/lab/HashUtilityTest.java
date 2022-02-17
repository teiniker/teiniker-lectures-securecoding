package org.se.lab;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.channels.IllegalChannelGroupException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;


public class HashUtilityTest
{
	@Test
	public void testSha256AsHexString()
	{
		String message = "Trink4Bier!";

		String hexString = HashUtility.sha256AsHexString(message);
		Assert.assertEquals("7c94780245b83f3ae4457a7da8e873bcccc2e1aa5d4f6ca02392d189050d7217", hexString);
	}

	@Test(expected = IllegalArgumentException.class)
    public void testSha256AsHexStringWithNullPointer()
    {
        HashUtility.sha256AsHexString(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSha256AsHexStringWithEmptyString()
    {
        HashUtility.sha256AsHexString("");
    }


    @Test
    public void testSha256AsBase64String()
    {
        String message = "Trink4Bier!";

        String base64String = HashUtility.sha256AsBase64String(message);
        Assert.assertEquals("fJR4AkW4PzrkRXp9qOhzvMzC4apdT2ygI5LRiQUNchc=", base64String);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSha256AsBase64StringWithNullPointer()
    {
        HashUtility.sha256AsBase64String(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSha256AsBase64StringWithEmptyString()
    {
        HashUtility.sha256AsBase64String("");
    }
}
