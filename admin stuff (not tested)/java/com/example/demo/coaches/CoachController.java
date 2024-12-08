package com.example.demo.coaches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/coaches")
public class CoachController {
    @Autowired
    private CoachService service;

    /**
     *
     *
     */
    @GetMapping("/all")
    public String getAllCoaches(Model model) {
        model.addAttribute("coachList", service.getAllCoaches());
        return "view-coaches";
    }

    @GetMapping("/{CoachId}")
    public Coach GetCoach(@PathVariable int CoachId) {
        return service.getCoachById(CoachId);
    }

    @GetMapping("/name")
    public List<Coach> getCoachByName(@RequestParam(name = "name", defaultValue = "Varsity") String name) {
        return service.getCoachByName(name);
    }

    @GetMapping("/game")
    public List<Coach> getCoachByGame(@RequestParam(name = "game", defaultValue = "Valorant") String game) {
        return service.getCoachByGame(game);
    }

    @GetMapping("/rank")
    public List<Coach> getCoachByRank(@RequestParam(name = "rank", defaultValue = "Immortal") String rank) {
        return service.getCoachByRank(rank);
    }

    @PostMapping("/new")
    public List<Coach> addNewCoach(@RequestBody Coach Coach){
        service.addNewCoach(Coach);
        return service.getAllCoaches();
    }

    @PutMapping("/update/{CoachId}")
    public Coach updateCoach(@PathVariable int CoachId, @RequestBody Coach Coach) {
        service.updateCoach(CoachId, Coach);
        return service.getCoachById(CoachId);
    }

    @DeleteMapping("/delete/{CoachId}")
    public List<Coach> deleteCoachById(@PathVariable int CoachId) {
        service.deleteCoachById(CoachId);
        return service.getAllCoaches();
    }

}

