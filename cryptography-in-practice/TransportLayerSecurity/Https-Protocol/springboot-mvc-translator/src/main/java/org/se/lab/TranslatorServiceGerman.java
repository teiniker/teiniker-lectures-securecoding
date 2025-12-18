package org.se.lab;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslatorServiceGerman
    implements TranslatorService
{
    private Map<String, String> dictionary;

    public TranslatorServiceGerman()
    {
        dictionary = new HashMap<String, String>();
        dictionary.put("cat", "Katze");
        dictionary.put("mouse", "Maus");
        dictionary.put("horse", "Pferd");
        //...
    }

    public String translate(String word)
    {
        if(dictionary.containsKey(word.toLowerCase()))
            return dictionary.get(word.toLowerCase());
        else
            return "unknown";
    }
}
