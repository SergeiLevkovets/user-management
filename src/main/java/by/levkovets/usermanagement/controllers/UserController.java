package by.levkovets.usermanagement.controllers;

import by.levkovets.usermanagement.damain.UserAccount;
import by.levkovets.usermanagement.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserAccount user(){
        return new UserAccount();
    }

    @GetMapping
    public String showUsers(Model model){
        List<UserAccount> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "list";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model){
        UserAccount userAccount = userService.findById(id);
        model.addAttribute("user", userAccount);
        return "view";
    }

    @PostMapping("/{id}")
    public String changeStatus(@PathVariable("id") Long id, UserAccount user, Model model){
        UserAccount userAccount = userService.findById(id);

        userAccount.setActive(user.isActive());

        userService.saveUser(userAccount);

        model.addAttribute("user", userAccount);

        return "view";
    }

    @GetMapping("/new")
    public String createUser(){
        return "new";
    }

    @PostMapping("/new")
    public String saveUser(@ModelAttribute("user") @Valid UserAccount userAccount,
                           BindingResult result){


        if (userAccount.getId() == null) {
            UserAccount existing = userService.findByUserName(userAccount.getUsername());
            if (existing != null){
                result.rejectValue("userName", null, "There is already an user with that username");
            }
        }

        if (result.hasErrors()){
            return "new";
        }

        userService.saveUser(userAccount);

        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String updateUser(@PathVariable("id") UserAccount user, Model model){

        model.addAttribute("user", user);

        return "new";
    }






}
