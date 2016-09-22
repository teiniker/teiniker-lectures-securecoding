package org.se.lab;

import org.junit.Before;
import org.junit.Test;

public class ValidatorTest
{
	private MStruct struct;
	private Validator validator;
	
	
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
		
		validator = new Validator();
	}

	@Test
	public void testValidate()
	{
		validator.validate(struct);
	}

	
	@Test(expected = ValidatorException.class)
	public void testValidateStruct_NameIsNull()
	{
		struct.setName(null);
		validator.validate(struct);
	}

	@Test(expected = ValidatorException.class)
	public void testValidateStruct_NameIsKeyword()
	{
		struct.setName("struct");
		validator.validate(struct);
	}
	
	@Test(expected = ValidatorException.class)
	public void testValidateStruct_FieldsIsNull()
	{
		struct.setFields(null);
		validator.validate(struct);
	}
	
	@Test(expected = ValidatorException.class)
	public void testValidateStruct_EmptyFieldList()
	{
		struct.getFields().clear();
		validator.validate(struct);
	}
	

	@Test(expected = ValidatorException.class)
	public void testValidateField_NameIsNull()
	{
		struct.getFields().get(0).setName(null);
		validator.validate(struct);
	}

	@Test(expected = ValidatorException.class)
	public void testValidateField_NameIsKeyword()
	{
		struct.getFields().get(0).setName("struct");
		validator.validate(struct);
	}

	@Test(expected = ValidatorException.class)
	public void testValidateField_TypeIsNull()
	{
		struct.getFields().get(0).setType(null);
		validator.validate(struct);
	}

	
	@Test(expected = ValidatorException.class)
	public void testValidateType_NameIsNull()
	{
		struct.getFields().get(0).getType().setName(null);
		validator.validate(struct);
	}	
}
