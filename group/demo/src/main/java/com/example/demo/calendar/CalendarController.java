package com.example.demo.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;
    

    @GetMapping("/all")
    public List<Calendar> getAllCalendar() {
        return calendarService.getAllCalendar();
    }

    @GetMapping("/{eventID}")
    public Calendar getOneCalendar(@PathVariable int eventID) {
        return calendarService.getCalendarByID(eventID);
    }

    @GetMapping("/name")
    public List<Calendar> getCalendarByName(@RequestParam(name = "name", defaultValue = "Overwatch") String name) {
        return calendarService.getCalendarByName(name);
    }

    @PostMapping("/new")
    public List<Calendar> addNewCalendar(@RequestBody Calendar calendar) {
        calendarService.addNewCalendar(calendar);
        return calendarService.getAllCalendar();
    }

    @PutMapping("/update/{eventID}")
    public Calendar updateCalendar(@PathVariable int eventID, @RequestBody Calendar calendar) {
        calendarService.updateCalendar(eventID, calendar);
        return calendarService.getCalendarByID(eventID);
    }

    @DeleteMapping("/delete/{eventID}")
    public List<Calendar> deleteCalendarByID(@PathVariable int eventID) {
        calendarService.deleteCalendarByID(eventID);
        return calendarService.getAllCalendar();
    }
}
