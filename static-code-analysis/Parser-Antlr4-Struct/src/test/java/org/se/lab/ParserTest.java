package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;


public class ParserTest
{

	@Test
	public void testParser() throws RecognitionException, IOException
	{
		FileInputStream in = new FileInputStream(new File("src/test/resources/source.c"));
		ANTLRInputStream input = new ANTLRInputStream(in);

		StructLexer lexer = new StructLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		StructParser parser = new StructParser(tokens);
		parser.prog();
	}
}
