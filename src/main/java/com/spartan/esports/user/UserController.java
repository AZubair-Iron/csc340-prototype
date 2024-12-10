package com.spartan.esports.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String getSignUpPage(Model model) {
        model.addAttribute("signupRequest", new User());
        return "signup.html";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login.html";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user) {
        System.out.println("sign up request: " + user);
        User registeredUser = userService.registerUser(user.getName(), user.getEmail(), user.getPassword());
        return registeredUser == null ? "error_page.html" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        System.out.println("login request: " + user);
        User authenticated = userService.authenticate(user.getEmail(), user.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getName());  // ??? 30:43
            return "profile.html";
        } else {
            return "error_page.html";
        }
    }

}