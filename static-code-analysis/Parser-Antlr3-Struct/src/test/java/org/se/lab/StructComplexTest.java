package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 *    struct complex 
 *    {
 *        double re;
 *        double im;
 * 	  };
 */

public class StructComplexTest
{
	private MStruct struct;
	
	@Before
	public void setup()
	{
		MField f1 = new MField("re", new MType("double"));
		MField f2 = new MField("im", new MType("double"));
		
		struct = new MStruct("complex");
		struct.getFields().add(f1);
		struct.getFields().add(f2);
	}

	
	@Test
	public void testMStruct()
	{
		Assert.assertEquals("complex", struct.getName());
		
		Assert.assertEquals("re", struct.getFields().get(0).getName());
		Assert.assertEquals("double", struct.getFields().get(0).getType().getName());

		Assert.assertEquals("im", struct.getFields().get(1).getName());
		Assert.assertEquals("double", struct.getFields().get(0).getType().getName());
	}	
}
