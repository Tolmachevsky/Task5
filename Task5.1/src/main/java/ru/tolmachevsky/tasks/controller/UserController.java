package ru.tolmachevsky.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tolmachevsky.tasks.model.User;
import ru.tolmachevsky.tasks.service.UserService;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public String getUserInfo(Model model, Principal principal) {
        model.addAttribute("user", userService.findByEmail(principal.getName()));
        return "user_table";
    }

    @GetMapping(path = "/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users_table";
    }

    @GetMapping(path = "/admin/update/{id}")
    public String updateUserForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    @PostMapping(path = "/admin/update")
    public String updateUser(User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping(path = "/admin/delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @GetMapping(path = "/admin/makeAdmin/{id}")
    public String makeAdmin(@PathVariable("id") Integer id) {
        userService.findById(id).makeAdmin();
        User user = userService.findById(id);
        userService.save(user);
        return "redirect:/admin";
    }
}
