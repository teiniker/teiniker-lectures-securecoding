package org.se.lab;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;

public class ASMDumpTest
{
	private final String CLASSPATH = "target/classes/org/se/lab/";
	private final String FILE_NAME = "Hello.class";

	@Test
	public void testDump() throws Exception
	{
		final byte[] BYTE_CODE = HelloDump.dump(); 
		
		DataOutputStream dout=new DataOutputStream(new FileOutputStream( new File(CLASSPATH, FILE_NAME)));
		dout.write(BYTE_CODE);
		dout.flush();
		dout.close();			
	}
}
