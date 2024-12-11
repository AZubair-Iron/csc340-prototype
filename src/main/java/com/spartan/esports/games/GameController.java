package com.spartan.esports.games;


import com.spartan.esports.team.Team;
import com.spartan.esports.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService service;

    @Autowired
    private TeamService teamService;


    /**
     * Get a list of all Games in the database.
     * http://localhost:8080/games/all
     *
     * @return a list of Games  objects.
     */
    @GetMapping("/all")
    //public List<Game> getAllGames()  return service.getAllGames(); }
    public String getAllGames(Model model) {
        model.addAttribute("gameList",service.getAllGames());
        model.addAttribute("title", "All Games");
        return "/games/games-teams";
    }


    /**
     * Get a specific Game by Id.
     * http://localhost:8080/games/2
     *
     * @param gameId the unique Id for a Game.
     * @return One Game object.
     */
    @GetMapping("/teams/{gameId}")
    public String getOneGame(@PathVariable int gameId, Model model) {
        var game = service.getGameById(gameId);
        model.addAttribute("game", game);

        List<Team> team = teamService.getAllTeams();

        team.removeIf(t -> t.getGame().getGameId() != gameId);


        model.addAttribute("teamList", team);
        model.addAttribute("gameId", gameId);
        return "/games/teams";
    }




    /**
     * Get a list of Games based on their species.
     * http://localhost:8080/games/name?game="Valorant"
     *
     * @param game the search key.
     * @return A list of Game objects matching the search key.
     */
    @GetMapping("/name")
    public List<Game> getGamesByName(@RequestParam(name = "game", defaultValue = "Valorant") String game) {
        return service.getGameByName(game);
    }

    /**
     * Create a new Game entry.
     * http://localhost:8080/games/new --data '{"name": "sample4", "science_name": "scienceName", "species": "species", "habitat": "habitat", "description": "description"}'
     *
     * @param game the new Game object.
     * @return the updated list of Games.
     */
    @PostMapping("/new")
    public String addNewGame(Game game) {
        service.addNewGame(game);
        return "redirect:/games/all";
    }

    @PostMapping("/add")
    public String addGame(@RequestParam String game, @RequestParam String gameIcon) {
        Game newGame = new Game();
        newGame.setGame(game);
        newGame.setGameIcon(gameIcon);
        service.addNewGame(newGame);
        return "redirect:/games/all"; // Redirect back to the games list page after saving
    }



    /**
     * Update an existing Game object.getGamesByHabitat
     * http://localhost:8080/games/update/2 --data '{"name": "sample4", "scienceName": "scienceName", "species": "species", "habitat": "habitat", "description": "description"}'
     *
     * @param gameId the unique Game Id.
     * @param model
     * @return the updated Game object.
     */
    @GetMapping("/update/{gameId}")
    public String showUpdateFrom(@PathVariable int gameId, Model model) {
        model.addAttribute("game", service.getGameById(gameId));
        return "game-update.html";
    }

    @PostMapping("/update")
    public String updateGame(Game game) {
        service.addNewGame(game);
        return "redirect:/games/" + game.getGameId();
    }

    /**
     * Delete a Game object.
     * http://localhost:8080/games/delete/2
     *
     * @param gameId the unique Game Id.
     * @return the updated list of Game.
     */
    @GetMapping("/delete/{gameId}")
    public String deleteGameById(@PathVariable int gameId) {
        service.deleteGameById(gameId);
        return "redirect:/games/all";
    }

}
