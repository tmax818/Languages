package tylermaxwell.languages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import tylermaxwell.languages.models.Language;

@Controller
public class LanguageController {

    @GetMapping("/")
    public String index(){
        return "redirect:/languages";
    }

    @GetMapping("/languages")
    public String languages(@ModelAttribute("language")Language language){
        return "/languages/index.jsp";
    }
}
