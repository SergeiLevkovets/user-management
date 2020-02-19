package by.levkovets.usermanagement.controllers;

import by.levkovets.usermanagement.damain.UserAccount;
import by.levkovets.usermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserAccount user(){
     return new UserAccount();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserAccount user,
                                      BindingResult result){

        UserAccount existing = userService.findByUserName(user.getUsername());
        if (existing != null){
            result.rejectValue("username", null, "There is already an account registered with that username");
        }
        if (user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())){
            result.rejectValue("confirmPassword", null,"Password are different!");
        }

        if (result.hasErrors()){
            return "registration";
        }

        userService.registerUser(user);

        return "redirect:/registration?success";
    }

    /*@PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid User user,
                                      BindingResult bindingResult, Model model){

        User existing = (User) userService.loadUserByUsername(user.getUsername());
        if (existing != null){
            bindingResult.rejectValue("username", null, "There is already an account registered with that username");
        }
        if (user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())){
            model.addAttribute("passwordError", "Password are different!");
        }
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            return "registration";
        }
        if (userService.addUser(user)){
            model.addAttribute("userNameError", "User exist");
            return "registration";
        }

        userService.addUser(user);
        return "redirect:/registration?success";
    }*/

}
