package org.se.lab;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

public class KeyStoreTest
{
    private PrivateKey privateKey;
    private PublicKey publicKey;

    @Test
    public void testReadKeysFromKeyStore()
            throws IOException, KeyStoreException, CertificateException,
            NoSuchAlgorithmException, UnrecoverableEntryException
    {
        InputStream ins = KeyStoreTest.class.getResourceAsStream("/keystore.pfx");

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(ins, "student".toCharArray());   //Keystore password
        KeyStore.PasswordProtection keyPassword =      //Key password
                new KeyStore.PasswordProtection("student".toCharArray());

        KeyStore.PrivateKeyEntry privateKeyEntry =
                (KeyStore.PrivateKeyEntry) keyStore.getEntry("testkey", keyPassword);

        java.security.cert.Certificate cert = keyStore.getCertificate("testkey");
        PublicKey publicKey = cert.getPublicKey();
        PrivateKey privateKey = privateKeyEntry.getPrivateKey();

        System.out.println("private key: " + Hex.encodeHexString(privateKey.getEncoded()));
        System.out.println("public key : " + Hex.encodeHexString(publicKey.getEncoded()));
    }
}
