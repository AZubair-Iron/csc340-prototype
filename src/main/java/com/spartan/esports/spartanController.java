package com.spartan.esports;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class spartanController {

    @GetMapping("/home")
    public String home() {
        return "homepage";
    }


    @GetMapping("/discussion/home")
    public String discussionHome() {
        return "discussion_hub";
    }

    @GetMapping("/admin/all")
    public String adminSettings() {
        return "adminsettingspass";
    }

    @GetMapping("/admin/students")
    public String adminStudents() {
        return "view-students";
    }

    @GetMapping("/admin/coaches/all")
    public String adminCoaches() {
        return "view-coaches";
    }

    @GetMapping("/admin/teams/all")
    public String adminMembers() {
        return "view-teams";
    }

    @GetMapping("/admin/postList/remove")
    public String adminPost() {
        return "view-post";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/profile/user")
    public String userProfile() {
        return "profile"; // Replace with the actual view name for the user profile page
    }

    @GetMapping("/calendar/listc")
    public String getTheCalendar() {return "calendar";}

}
