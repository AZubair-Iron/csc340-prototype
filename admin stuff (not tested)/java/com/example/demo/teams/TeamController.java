package com.example.demo.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService service;

    /**
     *
     *
     */
    @GetMapping("/all")
    public String getAllTeams(Model model) {
        model.addAttribute("teamList", service.getAllTeams());
        return "view-teams";
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

    @GetMapping("/createForm")
    public String showNewTeamForm() {
        return "new-team-form";
    }

    @PostMapping("/new")
    public String addNewTeam(Team team){
        service.addNewTeam(team);
        return "redirect:/teams/all";
    }

    @PostMapping("/update")
    public String updateTeam(Team team) {
        service.saveTeam(team);
        return "redirect:/teams/all";
    }

    @GetMapping("/update/{teamId}")
    public String updateTeamForm(@PathVariable int teamId, Model model) {
        model.addAttribute("team", service.getTeamById(teamId));
        return "teams-update";
    }

    @GetMapping("/delete/{teamId}")
    public String deleteTeamById(@PathVariable int teamId) {
        service.deleteTeamById(teamId);
        return "redirect:/teams/all";
    }

}