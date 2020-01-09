package org.se.lab.api;

import org.se.lab.impl.German2EnglishTranslator;

public interface TranslatorService
{
    public static TranslatorService create()
    {
        return new German2EnglishTranslator();
    }

    String translate(String msg);
}
