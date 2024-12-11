package com.spartan.esports.coaches;

import com.spartan.esports.games.GameService;
import com.spartan.esports.reviews.Review;
import com.spartan.esports.reviews.ReviewService;
import com.spartan.esports.schedule.Schedule;
import com.spartan.esports.schedule.ScheduleService;
import com.spartan.esports.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/coach")
public class CoachController {
    @Autowired
    private CoachService service;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private GameService gameService;

    /**
     *
     *
     */
    @GetMapping("/all")
    public String getAllCoaches(Model model) {

        List<Coach> coachList = service.getAllCoaches();

        for (Coach value : coachList) { // Loop to get the average rating of the coaches
            int coachId = value.getCoachId();
            Coach coach = service.getCoachById(coachId);
            coach.setRating(service.getAverageRatingForCoach(coachId));
        }

        model.addAttribute("coachList",service.getAllCoaches());



        model.addAttribute("title", "Coaches");
        return "/coach/view_coach";
    }

    @GetMapping("/{coachId}")
    public String getOneGame(@PathVariable int coachId, Model model) {


        Coach coach = service.getCoachById(coachId);
        coach.setRating(service.getAverageRatingForCoach(coachId));

        model.addAttribute("coach", coach);
        model.addAttribute("title", coachId);
        return "/coach/item_coach";
    }

    @GetMapping("/schedule/{coachId}")
    public String getScheduleCoach(@PathVariable int coachId, Model model) {


        List<Schedule> schedules = scheduleService.getAllSchedules();

        schedules.removeIf(t -> t.getCoachId().getCoachId() != coachId);

        schedules.removeIf(t -> {
            Integer userId = t.getUserId() != null ? t.getUserId().getUserId() : null;
            return userId != null; // Remove if userId is not null
        });


        List<LocalDate> uniqueDates = schedules.stream()
                .map(Schedule::getDate)
                .distinct()
                .toList();


        model.addAttribute("coach", service.getCoachById(coachId));
        model.addAttribute("scheduleList", schedules);
        model.addAttribute("uniqueDates", uniqueDates);
        model.addAttribute("title", coachId);
        return "/coach/schedule_coach";
    }

    @GetMapping("/schedule/view/{coachId}")
    public String getCoachSchedule(@PathVariable int coachId, Model model) {
        model.addAttribute("coach", service.getCoachById(coachId));

        List<Schedule> schedules = scheduleService.getAllSchedules();

        schedules.removeIf(t -> t.getCoachId().getCoachId() != coachId);



        model.addAttribute("scheduleList", schedules);
        model.addAttribute("title", service.getCoachById(coachId));
        return "/coach/view_schedule";
    }

    @GetMapping("/review/{coachId}")
    public String getReviewTemplate(@PathVariable int coachId, Model model) {

        Coach coach = service.getCoachById(coachId);

        coach.setRating(service.getAverageRatingForCoach(coachId));

        model.addAttribute("coach", coach);

        List<Review> reviewList = reviewService.getReviewByCoachId(coachId);

        model.addAttribute("reviewList", reviewList);

        model.addAttribute("title", coachId);
        return "/coach/review";

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

    @GetMapping("/edit/{coachId}")
    public String editCoach(@PathVariable int coachId, Model model) {
        model.addAttribute("coach", service.getCoachById(coachId));
        model.addAttribute("gameList", gameService.getAllGames());
        return "/coach/edit_coach";
    }

    @PostMapping("/update")
    public String updateCoach(
            @RequestParam int coachId,
            @RequestParam int game,
            @RequestParam String rank,
            @RequestParam String content) {
        service.updateCoach(coachId, gameService.getGameById(game).getGame(), rank, content);
        return "redirect:/coach/" + coachId;
    }

    @DeleteMapping("/delete/{CoachId}")
    public List<Coach> deleteCoachById(@PathVariable int CoachId) {
        service.deleteCoachById(CoachId);
        return service.getAllCoaches();
    }

}

