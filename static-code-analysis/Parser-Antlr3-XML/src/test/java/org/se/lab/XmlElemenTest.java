package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XmlElemenTest
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
	public void setup()
	{
		xml = new XmlElement("user");		
		xml.addElement(new XmlElement("id","7"));
		xml.addElement(new XmlElement("username", "homer"));
		xml.addElement(new XmlElement("password","xxxxxxxxx"));
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


