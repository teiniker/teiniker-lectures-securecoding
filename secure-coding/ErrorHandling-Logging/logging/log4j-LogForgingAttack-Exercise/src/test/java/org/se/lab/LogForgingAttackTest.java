package org.se.lab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private final Logger logger = LogManager.getLogger(LogForgingAttackTest.class);

	@Test
	public void testLogForgingAttack()
	{
		logger.info("bart\n2099-01-01 00:00:00,000 [main] INFO HACK!!!!");
	}

	@Test
	public void testLogEncoder()
	{
        operation("homer");
        operation("bart\r2099-01-01 00:00:00,000 [main] INFO HACK!!!!");
        operation("lisa");
	}


	protected void operation(String name)
	{
		//logger.info("Parameter:" + LogEncoder.encode(name));
	}
}
