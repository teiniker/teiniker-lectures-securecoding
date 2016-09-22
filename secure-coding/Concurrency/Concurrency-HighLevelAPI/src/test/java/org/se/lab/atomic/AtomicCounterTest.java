package org.se.lab.atomic;

import org.junit.Assert;
import org.junit.Test;

public class AtomicCounterTest
{

	@Test
	public void testAtomicCounter()
	{
		AtomicCounter counter = new AtomicCounter(1);
		
		counter.increment();
		counter.increment();
		counter.increment();
		Assert.assertEquals(4, counter.value());
		
		counter.decrement();
		counter.decrement();
		Assert.assertEquals(2, counter.value());
	}

}
