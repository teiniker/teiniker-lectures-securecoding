package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParserTest
{
	private MStruct struct;
	
	@Before
	public void setup() throws RecognitionException, IOException
	{
		FileInputStream in = new FileInputStream(new File("src/test/resources/source.c"));
		ANTLRInputStream input = new ANTLRInputStream(in);

		StructLexer lexer = new StructLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		StructParser parser = new StructParser(tokens);

		struct = parser.prog();
	}
	
	
	@Test
	public void testStruct() throws RecognitionException
	{
	
		Assert.assertEquals("Time", struct.getName());

		Assert.assertEquals("hour", struct.getFields().get(0).getName());
		Assert.assertEquals("int", struct.getFields().get(0).getType().getName());

		Assert.assertEquals("minute", struct.getFields().get(1).getName());
		Assert.assertEquals("int", struct.getFields().get(0).getType().getName());

		Assert.assertEquals("second", struct.getFields().get(2).getName());
		Assert.assertEquals("int", struct.getFields().get(0).getType().getName());
	}
	
}
