package by.levkovets.usermanagement.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/", "/index"})
    public String root() {
        return "home";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

}
