package org.se.lab;

import java.io.*;
import java.net.Socket;
import java.util.Date;


public class HttpRequestHandler
{
	private final String WEB_DIR;

	public HttpRequestHandler(String webDirectory)
	{
		if(webDirectory == null)
			throw new IllegalArgumentException();
		this.WEB_DIR = webDirectory;
	}


	public void handleRequest(InputStream in, OutputStream out)
	{
	    try
        {
            InputStream input = new BufferedInputStream(in);
            StringBuilder buffer = new StringBuilder();
            while (true)
            {
                int c = input.read();
                if (c == '\r' || c == '\n' || c == -1)
                    break;
                buffer.append((char) c);
            }
            Logger.log("request: " + buffer.toString());

            String[] requestElements = buffer.toString().split(" ");
            if (requestElements[0].equals("GET") && requestElements[2].startsWith("HTTP/1"))
            {
                String html = httpGet(requestElements[1]);
                Writer w = new OutputStreamWriter(out);
                w.write(httpHeader(html.length()));
                w.write(html);
                w.flush();
            }
        }
        catch(IOException e)
        {
            throw new IllegalStateException("File not loaded!", e);
        }
	}

    public String httpGet(String filename)
    {
        File file = new File(WEB_DIR, filename);
        if(file.exists() && file.isFile())
        {
            Logger.log("read: " + file);
            return htmlFile(file);
        }
        else
        {
            Logger.log("file not found: " + file);
            return htmlFile( new File(WEB_DIR, "error404.html"));
        }
    }


    private String htmlFile(File file)
    {
        StringBuilder buffer = new StringBuilder();
        try(BufferedReader in = new BufferedReader(new FileReader(file)))
        {
            String s;
            while ((s = in.readLine()) != null)
            {
                buffer.append(s).append("\n");
            }
            return buffer.toString();
        }
        catch(IOException e)
        {
            throw new IllegalStateException("Can't read file: " + file, e);
        }
    }


    private String httpHeader(int length)
    {
        StringBuilder buffer = new StringBuilder();
        buffer.append("HTTP/1.1 200 OK\r\n");
        buffer.append("Server: Apache-Coyote/1.1\r\n");
        buffer.append("Content-Type: text/html; charset=UTF-8\r\n");
        buffer.append("Content-Length: ").append(length).append("\r\n");
        buffer.append("Date: ").append(timeStamp()).append("\r\n");
        buffer.append("\r\n");
        return buffer.toString();
    }

    private static String timeStamp()
    {
        Date now = new Date();
        return now.toString();
    }
}
