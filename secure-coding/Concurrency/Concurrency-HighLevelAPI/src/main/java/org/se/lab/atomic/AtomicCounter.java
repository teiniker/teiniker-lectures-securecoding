package org.se.lab.atomic;

import java.util.concurrent.atomic.AtomicInteger;


/* An AtomicInteger is used in applications such as atomically 
 * incremented counters, and cannot be used as a replacement 
 * for an java.lang.Integer.
 * 
 * See also: AtomicBoolean, AtomicLong, etc.
 */

public class AtomicCounter
{
	private AtomicInteger counter;
	
	
	public AtomicCounter(int startValue)
	{
		counter = new AtomicInteger(startValue);
	}
	
	
	public void increment()
	{
		// Atomically increments by one the current value.
		counter.incrementAndGet();
	}
	
	public void decrement()
	{
		// Atomically decrements by one the current value.
		counter.decrementAndGet();
	}
	
	public int value()
	{
		// Gets the current value.
		return counter.get();
	}
}
