package org.se.lab;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;

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
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;

public class JWEwithAsymmetricKeyRSA
{
	private RSAPublicKey publicKey;
	private RSAPrivateKey privateKey;

	@Before
	public void setup() throws NoSuchAlgorithmException
	{
		KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
		keyGenerator.initialize(4096);

		KeyPair kp = keyGenerator.genKeyPair();
		publicKey = (RSAPublicKey) kp.getPublic();
		privateKey = (RSAPrivateKey) kp.getPrivate();

		System.out.println("Public Key : " + Hex.encodeHexString(publicKey.getEncoded()));
		System.out.println("Private Key: " + Hex.encodeHexString(privateKey.getEncoded()));
	}

	@Test
	public void testEncryption() throws JOSEException, ParseException
	{
		String jweString;
		
		{
			// Create the header
			JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM);

			// Set the plain text
			Payload payload = new Payload("Hello world!");

			// Create the JWE object and encrypt it
			JWEObject jweObject = new JWEObject(header, payload);

			// Create an encrypter with the specified public RSA key
			RSAEncrypter encrypter = new RSAEncrypter(publicKey);
			jweObject.encrypt(encrypter);

			// Serialise to compact JOSE form...
			jweString = jweObject.serialize();
			System.out.println(jweString);
		}

		{
			// Create the JWE object and encrypt it
			JWEObject jweObject = JWEObject.parse(jweString);

			// Create a decrypter with the specified private RSA key
			RSADecrypter decrypter = new RSADecrypter(privateKey);

			// Decrypt
			jweObject.decrypt(decrypter);

			// Get the plain text
			Payload payload = jweObject.getPayload();
			Assert.assertEquals("Hello world!", payload.toString());
		}
	}
}
