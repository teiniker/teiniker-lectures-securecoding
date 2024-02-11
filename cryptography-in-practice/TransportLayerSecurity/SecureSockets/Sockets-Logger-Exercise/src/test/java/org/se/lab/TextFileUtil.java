package org.se.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TextFileUtil
{
	/*
	 * Constructor
	 */
	public TextFileUtil(String filename)
	{
		if(filename == null)
			throw new IllegalArgumentException();
	
		readFile(new File(filename));
	}
	
	
	/*
	 * Property: lines:String[*]
	 */	
	private List<String> lines = new ArrayList<String>();
	
	
	/*
	 * Interface operations
	 */
	
	public int numberOfLines()
	{
		return lines.size();
	}
	
	
	public int length()
	{
		int len = 0;
		for(String s : lines)
			len += s.length();
		return len;	
	}
	
	
	public String getLine(int i)
	{
		if(i < 0)
			throw new IllegalArgumentException();
		return lines.get(i);
	}
	

	public List<String> asList()
	{
		return Collections.unmodifiableList(lines);
	}
	
	
	/*
	 * Helper methods
	 */
	
	private void readFile(File file) 
	{	
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s;
			while((s = in.readLine()) != null)
			{
				lines.add(s);
			}	
			in.close();
		} 
		catch (IOException e)
		{
			throw new IllegalStateException("Text file not loaded");
		}
	}	
}
