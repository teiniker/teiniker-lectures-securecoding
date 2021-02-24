package org.se.lab;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptedFile
{
    private final Cipher cipher;
    private final SecretKey key;
    private final IvParameterSpec iv;

    public EncryptedFile(String keyString, String ivString)
    {
        if(keyString == null || keyString.length() != 32)
            throw new IllegalArgumentException("Invalid key string!");

        if(ivString == null || ivString.length() != 32)
            throw new IllegalArgumentException("Invalid init vector string!");

        try
        {
            cipher = Cipher.getInstance("AES/CTR/NoPadding");
            byte[] keyBytes;
            keyBytes = Hex.decodeHex(keyString.toCharArray());
            key = new SecretKeySpec(keyBytes, "AES");

            byte[] ivBytes = Hex.decodeHex(ivString.toCharArray());
            iv = new IvParameterSpec(ivBytes);
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException | DecoderException e)
        {
            throw new IllegalStateException("Can't initilaize EncryptedFile object!", e);
        }
    }

    public void saveEncrypted(String filename, byte[] data)
    {
        if(filename == null)
            throw new IllegalArgumentException("Invalid filename");

        if(data == null)
            throw new IllegalArgumentException("Invalid data!");

        try
        {
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] cipherText = cipher.doFinal(data);
            save(filename, cipherText);
        }
        catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | InvalidAlgorithmParameterException e)
        {
            throw new IllegalStateException("Unable to encrypt data!", e);
        }
    }

    public byte[] loadEncrypted(String filename)
    {
        if(filename == null)
            throw new IllegalArgumentException("Invalid filename!");

        try
        {
            byte[] data = load(filename);
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            return cipher.doFinal(data);
        }
        catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e)
        {
            throw new IllegalStateException("Unable to decrypt data!", e);
        }
    }

    protected void save(String filename, byte[] data)
    {
        try(FileOutputStream fos = new FileOutputStream(new File(filename)))
        {
            fos.write(data);
        }
        catch(IOException e)
        {
            throw new IllegalStateException("Unable to save file: " + filename, e);
        }
    }

    protected byte[] load(String filename)
    {
        try(FileInputStream fis = new FileInputStream(new File(filename)))
        {
            return fis.readAllBytes();
        }
        catch (IOException e)
        {
            throw new IllegalStateException("Unable read file: " + filename,e);
        }
    }
}
