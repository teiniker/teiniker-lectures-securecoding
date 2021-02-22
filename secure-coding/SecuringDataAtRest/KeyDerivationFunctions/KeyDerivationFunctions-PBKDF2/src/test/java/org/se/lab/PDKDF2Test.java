package org.se.lab;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class PDKDF2Test
{
    @Test
    public void testEncodePassword()
            throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        // Password
        String password = "student";
        char[] chars = password.toCharArray();

        // Random salt
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        // Number of iterations
        int iterations = 1024;

        // Key length
        int keyLength = 64 * 8;

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();

        String storedPassword = iterations + ":"
                + Hex.encodeHexString(salt) + ":"
                + Hex.encodeHexString(hash);

        System.out.println(storedPassword);
    }

    @Test
    public void testValidatePassword()
            throws DecoderException, NoSuchAlgorithmException, InvalidKeySpecException
    {
        String password = "student";
        String storedPassword = "1024:d40932a8052a7c56020b2ee4ed30a899:55f32b186be7d663c99127ea8cf40bf24a2b5d1518bd669d40e99562b9552b4c8f0a83c9cd2a4df6130e4acfcabe9b84ab982d3a9e9b8d37d3fd2bbf5d37cef2";

        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = Hex.decodeHex((parts[1].toCharArray()));
        byte[] hash = Hex.decodeHex((parts[2].toCharArray()));

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = factory.generateSecret(spec).getEncoded();

        System.out.println("Stored hash: " + parts[2]);
        System.out.println("Test hash  : " + Hex.encodeHexString(testHash));
        Assert.assertTrue(Arrays.equals(hash, testHash));
    }
}
