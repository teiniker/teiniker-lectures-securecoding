package org.se.lab;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class EncryptedFile
{
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private Cipher cipher;

    public EncryptedFile(String publicKeyString, String privateKeyString)
    {
        if(publicKeyString == null)
            throw new IllegalArgumentException("Invalid public key string!");

        if(privateKeyString == null)
            throw new IllegalArgumentException("Invalid private key string!");

        try
        {
            byte[] publicKeyBytes =  Hex.decodeHex(publicKeyString.toCharArray());
            byte[] privateKeyBytes =  Hex.decodeHex(privateKeyString.toCharArray());
            KeyFactory factory = KeyFactory.getInstance("RSA");
            privateKey = factory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
            publicKey = factory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
            cipher = Cipher.getInstance("RSA");
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException | DecoderException | NoSuchPaddingException e)
        {
            throw new IllegalStateException("Can't initialize EncryptedFile object!", e);
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
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] cipherText = cipher.doFinal(data);
            save(filename, cipherText);
        }
        catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e)
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
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] plain = cipher.doFinal(data);
            return plain;
        }
        catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e)
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
