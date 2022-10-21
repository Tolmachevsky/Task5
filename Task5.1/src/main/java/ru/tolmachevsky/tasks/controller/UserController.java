package ru.tolmachevsky.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tolmachevsky.tasks.service.UserService;

import javax.servlet.http.HttpServletRequest;
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

}