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
    public String GetCoach(@PathVariable int CoachId, Model model) {
        model.addAttribute("coach", service.getCoachById(CoachId));
        return "coach-details";
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

    @GetMapping("/coachForm")
    public String coachForm() {return "new-coach";}

    @PostMapping("/new")
    public String addNewCoach(Coach Coach){
        service.addNewCoach(Coach);
        return "redirect:/coaches/all";
    }

    @GetMapping("/update/{CoachId}")
    public String updateCoachForm(@PathVariable int CoachId, Model model) {
        model.addAttribute("coach", service.getCoachById(CoachId));
        return "coach-update";
    }

    @PostMapping("/update")
    public String updateCoach(Coach coach) {
        service.saveCoach(coach);
        return "redirect:/coaches/" + coach.getCoachId();
    }

    @GetMapping("/delete/{CoachId}")
    public String deleteCoachById(@PathVariable int CoachId) {
        service.deleteCoachById(CoachId);
        return "redirect:/coaches/all";
    }

}

