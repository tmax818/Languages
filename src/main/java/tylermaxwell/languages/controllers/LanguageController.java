package tylermaxwell.languages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tylermaxwell.languages.models.Language;
import tylermaxwell.languages.services.LanguageService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LanguageController {

    @Autowired
    LanguageService service;

    @GetMapping("/")
    public String index(){
        return "redirect:/languages";
    }

    @GetMapping("/languages")
    public String languages(@ModelAttribute("language")Language language, Model model){
        List<Language> languages = service.allLanguages();
        model.addAttribute("languages", languages);

        return "/languages/index.jsp";
    }

    @PostMapping("/languages")
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model){
        if(result.hasErrors()){
            List<Language> languages = service.allLanguages();
            model.addAttribute("languages", languages);
            return "/languages/index.jsp";
        } else {
            service.createLanguage(language);
            return "redirect:/languages";
        }
    }
}
