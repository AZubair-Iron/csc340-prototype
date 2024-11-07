package com.spartan.esports.team;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
        @Autowired
        private TeamService service;

    /**
     *
     *
     */
    @GetMapping("/all")
    public List<Team> getAllTeams() {
        return service.getAllTeams();
    }

    @GetMapping("/{teamId}")
    public Team GetTeam(@PathVariable int teamId) {
        return service.getTeamById(teamId);
    }

    @GetMapping("/name")
    public List<Team> getTeamByName(@RequestParam(name = "name", defaultValue = "Varsity") String name) {
        return service.getTeamByName(name);
    }

    @GetMapping("/game")
    public List<Team> getTeamByGame(@RequestParam(name = "game", defaultValue = "Valorant") String game) {
        return service.getTeamByGame(game);
    }

    @PostMapping("/new")
    public List<Team> addNewTeam(@RequestBody Team team){
        service.addNewTeam(team);
        return service.getAllTeams();
    }

    @PutMapping("/update/{teamId}")
    public Team updateTeam(@PathVariable int teamId, @RequestBody Team team) {
        service.updateTeam(teamId, team);
        return service.getTeamById(teamId);
    }

    @DeleteMapping("/delete/{teamId}")
    public List<Team> deleteTeamById(@PathVariable int teamId) {
        service.deleteTeamById(teamId);
        return service.getAllTeams();
    }

}
