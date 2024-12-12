package com.spartan.esports;


import com.spartan.esports.application.ApplicationService;
import com.spartan.esports.coaches.CoachService;
import com.spartan.esports.user.User;
import com.spartan.esports.user.UserService;
import com.spartan.esports.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class spartanController {

    @Autowired
    private CoachService coachService;

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationService applicationService;

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

    @GetMapping("/admin/view/coach/approval")
    public String adminApplications(Model model) {
        List<Application> applicationList = applicationService.getAllApplications();

        applicationList.removeIf(user -> !user.getStatus().equals("PENDING"));

        model.addAttribute("approvalList", applicationList);

        return "view-coach-approval";
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

    @PostMapping("/admin/view/users/approve")
    public String approveUser(@RequestParam Integer userId) {
        userService.updateUserStatus(userId, "Student");

        return "redirect:/admin/view/members";
    }

    @PostMapping("/admin/view/users/decline")
    public String declineUser(@RequestParam Integer userId) {
        userService.deleteUserById(userId);

        return "redirect:/admin/view/approval";
    }

    @GetMapping("/coaches/coachForm")
    public String coachForm() {
        return "new-coach";
    }

}
