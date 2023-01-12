package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.api.TranslatorService;
import org.se.lab.impl.German2EnglishTranslator;

public class German2EnglishTranslatorTest
{
    private TranslatorService service;

    @Before
    public void setup()
    {
        service = new German2EnglishTranslator();
    }

    @Test
    public void testTranslator()
    {
        String dt = "Katze";
        String engl = service.translate(dt);

        Assert.assertEquals("cat", engl);
    }
}
