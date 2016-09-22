package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StructTimeTest
{
	private MStruct struct;
	
	/*
	 * struct time 
	 *	{
     *		int hh;
     *		int mm;
     *		int ss;
	 *  };
	 */
	@Before
	public void setup()
	{
		struct = new MStruct("time");
		MType integer = new MType("int");
		MField f0 = new MField("hh", integer);
		MField f1 = new MField("mm", integer);
		MField f2 = new MField("ss", integer);
		struct.getFields().add(f0);
		struct.getFields().add(f1);
		struct.getFields().add(f2);
	}

	
	@Test
	public void testMStruct()
	{
		Assert.assertEquals("time", struct.getName());
		
		Assert.assertEquals("hh", struct.getFields().get(0).getName());
		Assert.assertEquals("int", struct.getFields().get(0).getType().getName());

		Assert.assertEquals("mm", struct.getFields().get(1).getName());
		Assert.assertEquals("int", struct.getFields().get(0).getType().getName());

		Assert.assertEquals("ss", struct.getFields().get(2).getName());
		Assert.assertEquals("int", struct.getFields().get(0).getType().getName());
	}
}
