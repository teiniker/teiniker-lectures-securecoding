package org.se.lab;

import java.util.stream.Stream;

public class LogEncoder
{
    private LogEncoder() {}

    public static String encode(String message)
    {
        String log = message.replaceAll("[\n\r]", "_");
        return log.toString();
    }
}
