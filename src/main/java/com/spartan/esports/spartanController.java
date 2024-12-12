package com.spartan.esports;


import com.spartan.esports.coaches.CoachService;
import com.spartan.esports.user.User;
import com.spartan.esports.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class spartanController {

    @Autowired
    private CoachService coachService;

    @Autowired
    private UserService userService;

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

    @GetMapping("/admin/view/members")
    public String adminStudents(Model model) {
        List<User> userList = userService.getAllUsers();

        userList.removeIf(user -> !user.getStatus().equals("Student"));

        model.addAttribute("studentList", userList);

        return "view-students";
    }

    @GetMapping("/admin/view/approval")
    public String adminApproval(Model model) {
        List<User> userList = userService.getAllUsers();

        userList.removeIf(user -> !user.getStatus().equals("PENDING"));

        model.addAttribute("approvalList", userList);

        return "view-approval";
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

    @GetMapping("/profile/user")
    public String userProfile() {
        return "profile"; // Replace with the actual view name for the user profile page
    }

    @GetMapping("/calendar/listc")
    public String getTheCalendar() {return "calendar";}

}
