package org.se.lab;

public class HTMLEncoder
{
	public static String encodeForHTML(String s)
	{
		int len = s.length();
		StringBuilder html = new StringBuilder();
		for(int i=0; i<len; i++)
		{
			char c = s.charAt(i);
			String encoding;
			switch(c)
			{
				case '<': encoding = "&lt;"; break;
				case '>': encoding = "&gt;"; break;
				case '&': encoding = "&amp;"; break;
				case '"': encoding = "&quot;"; break;
				default: encoding = String.valueOf(c);
			}
			html.append(encoding);
		}
		return html.toString();
	}
}
