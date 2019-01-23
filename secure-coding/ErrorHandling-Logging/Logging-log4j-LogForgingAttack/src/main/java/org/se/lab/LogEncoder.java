package org.se.lab;

import java.text.Normalizer;
import java.util.stream.Stream;

public class LogEncoder
{
    private LogEncoder() {}

    public static String encode(String message)
    {
        message = Normalizer.normalize(message, Normalizer.Form.NFKC);
        String log = message.replaceAll("[\n\r]", "_");
        return log.toString();
    }
}
