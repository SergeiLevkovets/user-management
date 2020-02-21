package by.levkovets.usermanagement.controllers;

import by.levkovets.usermanagement.domain.Role;
import by.levkovets.usermanagement.domain.UserAccount;
import by.levkovets.usermanagement.dto.UserDTO;
import by.levkovets.usermanagement.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Operations pertaining to user in User Management
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDTO user() {
        return new UserDTO();
    }

    @GetMapping()
    public String showUsers(@RequestParam(required = false, defaultValue = "") String userName,
                            @RequestParam(required = false, defaultValue = "") String role,
                            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable,
                            Model model
    ) {
        model.addAttribute("userName", userName);
        model.addAttribute("role", role);

        if (role.isBlank()) {
            if (!userName.isBlank()) {

                Page<UserAccount> page = userService.filterByUserName(userName, pageable);
                model.addAttribute("page", page);

                return "list";
            }
        } else {
            if (!userName.isBlank()) {

                Page<UserAccount> page = userService.filterByRoleAndUserName(Role.valueOf(role), userName, pageable);
                model.addAttribute("page", page);
                return "list";
            }

            Page<UserAccount> page = userService.filterByRole(Role.valueOf(role), pageable);
            model.addAttribute("page", page);
            return "list";
        }

        Page<UserAccount> page = userService.getAllUsers(pageable);
        model.addAttribute("page", page);

        return "list";
    }

    @GetMapping("/{id}")
    public String showUserDetails(@PathVariable("id") Long id, Model model) {

        UserDTO userDTO = userService.findById(id);
        model.addAttribute("user", userDTO);

        return "view";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}")
    public String changeUserStatus(@PathVariable("id") Long id, UserDTO user, Model model) {

        UserDTO userDTO = userService.findById(id);

        userDTO.setActive(user.isActive());

        userService.saveUser(userDTO);

        model.addAttribute("user", userDTO);

        return "redirect:/user/" + userDTO.getId();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/new")
    public String createUser() {
        return "new";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public String saveUser(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result) {

        UserDTO existing = userService.findByUserName(userDTO.getUserName());

        if (existing != null) {

            result.rejectValue("userName", null, "There is already an user with that username");

        }

        if (result.hasErrors()) {

            return "new";

        }

        userService.saveUser(userDTO);

        return "redirect:/user/" + userDTO.getId();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/edit")
    public String getUpdateUser(@PathVariable("id") Long id, Model model) {

        UserDTO user = userService.findById(id);

        model.addAttribute("user", user);

        return "edit";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/edit")
    public String updateUser(
            @RequestParam(required = false, defaultValue = "") String change,
            @ModelAttribute("user") @Valid UserDTO userDTO,
            BindingResult result,
            Model model) {

        model.addAttribute("change", change);

        UserDTO existing = userService.findByUserName(userDTO.getUserName());

        if (existing != null && !userDTO.getId().equals(existing.getId())) {

            result.rejectValue("userName", null, "There is already an user with that username");

        }

        if (result.hasErrors()) {

            return "edit";

        }

        if (change.isEmpty()){
            UserDTO byId = userService.findById(userDTO.getId());
            userDTO.setPassword(byId.getPassword());
        }

        userService.saveUser(userDTO);

        return "redirect:/user/" + userDTO.getId();
    }


}
