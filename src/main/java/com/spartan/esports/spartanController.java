package com.spartan.esports;


import com.spartan.esports.coaches.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class spartanController {

    @Autowired
    private CoachService coachService;

    @GetMapping("/home")
    public String homePage() {
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
    public String adminCoaches(Model model) {
        model.addAttribute("coachList", coachService.getAllCoaches());

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
