package org.example.poc.web.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SuppressWarnings("unused")
public class HomeUIController
{
    private static final String HOME_VIEW = "home";

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("title", "Spring Boot + SASS + Handlebars");
        model.addAttribute("text", "This was styled using Compass mixins.");
        return HOME_VIEW;
    }
}
