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
	private MOperation op;
	
	@Before
	public void setup() throws RecognitionException, IOException
	{
		FileInputStream in = new FileInputStream(new File("src/test/resources/source.c"));
		ANTLRInputStream input = new ANTLRInputStream(in);
		OperationLexer lexer = new OperationLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		OperationParser parser = new OperationParser(tokens);
		op = parser.prog();
	}
	
   @Test
    public void testVisitor()
    {
        TreeVisitor visitor = new TreeVisitor();
        visitor.visit(op);
    }
	
	@Test
	public void testOperation()
	{
		Assert.assertEquals("pow", op.getName());
		Assert.assertEquals(2, op.getParameters().size());
	}

	
	@Test
	public void testParameter1()
	{
		MParameter p1 = op.getParameters().get(0);
		Assert.assertEquals("base", p1.getName());
		Assert.assertEquals("double", p1.getType().getName());
	}

	
	@Test
	public void testParameter2()
	{
		MParameter p2 = op.getParameters().get(1);
		Assert.assertEquals("exp", p2.getName());
		Assert.assertEquals("double", p2.getType().getName());
	}

}
