package com.spartan.esports.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String getSignUpPage(Model model) {
        model.addAttribute("registerRequest", new User());
        return "sign-up";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user) {
        System.out.println("register request: " + user);
        User registeredUser = userService.registerUser(user.getName(), user.getEmail(), user.getPassword());
        return registeredUser == null ? "error-page" : "redirect:/users/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        System.out.println("login request: " + user);
        User authenticated = userService.authenticate(user.getEmail(), user.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getName());
            return "profile";
        } else {
            return "error-page";
        }
    }
}