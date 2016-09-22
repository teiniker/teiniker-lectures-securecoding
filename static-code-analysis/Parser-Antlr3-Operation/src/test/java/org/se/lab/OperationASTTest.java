package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperationASTTest
{
	private MOperation op;
	
	@Before
	public void setup()
	{
		op = new MOperation("pow", new MType("double"));
		
		MParameter p1 = new MParameter("base", new MType("double"));
		MParameter p2 = new MParameter("exp", new MType("double"));
	
		op.getParameters().add(p1);
		op.getParameters().add(p2);
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
	
	
	@Test
	public void testVisitor()
	{
		TreeVisitor visitor = new TreeVisitor();
		visitor.visit(op);
	}
}
