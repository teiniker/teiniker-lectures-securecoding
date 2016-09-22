package org.se.lab;

public class AlgorithmMD5Encoder extends Algorithm
{
	protected String modifyElement(String s)
	{
		return MD5Encoder.convertToMD5String(s);
	}
}