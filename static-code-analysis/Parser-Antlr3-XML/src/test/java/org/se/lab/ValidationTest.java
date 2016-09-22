package org.se.lab;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ValidationTest
{
	private Map<String, String> constraints;
	
	/*
	 * 	<user>
	 * 		<id>7</id>
	 *		<username>homer</username>
	 * 		<password>xxxxxxxxx</password>
	 * 	</user>
	 */
	@Before
	public void setup()
	{
		// configure constraints 
		// Each element in the Map consists of a key (which is the XML element's name
		// and a value which is a regular expression for the XML element's text.
		constraints = new HashMap<String,String>();
		constraints.put("id", "[1-9][0-9]*");
		constraints.put("username", "[a-zA-Z_]{4,32}");
		constraints.put("password", "[a-zA-Z0-9_!§$%&]{8,32}");		
	}

	
	@Test
	public void testXmlElement()
	{
		XmlElement xml = new XmlElement("user");		
		xml.addElement(new XmlElement("id","7"));
		xml.addElement(new XmlElement("username", "homer"));
		xml.addElement(new XmlElement("password","xxxxxxxxx"));
		xml.check(constraints);	
	}

	@Test(expected=IllegalStateException.class)
	public void testXmlElement_invalidId()
	{
		XmlElement xml = new XmlElement("user");		
		xml.addElement(new XmlElement("id","0x7"));
		xml.addElement(new XmlElement("username", "homer"));
		xml.addElement(new XmlElement("password","xxxxxxxxx"));
		xml.check(constraints);	
	}

	@Test(expected=IllegalStateException.class)
	public void testXmlElement_invalidUsername()
	{
		XmlElement xml = new XmlElement("user");		
		xml.addElement(new XmlElement("id","7"));
		xml.addElement(new XmlElement("username", "hom"));
		xml.addElement(new XmlElement("password","xxxxxxxxx"));
		xml.check(constraints);	
	}
	
	@Test(expected=IllegalStateException.class)
	public void testXmlElement_invalidPassword()
	{
		XmlElement xml = new XmlElement("user");		
		xml.addElement(new XmlElement("id","7"));
		xml.addElement(new XmlElement("username", "homer"));
		xml.addElement(new XmlElement("password","xxx"));
		xml.check(constraints);	
	}	
}


