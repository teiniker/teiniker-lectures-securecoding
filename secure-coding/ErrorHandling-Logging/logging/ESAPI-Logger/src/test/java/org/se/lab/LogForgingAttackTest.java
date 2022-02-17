package org.se.lab;

import org.junit.Test;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;

/*
 * ESAPI Logger also ensures that log forging attacks are prevented by replacing 
 * all CR and LF characters:
 * 		msg.replace('\n', '_').replace('\r','_');   
 */

public class LogForgingAttackTest
{
	private static final Logger logger = ESAPI.getLogger(LogForgingAttackTest.class); 
	
	@Test
	public void testLogForgingAttack()
	{
		operation("homer");
		operation("bart\n 2099-01-01 00:00:00,000 [main] INFO HACK!!!!");
		operation("lisa");
	}
	
	protected void operation(String name)
	{
		logger.info(Logger.SECURITY_AUDIT, "Parameter:" + name);
	}
}
