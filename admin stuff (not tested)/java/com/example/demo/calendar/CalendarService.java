package com.example.demo.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;


    public List<Calendar> getAllCalendar() {return calendarRepository.findAll();}

    public Calendar getCalendarByID(int eventID) {return calendarRepository.findById(eventID).orElse(null);}

    public List<Calendar> getCalendarByName(String name) {return calendarRepository.getCalendarByName(name);}

    public void addNewCalendar(Calendar calendar) {calendarRepository.save(calendar);}

    public void updateCalendar(int eventID, Calendar calendar) {
        Calendar existing = getCalendarByID(eventID);

        existing.setName(calendar.getName());
        existing.setDate(calendar.getDate());
        existing.setLocation(calendar.getLocation());
        existing.setAttending(calendar.getAttending());
        existing.setParticipating(calendar.getParticipating());

        calendarRepository.save(existing);
    }

    public void saveCalendar(Calendar calendar) {
        calendarRepository.save(calendar);
    }

    public void deleteCalendarByID(int eventID) {
        calendarRepository.deleteById(eventID);
    }
}