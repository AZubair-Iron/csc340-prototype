package com.example.demo.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/all")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{user_id}")
    public Application getOneApplication(@PathVariable int user_id) {
        return applicationService.getApplicationByID(user_id);
    }

    @GetMapping("/game")
    public List<Application> getApplicationByGame(@RequestParam(name = "game", defaultValue = "Overwatch") String game) {
        return applicationService.getApplicationByGame(game);
    }

    @GetMapping("/name")
    public List<Application> getApplicationByCoach(@RequestParam(name = "coach", defaultValue = "Coach") String coach) {
        return applicationService.getApplicationByCoach(coach);
    }

    @PostMapping("/new")
    public List<Application> addNewApplication(@RequestBody Application application) {
        applicationService.addNewApplication(application);
        return applicationService.getAllApplications();
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
