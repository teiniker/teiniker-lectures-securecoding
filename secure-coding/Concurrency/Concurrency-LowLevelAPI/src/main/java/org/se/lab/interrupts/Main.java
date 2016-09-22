package org.se.lab.interrupts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		List<Thread> threads = new ArrayList<Thread>();
		
		String line;
		do
		{
			System.out.print("> ");
			line = console.readLine();
			
			if(line.startsWith("sputnik"))
			{
				Thread t = new Thread(new Sputnik(line, 10000));		
				t.start();				
				threads.add(t);
			}
			else if(line.equals("interrupt"))
			{
				for(Thread t : threads)
				{
					t.interrupt();
				}
			}
			else if(line.equals("exit") || line.equals("quit"))
			{
				line = null;				
			}
			
		}while(line != null);				
	}
}
