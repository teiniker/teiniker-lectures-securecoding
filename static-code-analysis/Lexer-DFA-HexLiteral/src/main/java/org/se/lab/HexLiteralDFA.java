package org.se.lab;


public class HexLiteralDFA 
{
	private enum STATE {S1, S2, S3, S4};
	private STATE state = STATE.S1; // start state
		
	public boolean isAccepted(String s)
	{
		for(int i=0; i<s.length(); i++)
	        processSymbol(s.charAt(i));     
	   
	    if(state == STATE.S4)
	    {
	    	state = STATE.S1;
	    	return true;
	    }
	    else
	    {
	        return false;
	    }
	}
	
	
	private void processSymbol(char c)
	{

	    switch(state)
	    {
	        case S1:
	            switch(c)
	            {
	                case '0':
	                	state = STATE.S2;
	                break;
	                
	                case 'x':
	                case '1':
	                case '2':
	                case '3':
	                case '4':
	                case '5':
	                case '6':
	                case '7':
	                case '8':
	                case '9':
	                case 'a':
	                case 'b':
	                case 'c':
	                case 'd':
	                case 'e':
	                case 'f':
	                	// do nothing
	                break;
	                
	                default:
	                	throw new IllegalArgumentException("Invalid input symbol: " + c);
	            }
	        break;

	        case S2:
	            switch(c)
	            {
	                case 'x':
	                    state = STATE.S3;
	                break;
	                
	                case '0':
	                case '1':
	                case '2':
	                case '3':
	                case '4':
	                case '5':
	                case '6':
	                case '7':
	                case '8':
	                case '9':
	                case 'a':
	                case 'b':
	                case 'c':
	                case 'd':
	                case 'e':
	                case 'f':
	                	state = STATE.S1;
	                break;

	                default:
	                	throw new IllegalArgumentException("Invalid input symbol: " + c);
	            }
	        break;

	        case S3:
	            switch(c)
	            {
	                case '0':
	                case '1':
	                case '2':
	                case '3':
	                case '4':
	                case '5':
	                case '6':
	                case '7':
	                case '8':
	                case '9':
	                case 'a':
	                case 'b':
	                case 'c':
	                case 'd':
	                case 'e':
	                case 'f':
	                	state = STATE.S4;
	                break;
	                
	                case 'x':
	                	state = STATE.S1;
	                break;
	                
	                default:
	                	throw new IllegalArgumentException("Invalid input symbol: " + c);
	            }
	        break; 

	        case S4:
	            switch(c)
	            {
	                case '0':
	                case '1':
	                case '2':
	                case '3':
	                case '4':
	                case '5':
	                case '6':
	                case '7':
	                case '8':
	                case '9':
	                case 'a':
	                case 'b':
	                case 'c':
	                case 'd':
	                case 'e':
	                case 'f':
	                	// do nothing
	                break;
	                
	                case 'x':
	                	state = STATE.S1;
	                break;

	                default:
	                	throw new IllegalArgumentException("Invalid input symbol: " + c);
	            }
	        break; 
	    }		
	}
}
