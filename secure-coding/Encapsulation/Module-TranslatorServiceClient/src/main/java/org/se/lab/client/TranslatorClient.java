package org.se.lab.client;

import org.se.lab.api.TranslatorService;


public class TranslatorClient
{
    private static final TranslatorService service = TranslatorService.create();

    public static void main(String... args)
    {
        String word = "Katze";
        String engl = service.translate(word);
        System.out.println(word + " -> " + engl);
    }
}
