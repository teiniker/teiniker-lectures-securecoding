package org.se.lab;

import org.apache.log4j.Logger;
import org.junit.Test;


/*
 * The integrity of log files is very important because the data in log 
 * files tell us exactly what happened in our system and when.
 * 
 * Log forging vulnerabilities allow an attacker to insert arbitrary log
 * file entries into your server logs and corrupt the integrity of log
 * records.
 */

public class LogForgingAttackTest
{
	private final Logger logger = Logger.getLogger(LogForgingAttackTest.class);

	@Test
	public void testLogForging()
	{
		aMethod("homer");
		aMethod("bart\n 2099-01-01 00:00:00,000 [main] INFO HACK!!!!"); 
		aMethod("lisa");
	}
	
	protected void aMethod(String name)
	{
		logger.info("Parameter name = " + name);
	}
}
