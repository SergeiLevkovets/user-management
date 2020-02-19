package by.levkovets.usermanagement.controllers;

import by.levkovets.usermanagement.damain.UserAccount;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping({"/", "/index"})
    public String root(Authentication authentication) {
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
        }
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

}
