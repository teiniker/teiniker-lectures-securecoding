package org.se.lab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslatorController
{
    private TranslatorService service;

    @PostMapping("/translator")
    public String translate(@RequestParam(name="language") String language,
                            @RequestParam(name="word") String word,
                            Model model)
    {
        if("Deutsch".equals(language))
        {
            service = new TranslatorServiceGerman();
        }
        else
        {
            service = new TranslatorServiceFrench();
        }

        String translation = service.translate(word);

        model.addAttribute("word", word);
        model.addAttribute("translation", translation);
        return "translation";
    }
}
