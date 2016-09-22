package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;


public class ParserTest
{
	@Test
	public void testParser() throws RecognitionException, IOException
	{
		FileInputStream in = new FileInputStream(new File("src/test/resources/source.c"));
		ANTLRInputStream input = new ANTLRInputStream(in);

		CLexer lexer = new CLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CParser parser = new CParser(tokens);

		parser.translation_unit();
	}
}
