package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.Assert;
import org.junit.Test;


public class ParseTreeTest
{
	@Test
	public void testParser() throws RecognitionException, IOException, org.antlr.runtime.RecognitionException
	{
		FileInputStream in = new FileInputStream(new File("src/test/resources/user.xml"));
		ANTLRInputStream input = new ANTLRInputStream(in);
		XmlLexer lexer = new XmlLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		XmlParser parser = new XmlParser(tokens);
		parser.xml();
		
		int errors = parser.getNumberOfSyntaxErrors();
		System.out.println("number of syntax errors: " + errors);
		Assert.assertEquals(0, errors);
	}
}
