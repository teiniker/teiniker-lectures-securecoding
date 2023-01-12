package org.se.lab.impl;

import org.se.lab.api.TranslatorService;

import java.util.Map;

public class German2EnglishTranslator
    implements TranslatorService
{

    private Map<String, String> table = Map.of("Hund", "dog", "Katze", "cat", "Pferd", "hors", "Maus", "mouse");


    @Override
    public String translate(String msg)
    {
        if(msg == null && msg.isEmpty())
            throw new IllegalArgumentException("Invalid word!");

        if(table.containsKey(msg))
        {
            return table.get(msg);
        }
        else
            return "unknown";
    }
}
