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

public class ParserASTTest
{
	private XmlElement xml;
	
	/*
	 * 	<user>
	 * 		<id>7</id>
	 *		<username>homer</username>
	 * 		<password>xxxxxxxxx</password>
	 * 	</user>
	 */
	@Before
	public void setup() throws IOException, RecognitionException
	{
		FileInputStream in = new FileInputStream(new File("src/test/resources/user.xml"));
		ANTLRInputStream input = new ANTLRInputStream(in);
		XmlLexer lexer = new XmlLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		XmlParser parser = new XmlParser(tokens);
		xml = parser.xml();
		
		int errors = parser.getNumberOfSyntaxErrors();
		System.out.println("number of syntax errors: " + errors);
		Assert.assertEquals(0, errors);
	}

	@Test
	public void testXmlElement()
	{
		Assert.assertEquals("user", xml.getName());
		Assert.assertEquals(3, xml.getElements().size());
		
		XmlElement id = xml.getElements().get(0);
		Assert.assertEquals("id", id.getName());
		Assert.assertEquals("7", id.getText());
		
		XmlElement username = xml.getElements().get(1);
		Assert.assertEquals("username", username.getName());
		Assert.assertEquals("homer", username.getText());
		
		XmlElement password = xml.getElements().get(2);
		Assert.assertEquals("password", password.getName());
		Assert.assertEquals("xxxxxxxxx", password.getText());		
	}
}


