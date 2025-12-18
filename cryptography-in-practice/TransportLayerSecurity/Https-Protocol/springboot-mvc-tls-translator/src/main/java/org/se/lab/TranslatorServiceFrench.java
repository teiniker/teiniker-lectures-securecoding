package org.se.lab;

import java.util.HashMap;
import java.util.Map;

public class TranslatorServiceFrench
    implements TranslatorService
{
    private Map<String, String> dictionary;

    public TranslatorServiceFrench()
    {
        dictionary = new HashMap<String, String>();
        dictionary.put("cat", "Chatte");
        dictionary.put("mouse", "Souris");
        dictionary.put("horse", "Cheval");
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
