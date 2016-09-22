package org.se.lab;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ParallelBase64EncoderTest
{

	@Test
	public void testParallelEncoder()
	{
		List<String> fileNameList = Arrays.asList(
			"pictures/linux1","pictures/linux2","pictures/linux3","pictures/linux4","pictures/linux5",
			"pictures/gnu1","pictures/gnu2","pictures/gnu3","pictures/gnu4","pictures/gnu5",
			"pictures/java1","pictures/java2","pictures/java3","pictures/java4","pictures/java5"
			);
		
		ParallelBase64Encoder.encode(fileNameList, 3);
	}
}
