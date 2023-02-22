package org.se.lab;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/*
 * Simple block cipher modes (such as CBC) generally require only an
 * initialization vector (such as IvParameterSpec),
 * but GCM needs these parameters:
 *  public GCMParameterSpec(int tLen, byte[] src)
 *      src: Initialization Vector (IV)
 *      tLen: length (in bits) of authentication tag T
 *
 * The GCM specification states that tLen may only have the
 * values {128, 120, 112, 104, 96}, or {64, 32} for certain
 * applications.
 *
 * see: http://www.ietf.org/rfc/rfc5116.txt
 */

public class AES256_GCM_Test
{
    private Cipher cipher;
    private SecretKey key;
    private byte[] iv;
    private int GMC_NONCE_LENGTH = 128; // in bits

    @Before
    public void setup()
            throws NoSuchPaddingException, NoSuchAlgorithmException, DecoderException
    {
        cipher = Cipher.getInstance("AES/GCM/NoPadding");
        System.out.println("block size: " + cipher.getBlockSize() + " bytes");

        String keyString = "2de3674335915b62383d7b9ae991a231f69dfd073f5511d0153a92e2df2b74d1";
        byte[] keyBytes =  Hex.decodeHex(keyString.toCharArray());
        key = new SecretKeySpec(keyBytes, "AES");
        System.out.println("key    : " + Hex.encodeHexString(key.getEncoded()));

        iv = new byte[cipher.getBlockSize()];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        System.out.println("Nonce: " + Hex.encodeHexString(iv));
    }


	@Test
	public void testSymmetricCipher()
            throws InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException, InvalidAlgorithmParameterException,
            UnsupportedEncodingException
    {
		String message = "This message should not be read!";
		byte[] plainText = message.getBytes("UTF-8");
		System.out.println("Message: " + Hex.encodeHexString(plainText));

        // Encryption
		cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(GMC_NONCE_LENGTH, iv));
        byte[] cipherText = cipher.doFinal(plainText);
		System.out.println("cipher: " + Hex.encodeHexString(cipherText) + " bytes: " + cipherText.length);

		// Decryption
		cipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(GMC_NONCE_LENGTH, iv));
        byte[] plainText2 = cipher.doFinal(cipherText);
		System.out.println("plain : " + Hex.encodeHexString(plainText2) + " bytes: " + plainText2.length);
	}


	@Test
    public void testGenerateKey() throws NoSuchAlgorithmException
    {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256, new SecureRandom());
        //keyGen.init(256, SecureRandom.getInstanceStrong());
        SecretKey key = keyGen.generateKey();
        System.out.println("key   : " + Hex.encodeHexString(key.getEncoded()) + " bytes: " + key.getEncoded().length);
    }

    @Test
    public void testGenerateKeyFromPassword() throws NoSuchAlgorithmException, InvalidKeySpecException, DecoderException
    {
        String password = "Trink4Bier!";
        String saltString = "7b72f768e4e0ecf9561917d7c113aee9"; // 16 byte random salt
        byte[] salt =  Hex.decodeHex(saltString.toCharArray());

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

        System.out.println("key   : " + Hex.encodeHexString(secretKey.getEncoded()) + " bytes: " + key.getEncoded().length);
    }
}
