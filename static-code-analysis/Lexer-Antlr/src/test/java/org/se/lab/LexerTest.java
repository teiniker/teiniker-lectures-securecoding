package org.se.lab;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Token;
import org.junit.Test;

public class LexerTest
{
	@Test
	public void testLexer() throws IOException
	{
		FileInputStream in = new FileInputStream(new File("src/test/resources/source.c"));
		ANTLRInputStream input = new ANTLRInputStream(in);
		LexerExample lexer = new LexerExample(input);
		Token token;
		do
		{
			token = lexer.nextToken();
			int column = lexer.getCharPositionInLine();
			int line = lexer.getLine();
			
			System.out.println(line + ":" 
					+ column + " Token [" 
					+ token.getType() + "] : "   
					+ token.getText());
			
		} while (token.getType() != LexerExample.EOF);
	}
}
