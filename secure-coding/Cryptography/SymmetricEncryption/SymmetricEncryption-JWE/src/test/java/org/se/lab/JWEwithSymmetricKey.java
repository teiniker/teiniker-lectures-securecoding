package org.se.lab;

import java.text.ParseException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.DirectEncrypter;

public class JWEwithSymmetricKey
{
    private byte[] key128;
    
    @Before
    public void setup() throws DecoderException
    {
        key128 = Hex.decodeHex("b177210da41e6c79cf886bf20ce013e2".toCharArray()); 
        System.out.println("Key : " + Hex.encodeHexString(key128));        
    }
    
    @Test
    public void testEncryption() throws JOSEException
    {    	
        // Create the header
        JWEHeader header = new JWEHeader(JWEAlgorithm.DIR, EncryptionMethod.A128GCM);

        // Set the plain text
        Payload payload = new Payload("{\"message\":\"Hello, world!\"}");

        // Create the JWE object and encrypt it
        JWEObject jweObject = new JWEObject(header, payload);
        jweObject.encrypt(new DirectEncrypter(key128));

        // Serialise to compact JOSE form...
        String jweString = jweObject.serialize();

        System.out.println(jweString);
    }

    @Test
    public void testDecryption() throws JOSEException, ParseException
    {
        String jweString = "eyJlbmMiOiJBMTI4R0NNIiwiYWxnIjoiZGlyIn0..0Ff8tNhDqnSzsXDG.RWnsZX6v2JnPEtfuea8h0NGs3rNcDe7wd4Zx.Wo642cKkds8q0S65Fv8mOw";

        // Create the JWE object and encrypt it
        JWEObject jweObject = JWEObject.parse(jweString);

        // Decrypt
        jweObject.decrypt(new DirectDecrypter(key128));

        // Get the plain text
        Payload payload = jweObject.getPayload();
        Assert.assertEquals("{\"message\":\"Hello, world!\"}", payload.toString());
    }
}
