package org.se.lab;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class BinaryFileEncodingAndDecodingTest
{

	@Test
	public void testEncodeFile() throws IOException
	{
		File binaryFile = new File("pictures/linux1.jpg");
		long size = binaryFile.length();

		byte[] binaryData = new byte[(int) size];
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(binaryFile));
		input.read(binaryData);
		input.close();

		String base64String = Base64.encodeBase64String(binaryData);

		File base64File = new File("pictures/linux1.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(base64File));
	    writer.write (base64String);
	    writer.close();
	}

	
	@Test
	public void testDecodeFile() throws IOException
	{
		File base64File = new File("pictures/linux1.txt");
		BufferedReader input = new BufferedReader(new FileReader(base64File));
		String base64String = input.readLine();
		input.close();

		byte[] binaryData = Base64.decodeBase64(base64String);

		File binaryFile = new File("pictures/linux001.jpg");
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(binaryFile));
		output.write(binaryData);
		output.close();
	}
}
