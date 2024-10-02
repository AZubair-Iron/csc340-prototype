package com.csc340.prototype.esports;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@org.springframework.stereotype.Controller
public class APIController {


    @GetMapping("/")
    public String home() {
        return "homepage.html";
    }

    @GetMapping("/Homepage.html")
    public String redirectToExternalUrl() {
        return "redirect:http://localhost:8080/homepage.html";
    }

    @GetMapping("/discussion")
    public String discussion() {
        return "discussion_hub.html";
    }

    @GetMapping("/teams")
    public String teams() {
        return "teams.html";
    }

    @GetMapping("/coaches")
    public String coach() {
        return "coach_hub.html";
    }

}
