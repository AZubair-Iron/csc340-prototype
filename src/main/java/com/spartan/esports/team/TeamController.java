package com.spartan.esports.team;


import com.spartan.esports.games.Game;
import com.spartan.esports.games.GameService;
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

    @Autowired
    private GameService gameService;

    /**
     * Get a list of all Teams in the database.
     * http://localhost:8080/teams/all
     *
     * @return a list of Teams  objects.
     */
    @GetMapping("/all")
    //public List<Team> getAllTeams()  return service.getAllTeams(); }
    public String getAllTeams(Model model) {
        model.addAttribute("teamList",service.getAllTeams());
        model.addAttribute("title", "All Teams");
        return "/games/teams";
    }


    /**
     * Get a specific Team by Id.
     * http://localhost:8080/teams/2
     *
     * @param teamId the unique Id for a Team.
     * @return One Team object.
     */
    @GetMapping("/{teamId}")
    public String getOneTeam(@PathVariable int teamId, Model model) {

        model.addAttribute("team", service.getTeamById(teamId));
        model.addAttribute("title", teamId);
        return "team-details";
    }


    /**
     * Get a list of Teams based on their species.
     * http://localhost:8080/teams/name?team="Valorant"
     *
     * @param team the search key.
     * @return A list of Team objects matching the search key.
     */
    @GetMapping("/name")
    public List<Team> getTeamsByName(@RequestParam(name = "team", defaultValue = "Valorant") String team) {
        return service.getTeamByName(team);
    }

    /**
     * Create a new Team entry.
     * http://localhost:8080/teams/new --data '{"name": "sample4", "science_name": "scienceName", "species": "species", "habitat": "habitat", "description": "description"}'
     *
     * @param team the new Team object.
     * @return the updated list of Teams.
     */
    @PostMapping("/new")
    public String addNewTeam(Team team) {
        service.addNewTeam(team);
        return "redirect:/teams/all";
    }

    @GetMapping("/createForm")
    public String showNewTeamForm(Model model) {
        model.addAttribute("gameList", gameService.getAllGames());

        return "new-team-form";
    }

    @PostMapping("/add")
    public String addTeam(@RequestParam String name, @RequestParam Game game, @RequestParam String matchday) {
        Team newTeam = new Team();
        newTeam.setName(name);

        newTeam.setScoreline("0-0");
        newTeam.setMatchDay(matchday);
        newTeam.setGame(game);

        service.addNewTeam(newTeam);
        return "redirect:/games/all"; // Redirect back to the teams list page after saving
    }



    /**
     * Update an existing Team object.getTeamsByHabitat
     * http://localhost:8080/teams/update/2 --data '{"name": "sample4", "scienceName": "scienceName", "species": "species", "habitat": "habitat", "description": "description"}'
     *
     * @param teamId the unique Team Id.
     * @param model
     * @return the updated Team object.
     */
    @GetMapping("/update/{teamId}")
    public String showUpdateFrom(@PathVariable int teamId, Model model) {
        model.addAttribute("team", service.getTeamById(teamId));
        return "team-update.html";
    }

    @PostMapping("/update")
    public String updateTeam(Team team) {
        service.addNewTeam(team);
        return "redirect:/teams/" + team.getTeamId();
    }

    /**
     * Delete a Team object.
     * http://localhost:8080/teams/delete/2
     *
     * @param teamId the unique Team Id.
     * @return the updated list of Team.
     */
    @GetMapping("/delete/{teamId}")
    public String deleteTeamById(@PathVariable int teamId) {
        service.deleteTeamById(teamId);
        return "redirect:/teams/all";
    }


}
