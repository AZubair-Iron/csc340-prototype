package com.spartan.esports.schedule;

import com.spartan.esports.coaches.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService service;

    @Autowired
    private CoachService coachService;



    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param scheduleId the unique Id for a Schedule.
     * @return One schedule object.
     */
    @GetMapping("/{scheduleId}")
    public String getOneSchedule(@PathVariable int scheduleId, Model model) {
        model.addAttribute("schedule", service.getScheduleById(scheduleId));
        model.addAttribute("title", scheduleId);
        return "schedule-details";
    }







    @GetMapping("/animal-create")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Schedule());
        return "animal-create";
    }

        @PostMapping("/new")
        public String addNewSchedule(Schedule schedule) {
            service.addNewSchedule(schedule);
            return "redirect:/coach/all";
        }


    @PostMapping("/add")
    public String addNewSchedule(@RequestParam int coachId, @RequestParam LocalDate date, LocalTime startTime, LocalTime endTime) {
        Schedule newSchedule = new Schedule();

        newSchedule.setCoachId(coachService.getCoachById(coachId));
        newSchedule.setDate(date);
        newSchedule.setStartTime(startTime);
        newSchedule.setEndTime(endTime);

        service.addNewSchedule(newSchedule);
        return "redirect:/coach/schedule/view/" + coachId;

    }

    @GetMapping("/update/{scheduleId}")
    public String showUpdateFrom(@PathVariable int scheduleId, Model model) {
        model.addAttribute("schedule", service.getScheduleById(scheduleId));
        return "animal-update.html";
    }

    @PostMapping("/update")
    public String updateUserSchedule(@RequestParam("schedule_id") int scheduleId,
                                     @RequestParam("user_id") int userId) {
        service.updateUserSchedule(scheduleId, userId);
        return "redirect:/coach/" + service.getScheduleById(scheduleId).getCoachId().getCoachId();
    }







    @GetMapping("/delete/{scheduleId}")
    public String deleteAnimalById(@PathVariable int scheduleId) {
        service.deleteScheduleById(scheduleId);
        return "redirect:/coach/all";
    }



}
