package org.se.lab;

import java.security.SecureRandom;
import java.text.ParseException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class JWT_HMACProtectedTest
{
	private static final String hmacKey = "13f266e39f09361ee11dc862ffc2a6571b582a2e97bf62ec2ee8873507f8ecd8";
	
	@Test
	public void testRandomKey()
	{
		byte[] sharedKey = new byte[32];
		new SecureRandom().nextBytes(sharedKey);
		System.out.println(Hex.encodeHexString(sharedKey));
	}
	
	
	@Test
	public void testProducer() throws JOSEException, DecoderException
	{
		// Create Payload
		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				.subject("teini")
				//.expirationTime(new Date(new Date().getTime() + 60 * 1000))
				.build();
		
		JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
		SignedJWT signedJWT = new SignedJWT(header , claimsSet);
		
		// Sign JWT using a HMAC
		byte[] privateKey = Hex.decodeHex(hmacKey.toCharArray());
		JWSSigner signer = new MACSigner(privateKey); 
		signedJWT.sign(signer);
		
		// toString
		String jwt = signedJWT.serialize();

		Assert.assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZWluaSJ9.yB3aNe-WLS8LKlWsm7tZpf5ioIii7nb8SN3BlYOeMHQ", jwt);
	}
	
	@Test
	public void testConsumer() throws ParseException, JOSEException, DecoderException
	{
		// Parse JWT
		String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZWluaSJ9.yB3aNe-WLS8LKlWsm7tZpf5ioIii7nb8SN3BlYOeMHQ";
		SignedJWT signedJWT = SignedJWT.parse(jwt);
		
		// Validate signature
		byte[] privateKey = Hex.decodeHex(hmacKey.toCharArray());
		JWSVerifier verifier = new MACVerifier(privateKey);
		Assert.assertTrue(signedJWT.verify(verifier));
		
		Assert.assertEquals("teini", signedJWT.getJWTClaimsSet().getSubject());
	}	
}
