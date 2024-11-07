package com.spartan.esports.coaches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachController {
    @Autowired
    private CoachService service;

    /**
     *
     *
     */
    @GetMapping("/all")
    public List<Coach> getAllCoaches() {
        return service.getAllCoaches();
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

