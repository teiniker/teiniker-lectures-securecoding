package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SymmetricCipherStreamTest
{
	private final static String FILE_NAME = "target/secure-data.bin";

	private Cipher cipher;
	private SecretKey key;
	private IvParameterSpec iv;

	@Before
	public void setup() throws NoSuchAlgorithmException, NoSuchPaddingException, DecoderException {
		String keyString = "9a1b447e49d037ad41c11032812eeca1";
		byte[] keyBytes = Hex.decodeHex(keyString.toCharArray());
		key = new SecretKeySpec(keyBytes, "AES");

		String ivString = "f7c317b693e5e60ef152b348e40763a9";
		byte[] ivBytes = Hex.decodeHex(ivString.toCharArray());
		iv = new IvParameterSpec(ivBytes);

		cipher = Cipher.getInstance("AES/CTR/NoPadding");
	}

	@Test
	public void testWriteToFile() throws IOException, InvalidKeyException, InvalidAlgorithmParameterException, DecoderException
	{
		byte[] data = Hex.decodeHex("000102030405060708090a0b0c0d0e0f".toCharArray());

		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		CipherOutputStream out = new CipherOutputStream(new FileOutputStream(new File(FILE_NAME)), cipher);
		out.write(data);
		out.close();

		String dataString = hexDump(FILE_NAME);
		Assert.assertEquals("5281a3d077881bc8b514dfae332d9af2", dataString);
	}

	@Test
	public void testReadFromFile() throws IOException, InvalidKeyException, InvalidAlgorithmParameterException
	{
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		CipherInputStream in = new CipherInputStream(new FileInputStream(new File(FILE_NAME)), cipher);
		byte[] data = in.readAllBytes();
		in.close();

		String dataString = Hex.encodeHexString(data);
		Assert.assertEquals("000102030405060708090a0b0c0d0e0f", dataString);
	}

	private String hexDump(String filename) throws IOException
	{
		FileInputStream fis = new FileInputStream(new File(filename));
		byte[] dataFromFile = fis.readAllBytes();
		fis.close();
		return Hex.encodeHexString(dataFromFile);
	}
}