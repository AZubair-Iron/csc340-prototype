package com.example.demo.calendar;


import jakarta.persistence.*;

@Entity
@Table(name = "calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String participating;

    @Column(nullable = false)
    private String attending;


    public Calendar(int eventID, String name, String date, String location,
                    String participating, String attending){
        this.eventID = eventID;
        this.name = name;
        this.date = date;
        this.location = location;
        this.participating = participating;
        this.attending = attending;
    }

    public Calendar(){}

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getParticipating() {
        return participating;
    }

    public void setParticipating(String participating) {
        this.participating = participating;
    }

    public String getAttending() {
        return attending;
    }

    public void setAttending(String attending) {
        this.attending = attending;
    }
}