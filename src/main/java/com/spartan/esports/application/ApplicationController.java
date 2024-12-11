package com.spartan.esports.application;


import com.spartan.esports.games.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private GameService gameService;

    @GetMapping("/all")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{user_id}")
    public Application getOneApplication(@PathVariable int user_id) {
        return applicationService.getApplicationByID(user_id);
    }

    @GetMapping("/name")
    public List<Application> getApplicationByCoach(@RequestParam(name = "coach", defaultValue = "Coach") String coach) {
        return applicationService.getApplicationByCoach(coach);
    }

    @GetMapping("/create")
    public String enterNewForm(Model model) {
        model.addAttribute("application", new Application());
        model.addAttribute("gameList", gameService.getAllGames());
        return "/coach/coach_application";
    }

    @PostMapping("/new")
    public String addNewApplication(Application application) {
        applicationService.addNewApplication(application);
        return "redirect:/coach/all";
    }

    @PutMapping("/update/{user_id}")
    public Application updateApplication(@PathVariable int user_id, @RequestBody Application application) {
        applicationService.updateApplication(user_id, application);
        return applicationService.getApplicationByID(user_id);
    }

    @DeleteMapping("/delete/{user_id}")
    public List<Application> deleteApplicationByID(@PathVariable int user_id) {
        applicationService.deleteApplicationByID(user_id);
        return applicationService.getAllApplications();
    }
}
