package com.spartan.esports.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;


    @GetMapping("/all")
    public String getAllCalendar(Model model) {
        model.addAttribute("eventList", calendarService.getAllCalendar());
        return "events-list";
    }

    @GetMapping("/{eventID}")
    public String getOneCalendar(@PathVariable int eventID, Model model) {
        model.addAttribute("eventList", calendarService.getCalendarByID(eventID));
        return "calendar-details";
    }

    @GetMapping("/name")
    public List<Calendar> getCalendarByName(@RequestParam(name = "name", defaultValue = "Overwatch") String name) {
        return calendarService.getCalendarByName(name);
    }

    @GetMapping("/calendarForm")
    public String showCalendarForm() {
        return "new-event-form";
    }

    @PostMapping("/new")
    public String addNewCalendar(Calendar calendar) {
        calendarService.addNewCalendar(calendar);
        return "redirect:/calendar/all";
    }


    @GetMapping("/update/{eventID}")
    public String updateCalendarForm(@PathVariable int eventID, Model model) {
        model.addAttribute("calendar", calendarService.getCalendarByID(eventID));
        return "calendar-update";
    }

    @PostMapping("/update")
    public String updateCalendar(Calendar calendar) {
        calendarService.saveCalendar(calendar);
        return "redirect:/calendar/" + calendar.getEventID();
    }

    @GetMapping("/delete/{eventID}")
    public String deleteCalendarByID(@PathVariable int eventID) {
        calendarService.deleteCalendarByID(eventID);
        return "redirect:/calendar/all";
    }
}