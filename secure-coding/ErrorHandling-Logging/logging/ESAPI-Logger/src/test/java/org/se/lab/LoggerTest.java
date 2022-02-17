package org.se.lab;

import org.junit.Test;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;


/*
 * ESAPI Logger utilize log4j or java.util.logging under the covers.
 * 
 * ESAPI Logger also supports the concept of log events. This allows us
 * to generate security specific log entries that can be easily differentiated
 * from non-security related events in our log files.
 * The four predefined event types are:
 * 		SECURITY_SUCCESS
 * 		SECURITY_FAILURE
 * 		EVENT_SUCCESS
 * 		EVENT_FAILURE
 * This is a convenient mechanism as security events such as successful
 * authentication, change password, and sign off are common events that need 
 * to be logged. 
 */

public class LoggerTest
{
	private static final Logger logger = ESAPI.getLogger(LoggerTest.class); 
	
	@Test
	public void testESAPILogger()
	{
		callLoggerMethods();
	}

	// Log levels: trace > debug > info > warning > error > fatal
	protected void callLoggerMethods()
	{		
		logger.trace(Logger.EVENT_SUCCESS, "trace");
		logger.debug(Logger.EVENT_SUCCESS, "debug");
		logger.info(Logger.EVENT_UNSPECIFIED, "info");
		logger.warning(Logger.SECURITY_AUDIT, "warn");
		logger.error(Logger.EVENT_FAILURE, "error");
		logger.fatal(Logger.SECURITY_FAILURE, "fatal");		
		logger.debug(Logger.SECURITY_FAILURE, "debug with exception", new IllegalArgumentException());				
	}
}
